package com.example.createdata.task;

import com.alibaba.fastjson.JSON;
import com.example.createdata.dao.VideoResourceGroupMapper;
import com.example.createdata.dao.VideoResourceMapper;
import com.example.createdata.elastic.SaveData;
import com.example.createdata.entity.*;
import com.example.createdata.model.VideoResourceGroup;
import com.sensetime.iva.senseface.beans.cache.Camera;
import com.sensetime.iva.senseface.beans.cache.Target;
import com.sensetime.iva.senseface.beans.common.Angle;
import com.sensetime.iva.senseface.beans.common.DetectType;
import com.sensetime.iva.senseface.beans.common.Image;
import com.sensetime.iva.senseface.beans.common.Vertex;
import com.sensetime.iva.senseface.beans.push.PushDetectInfo;
import com.sensetime.iva.senseface.beans.push.PushTaskInfo;
import com.sensetime.iva.senseface.beans.realtime.DetectTaskRecognisedInfo;
import com.sensetime.iva.senseface.beans.realtime.DetectTaskResultInfo;
import com.sensetime.iva.senseface.beans.realtime.FaceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName: TaskExecutor
 * @Description: 根据接收的kafka消息进行处理的类
 * @author lfl4017
 * @date 2018年6月9日
 * 
 */
@Component
@Transactional
public class TaskExecutor {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final Logger log = LoggerFactory.getLogger(TaskExecutor.class);

	@Autowired
	private VideoResourceMapper videoResourceMapper;
	@Autowired
	private VideoResourceGroupMapper videoResourceGroupMapper;

	@Autowired
	private SaveData saveData;

	// @Async("asyncExecutor")
	@SuppressWarnings("deprecation")
	public void executeMessage(String message) {
		log.info("接收kafka消息为：" + message);
		PushDetectInfo detectInfo = JSON.parseObject(message, PushDetectInfo.class);

		List<PushTaskInfo> taskInfos = detectInfo.getTaskInfos();
		PushTaskInfo taskInfo = taskInfos.get(0);
		DetectType detectType = taskInfo.getDetectType();
		if(detectType.getCode().equals("alarm")) {
			HistoryInfo historyInfo = new HistoryInfo();
			// 对象id
			historyInfo.setId(UUID.randomUUID().toString().replace("-", ""));

			CapturedInfo capturedInfo = new CapturedInfo();
			capturedInfo.setCapturedTime(detectInfo.getCapturedTime());
			capturedInfo.setCapturedDate(dateFormat.format(new Date(detectInfo.getCapturedTime())));

			FaceInfo faceInfo = detectInfo.getFaceInfo();

			if (null != faceInfo) {
				// 跟踪id
				capturedInfo.setTrackId(StringUtils.isEmpty(faceInfo.getTrackId()) ? "" : faceInfo.getTrackId() + "");

				// 左上角
				PointInfo letTop = new PointInfo();
				Vertex vertexTop = faceInfo.getStart();
				letTop.setX(vertexTop.getX());
				letTop.setY(vertexTop.getY());
				capturedInfo.setLetTop(letTop);

				// 右下角
				PointInfo rightBottom = new PointInfo();
				Vertex vertexBottom = faceInfo.getEnd();
				rightBottom.setX(vertexBottom.getX());
				rightBottom.setY(vertexBottom.getY());
				capturedInfo.setRightBottom(rightBottom);

				// 抓拍图角度信息
				AngleInfo angleInfo = new AngleInfo();
				Angle angle = faceInfo.getAngle();
				angleInfo.setPitch(angle.getPitch());
				angleInfo.setRoll(angle.getRoll());
				angleInfo.setYaw(angle.getYaw());
				capturedInfo.setAngle(angleInfo);

				// 抓拍图的图片质量得分
				capturedInfo.setQuality(faceInfo.getQuality().doubleValue());
			}

			// 抓拍图信息
			ImageInfo imageInfo = new ImageInfo();
			Image image = detectInfo.getImage();
			if (null != image) {
				imageInfo.setHeight(image.getHeight());
				imageInfo.setWidth(image.getWidth());
				imageInfo.setUrl(image.getUrl());
			}
			capturedInfo.setImage(imageInfo);

			Camera camera = detectInfo.getCamera();

			// 获取区域id
			Integer regionId = videoResourceMapper.getRegionId(camera.getId().intValue());

			VideoResourceGroup videoResourceGroup = videoResourceGroupMapper.queryResourceGroupById(regionId);

			// 开始相机信息
			CameraInfo startCamera = new CameraInfo();
			startCamera.setCameraId(camera.getId() + "");
			startCamera.setCameraLocation("");
			startCamera.setCameraName(camera.getName());

			if (!StringUtils.isEmpty(videoResourceGroup)) {
				startCamera.setRegionId(videoResourceGroup.getGroupId() + "");
				startCamera.setRegionName(videoResourceGroup.getName() + "");
				startCamera.setFloorId(videoResourceGroup.getParentId() + "");
				startCamera.setFloorName("");
				RegionInfo startRegionInfo = new RegionInfo();
				startRegionInfo.setFloorId(videoResourceGroup.getParentId() + "");
				startRegionInfo.setFloorName("");
				startRegionInfo.setRegionId(videoResourceGroup.getGroupId() + "");
				startRegionInfo.setRegionName(videoResourceGroup.getName() + "");

				capturedInfo.setStartRegion(startRegionInfo);
			}
			capturedInfo.setStartCamera(startCamera);
			historyInfo.setCapturedInfo(capturedInfo);

			List<PushTaskInfo> pushTaskInfos = detectInfo.getTaskInfos();

			for (PushTaskInfo pushTaskInfo : pushTaskInfos) {
				// vip
				historyInfo.setPersonType(pushTaskInfo.getDetectType().getIndex() + "");
				List<DetectTaskRecognisedInfo> detectTaskRecognisedInfos = pushTaskInfo.getRecognisedInfos();
				for (DetectTaskRecognisedInfo detectTaskRecognisedInfo : detectTaskRecognisedInfos) {
					List<DetectTaskResultInfo> detectTaskResultInfos = detectTaskRecognisedInfo.getSimilars();
					for (DetectTaskResultInfo detectTaskResultInfo : detectTaskResultInfos) {
						Target target = detectTaskResultInfo.getTarget();
						// TargetInfo
						TargetInfo targetInfo = new TargetInfo();
						targetInfo.setId(target.getId().toString());
						targetInfo.setName(target.getName());
						targetInfo.setAliasName("");
						targetInfo.setAge(new Date().getYear() - new Date(target.getBirthday()).getYear());
						targetInfo.setBirthday(dateFormat.format(new Date(target.getBirthday())));
						targetInfo.setNationality("");
						targetInfo.setTarLibName(target.getTarLibName());
						targetInfo.setTarLibSerial(target.getTarLibSerial());
						targetInfo.setCreateTime(target.getCreateTime().toString());
						targetInfo.setImageUrl(target.getUrl());
						targetInfo.setGender(target.getGender());
						targetInfo.setAddress("");
						targetInfo.setScore(detectTaskResultInfo.getScore().doubleValue());

						historyInfo.setTargetInfo(targetInfo);
						break;
					}
				}
			}
			saveData.save(historyInfo);
		}
	}

}
