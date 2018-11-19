package com.example.createdata.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "#{esIndex.index}", type = "mallhistory", shards = 3, replicas = 2)
public class HistoryInfo {

	/**
	 * 对象唯一表示uuid
	 */
	@Id
	private String id;
	
	/**
	 * 该人员的类型：VIP&ordinary(普通顾客)	1代表VIP,0代表ordinary
	 */
	private String personType;
	
	/**
	 * 目标详细信息(VIP才会有详细信息)
	 */
	private TargetInfo targetInfo;
	
	/**
	 * 抓拍对象详细信息
	 */
	private CapturedInfo capturedInfo;
	
	
}
