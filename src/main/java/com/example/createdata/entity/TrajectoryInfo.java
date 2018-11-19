package com.example.createdata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

/**
 * 
* @ClassName: TrajectoryInfo  
* @Description: 轨迹对象的详细信息
* @author liufulu_vendor  
* @date 2018年9月7日  
*
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "#{esIndex.index}", type = "trajectory", shards = 3, replicas = 2)
public class TrajectoryInfo {
	@Id
	private String id;
	/*
	 *  VIP 用户ID
	 */
	private String userId;
	
	private List<String> trajectoryList;
	
	/*
	 * 轨迹时间戳
	 */
	private Long trajectoryTime;
	/*
	 * 轨迹时间
	 */
	private String trajectoryDate;
	
	
}
