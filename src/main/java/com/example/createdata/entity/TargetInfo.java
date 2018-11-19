package com.example.createdata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @ClassName: TargetInfo  
* @Description: 记录VIP的相关信息
* @author liufulu_vendor  
* @date 2018年9月7日  
*
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TargetInfo {
	/**
	 * VIP的唯一标识
	 */
	private String id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 别名
	 */
	private String aliasName;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 生日
	 */
	private String birthday;
	/**
	 * 国籍
	 */
	private String nationality;
	/**
	 * 目标所在库名
	 */
	private String tarLibName;
	/**
	 * 人像所在人像库id
	 */
	private String tarLibSerial;
	/**
	 * 目标创建时间
	 */
	private String createTime;
	/**
	 * 底图url
	 */
	private String imageUrl;
	/**
	 * 性别
	 */
	private Integer gender;
	/**
	 * 地址
	 */
	private String address;
	
	/**
	 * 比对分数
	 */
	private Double score;
	
}
