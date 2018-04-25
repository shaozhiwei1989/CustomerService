/*
 * FileName: GroupUser.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra.im.model;

import java.io.Serializable;

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
 * 2018年3月2日 上午9:54:05          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
public class GroupUser implements Serializable {
    private static final long serialVersionUID = -4090529142393091485L;
    private Long id;
    private String account;
    private String name;
    private String groupId;

    public GroupUser(String account, String name) {
        this.account = account;
        this.name = name;
    }

    public GroupUser() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

}
