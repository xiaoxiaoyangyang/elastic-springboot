package com.example.createdata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * 
* @ClassName: CapturedInfo  
* @Description: 抓拍对象的详细信息
* @author liufulu_vendor  
* @date 2018年9月7日  
*
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CapturedInfo {
	/**
	 * 抓拍时间戳
	 */
	private Long capturedTime;
	
	/**
	 * 抓拍日期
	 */
	@Field(fielddata = true,type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis")
	private String capturedDate;
	
	/**
	 * 在开始相机的停留时间,精确到分钟
	 */
	private Long stayTime;
	/**
	 * 跟踪id
	 */
	private String trackId;
	
	/*
	 * 抓拍状态 status 1 代表第一次被抓拍  
	 */
	private String status;
	
	/**
	 * 抓拍图信息
	 */
	private ImageInfo image;
	
	/**
	 * 左上角
	 */
	private PointInfo letTop;
	
	/**
	 * 右下角
	 */
	private PointInfo rightBottom;
	
	/**
	 * 抓拍图角度信息
	 */
	private AngleInfo angle;
	/**
	 * 抓拍图的图片质量得分
	 */
	private Double quality;
	/**
	 * 开始相机信息
	 */
	private CameraInfo startCamera;
	
	/**
	 * 终止相机信息
	 */
	private CameraInfo endCamera;
	
	/**
	 * 开始区域信息
	 */
	private RegionInfo startRegion;
	
	/**
	 * 终止区域信息
	 */
	private RegionInfo endRegion;
	
}
