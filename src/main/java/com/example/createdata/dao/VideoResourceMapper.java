package com.example.createdata.dao;

import com.example.createdata.model.VideoResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface VideoResourceMapper {
	@Select("SELECT group_id FROM info_video_resource WHERE resource_id = #{resource_id}")
	public Integer getRegionId(@RequestParam("resource_id") Integer resource_id);
	@Select("SELECT resource_id,group_id,point FROM info_video_resource")
	public List<VideoResource> getVideoResource();
	
}