package com.example.createdata.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "info_video_resource")
public class VideoResource {
    /**
     * 视频源ID
     */
	@Id
    @Column(name = "resource_id")
    private Long resourceId;

    /**
     * 视频源类型ID
     */
    @Column(name = "resource_type_id")
    private Long resourceTypeId;

    /**
     * 摄像头类型
     */
    private Integer type;

    /**
     * 播放方式
     */
    @Column(name = "play_type")
    private Integer playType;

    /**
     * 是否转码：0，默认为直连；1为转码
     */
    @Column(name = "is_decode")
    private Integer isDecode;

    /**
     * 网络协议类型
     */
    @Column(name = "protocol_type")
    private Short protocolType;

    /**
     * 名称
     */
    private String name;

    /**
     * 系统编码
     */
    private String code;

    /**
     * 设备编码
     */
    @Column(name = "device_code")
    private String deviceCode;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 地址
     */
    private String address;

    /**
     * 视频地址
     */
    private String path;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 接入状态（0--未接入，1-已接入）
     */
    @Column(name = "access_status")
    private Integer accessStatus;

    /**
     * 运行状态（0--离线，1--在线）
     */
    @Column(name = "run_status")
    private Integer runStatus;

    /**
     * 创建人
     */
    private Long creator;

    /**
     * 组织结构ID
     */
    @Column(name = "organ_id")
    private Long organId;

    /**
     * 来源ID
     */
    @Column(name = "source_id")
    private Long sourceId;

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
     * 备注
     */
    private String remark;

    /**
     * 分组id
     */
    @Column(name = "group_id")
    private Integer groupId;

    /**
     * 抓拍机用户名
     */
    private String username;

    /**
     * 抓拍机密码
     */
    private String password;

    /**
     * 平台服务serial
     */
    @Column(name = "platform_serial")
    private String platformSerial;
    
    @Column(name = "point")
    private String point;

    /**
     * 获取视频源ID
     *
     * @return resource_id - 视频源ID
     */
    public Long getResourceId() {
        return resourceId;
    }

    /**
     * 设置视频源ID
     *
     * @param resourceId 视频源ID
     */
    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * 获取视频源类型ID
     *
     * @return resource_type_id - 视频源类型ID
     */
    public Long getResourceTypeId() {
        return resourceTypeId;
    }

    /**
     * 设置视频源类型ID
     *
     * @param resourceTypeId 视频源类型ID
     */
    public void setResourceTypeId(Long resourceTypeId) {
        this.resourceTypeId = resourceTypeId;
    }

    /**
     * 获取摄像头类型
     *
     * @return type - 摄像头类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置摄像头类型
     *
     * @param type 摄像头类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取播放方式
     *
     * @return play_type - 播放方式
     */
    public Integer getPlayType() {
        return playType;
    }

    /**
     * 设置播放方式
     *
     * @param playType 播放方式
     */
    public void setPlayType(Integer playType) {
        this.playType = playType;
    }

    /**
     * 获取是否转码：0，默认为直连；1为转码
     *
     * @return is_decode - 是否转码：0，默认为直连；1为转码
     */
    public Integer getIsDecode() {
        return isDecode;
    }

    /**
     * 设置是否转码：0，默认为直连；1为转码
     *
     * @param isDecode 是否转码：0，默认为直连；1为转码
     */
    public void setIsDecode(Integer isDecode) {
        this.isDecode = isDecode;
    }

    /**
     * 获取网络协议类型
     *
     * @return protocol_type - 网络协议类型
     */
    public Short getProtocolType() {
        return protocolType;
    }

    /**
     * 设置网络协议类型
     *
     * @param protocolType 网络协议类型
     */
    public void setProtocolType(Short protocolType) {
        this.protocolType = protocolType;
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
     * 获取系统编码
     *
     * @return code - 系统编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置系统编码
     *
     * @param code 系统编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取设备编码
     *
     * @return device_code - 设备编码
     */
    public String getDeviceCode() {
        return deviceCode;
    }

    /**
     * 设置设备编码
     *
     * @param deviceCode 设备编码
     */
    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode == null ? null : deviceCode.trim();
    }

    /**
     * 获取经度
     *
     * @return longitude - 经度
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * 设置经度
     *
     * @param longitude 经度
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    /**
     * 获取纬度
     *
     * @return latitude - 纬度
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * 设置纬度
     *
     * @param latitude 纬度
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取视频地址
     *
     * @return path - 视频地址
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置视频地址
     *
     * @param path 视频地址
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取接入状态（0--未接入，1-已接入）
     *
     * @return access_status - 接入状态（0--未接入，1-已接入）
     */
    public Integer getAccessStatus() {
        return accessStatus;
    }

    /**
     * 设置接入状态（0--未接入，1-已接入）
     *
     * @param accessStatus 接入状态（0--未接入，1-已接入）
     */
    public void setAccessStatus(Integer accessStatus) {
        this.accessStatus = accessStatus;
    }

    /**
     * 获取运行状态（0--离线，1--在线）
     *
     * @return run_status - 运行状态（0--离线，1--在线）
     */
    public Integer getRunStatus() {
        return runStatus;
    }

    /**
     * 设置运行状态（0--离线，1--在线）
     *
     * @param runStatus 运行状态（0--离线，1--在线）
     */
    public void setRunStatus(Integer runStatus) {
        this.runStatus = runStatus;
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
     * 获取组织结构ID
     *
     * @return organ_id - 组织结构ID
     */
    public Long getOrganId() {
        return organId;
    }

    /**
     * 设置组织结构ID
     *
     * @param organId 组织结构ID
     */
    public void setOrganId(Long organId) {
        this.organId = organId;
    }

    /**
     * 获取来源ID
     *
     * @return source_id - 来源ID
     */
    public Long getSourceId() {
        return sourceId;
    }

    /**
     * 设置来源ID
     *
     * @param sourceId 来源ID
     */
    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
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
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取分组id
     *
     * @return group_id - 分组id
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * 设置分组id
     *
     * @param groupId 分组id
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取抓拍机用户名
     *
     * @return username - 抓拍机用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置抓拍机用户名
     *
     * @param username 抓拍机用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取抓拍机密码
     *
     * @return password - 抓拍机密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置抓拍机密码
     *
     * @param password 抓拍机密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取平台服务serial
     *
     * @return platform_serial - 平台服务serial
     */
    public String getPlatformSerial() {
        return platformSerial;
    }

    /**
     * 设置平台服务serial
     *
     * @param platformSerial 平台服务serial
     */
    public void setPlatformSerial(String platformSerial) {
        this.platformSerial = platformSerial == null ? null : platformSerial.trim();
    }

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}
    
    
}