package com.example.createdata.dao;

import com.example.createdata.model.VideoResourceGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface VideoResourceGroupMapper {
	@Select("SELECT group_id groupId,`name` name,parent_id parentId FROM info_video_resource_group WHERE group_id = #{group_id}")
	public VideoResourceGroup queryResourceGroupById(@RequestParam("group_id") Integer regionId);
	
	@Select("SELECT group_id groupId,region FROM info_video_resource_group where parent_id !=0")
	public List<VideoResourceGroup> getResourceGroupList();
	
}