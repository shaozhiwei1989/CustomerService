/*
 * FileName: GroupParam.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra.im.params;

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
 * 2018年3月4日 上午9:41:53          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
public class GroupParam extends Group {
    private static final long serialVersionUID = -249406013959828582L;
    private List<GroupUser> users;
    private String creator;
    private String creatorName;

    public GroupParam(String name, String groupHolder, boolean isCsGroup, List<GroupUser> users) {
        super(name, groupHolder, isCsGroup);
        this.users = users;
    }

    public GroupParam() {

    }

    public List<GroupUser> getUsers() {
        return users;
    }

    public void setUsers(List<GroupUser> users) {
        this.users = users;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

}
