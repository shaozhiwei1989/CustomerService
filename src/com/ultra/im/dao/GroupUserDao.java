/*
 * FileName: GroupUserDao.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra.im.dao;

import java.util.List;
import java.util.Map;

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
 * 2018年3月2日 上午10:19:19          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
public interface GroupUserDao {

    /**
     * 添加
     * @param groupUser
     */
    public void insert(GroupUser groupUser);

    /**
     * 删除
     */
    public void delete(Map<String, Object> params);

    /**
     * 查询群里用户
     * @return
     */
    public List<GroupUser> listGroupUserByGroupId(String groupId);

    /**
     * 获取群组内群成员个数
     * @param groupId
     * @return
     */
    public int getGroupUserTotal(String groupId);
}
