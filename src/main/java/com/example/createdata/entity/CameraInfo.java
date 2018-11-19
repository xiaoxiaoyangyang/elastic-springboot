package com.example.createdata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @ClassName: CameraInfo  
* @Description: 相机详细信息
* @author liufulu_vendor  
* @date 2018年9月7日  
*
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CameraInfo {
	/**
	 * 相机名称
	 */
	private String cameraName;
	
	/**
	 * 相机id
	 */
	private String cameraId;
	
	/**
	 * 相机所在位置
	 */
	private String cameraLocation;
	
	/**
	 * 相机所属的区域的名字
	 */
	private String regionName;
	
	/**
	 * 相机所属的区域的id
	 */
	private String regionId;
	
	/**
	 * 区域所在楼层id
	 */
	private String floorId;
	
	/**
	 * 区域所在楼层
	 */
	private String floorName;
	
}
