package com.example.createdata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @ClassName: RegionInfo  
* @Description: 区域详情
* @author liufulu_vendor  
* @date 2018年9月7日  
*
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegionInfo {

	/**
	 * 区域id
	 */
	private String regionId;
	/**
	 * 区域名称
	 */
	private String regionName;
	/**
	 * 区域所在楼层id
	 */
	private String floorId;
	
	/**
	 * 区域所在楼层
	 */
	private String floorName;
	
}
