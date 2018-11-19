package com.example.createdata.model;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "info_video_resource_group")
public class VideoResourceGroup {
    /**
     * 楼层的地图的信息
     */
    /*@Column(name = "region_map")
    private String regionMap;

    public String getRegionMap() {
        return regionMap;
    }

    public void setRegionMap(String regionMap) {
        this.regionMap = regionMap;
    }*/

    /**
     * 分组ID
     */
    @Column(name = "group_id")
    private Integer groupId;

    /**
     * 组织机构id
     */
    @Column(name = "organ_id")
    private Integer organId;

    /**
     * 名称
     */
    private String name;

    /**
     * 区域坐标json串
     */
    private String region;

    /**
     * 编码
     */
    private String code;

    /**
     * 递归字段
     */
    private String path;

    /**
     * 父级分组id
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 备注字段
     */
    private String remark;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 创建人
     */
    private Long creator;

    /**
     * 创建人名称
     */
    @Column(name = "creator_name")
    private String creatorName;

    /**
     * 更新人
     */
    @Column(name = "update_user")
    private Long updateUser;

    /**
     * 删除标记0--删除
     */
    private Integer status;

    /**
     * 地图层级
     */
    @Column(name = "zoom_level")
    private Integer zoomLevel;

    /**
     * 中心点经度
     */
    @Column(name = "center_longitude")
    private String centerLongitude;

    /**
     * 中心点纬度
     */
    @Column(name = "center_latitude")
    private String centerLatitude;


    /**
     * 获取分组ID
     *
     * @return group_id - 分组ID
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * 设置分组ID
     *
     * @param groupId 分组ID
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取组织机构id
     *
     * @return organ_id - 组织机构id
     */
    public Integer getOrganId() {
        return organId;
    }

    /**
     * 设置组织机构id
     *
     * @param organId 组织机构id
     */
    public void setOrganId(Integer organId) {
        this.organId = organId;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取区域坐标json串
     *
     * @return region - 区域坐标json串
     */
    public String getRegion() {
        return region;
    }

    /**
     * 设置区域坐标json串
     *
     * @param region 区域坐标json串
     */
    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    /**
     * 获取编码
     *
     * @return code - 编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置编码
     *
     * @param code 编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取递归字段
     *
     * @return path - 递归字段
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置递归字段
     *
     * @param path 递归字段
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * 获取父级分组id
     *
     * @return parent_id - 父级分组id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父级分组id
     *
     * @param parentId 父级分组id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取备注字段
     *
     * @return remark - 备注字段
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注字段
     *
     * @param remark 备注字段
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取创建人
     *
     * @return creator - 创建人
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * 设置创建人
     *
     * @param creator 创建人
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * 获取创建人名称
     *
     * @return creator_name - 创建人名称
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * 设置创建人名称
     *
     * @param creatorName 创建人名称
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName == null ? null : creatorName.trim();
    }

    /**
     * 获取更新人
     *
     * @return update_user - 更新人
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * 设置更新人
     *
     * @param updateUser 更新人
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 获取删除标记0--删除
     *
     * @return status - 删除标记0--删除
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置删除标记0--删除
     *
     * @param status 删除标记0--删除
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取地图层级
     *
     * @return zoom_level - 地图层级
     */
    public Integer getZoomLevel() {
        return zoomLevel;
    }

    /**
     * 设置地图层级
     *
     * @param zoomLevel 地图层级
     */
    public void setZoomLevel(Integer zoomLevel) {
        this.zoomLevel = zoomLevel;
    }

    /**
     * 获取中心点经度
     *
     * @return center_longitude - 中心点经度
     */
    public String getCenterLongitude() {
        return centerLongitude;
    }

    /**
     * 设置中心点经度
     *
     * @param centerLongitude 中心点经度
     */
    public void setCenterLongitude(String centerLongitude) {
        this.centerLongitude = centerLongitude == null ? null : centerLongitude.trim();
    }

    /**
     * 获取中心点纬度
     *
     * @return center_latitude - 中心点纬度
     */
    public String getCenterLatitude() {
        return centerLatitude;
    }

    /**
     * 设置中心点纬度
     *
     * @param centerLatitude 中心点纬度
     */
    public void setCenterLatitude(String centerLatitude) {
        this.centerLatitude = centerLatitude == null ? null : centerLatitude.trim();
    }
}