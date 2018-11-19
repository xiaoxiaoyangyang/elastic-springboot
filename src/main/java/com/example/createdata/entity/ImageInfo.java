package com.example.createdata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @ClassName: Image
 * @Description: 人像图片信息
 * @author liufulu_vendor
 * @date 2018年9月7日
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageInfo {

	// 图片 URL
	private String url;

	// 图片宽度
	private Integer width;

	// 图片高度
	private Integer height;
}
