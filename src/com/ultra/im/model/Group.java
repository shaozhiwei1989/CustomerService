/*
 * FileName: Group.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra.im.model;

import java.io.Serializable;
import java.util.Date;

import com.ultra.utils.WebUtils;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zhiweishao
 * @version 4.1

 * <p>
 * History:
 *
 * Date                     Author         Version     Description
 * ---------------------------------------------------------------------------------
 * 2018年3月2日 上午9:45:42          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
public class Group implements Serializable {
    private static final long serialVersionUID = 1471863160807219501L;
    private String id;
    private String name;//群名称
    private String groupHolder;//群主帐号
    private String headPortraitUrl;//头像URL
    private boolean isCsGroup;//是否客服会话群
    private Date createTime;//创建时间

    public Group(String name, String groupHolder, boolean isCsGroup) {
        this(name, groupHolder, null, isCsGroup);
    }

    public Group(String name, String groupHolder, String headPortraitUrl, boolean isCsGroup) {
        this.name = name;
        this.groupHolder = groupHolder;
        this.headPortraitUrl = getHeadPortraitUrl0(headPortraitUrl);
        this.isCsGroup = isCsGroup;
        this.createTime = new Date();
    }

    public Group() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupHolder() {
        return groupHolder;
    }

    public void setGroupHolder(String groupHolder) {
        this.groupHolder = groupHolder;
    }

    public String getHeadPortraitUrl() {
        return headPortraitUrl;
    }

    public void setHeadPortraitUrl(String headPortraitUrl) {
        this.headPortraitUrl = headPortraitUrl;
    }

    public boolean isCsGroup() {
        return isCsGroup;
    }

    public void setCsGroup(boolean isCsGroup) {
        this.isCsGroup = isCsGroup;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private String getHeadPortraitUrl0(String headPortraitUrl) {
        if (WebUtils.getAppBasePath() != null && headPortraitUrl == null) {
            return WebUtils.getAppBasePath() + "/images/default_head_portrait.png";
        }
        return headPortraitUrl;
    }

}
