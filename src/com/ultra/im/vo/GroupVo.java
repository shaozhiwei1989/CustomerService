/*
 * FileName: GroupVo.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra.im.vo;

import java.util.List;

import com.ultra.im.model.Group;
import com.ultra.im.model.GroupUser;

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
 * 2018年3月4日 上午9:22:35          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
public class GroupVo {
    private Group group;
    private List<GroupUser> users;
    private BtnPermissionVo btnPermission;

    public GroupVo(Group group, List<GroupUser> users, BtnPermissionVo btnPermission) {
        super();
        this.group = group;
        this.users = users;
        this.btnPermission = btnPermission;
    }

    public GroupVo() {
        super();
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<GroupUser> getUsers() {
        return users;
    }

    public void setUsers(List<GroupUser> users) {
        this.users = users;
    }

    public BtnPermissionVo getBtnPermission() {
        return btnPermission;
    }

    public void setBtnPermission(BtnPermissionVo btnPermission) {
        this.btnPermission = btnPermission;
    }

}
