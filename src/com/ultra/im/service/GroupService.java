/*
 * FileName: GroupService.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra.im.service;

import java.util.List;

import com.ultra.im.model.Group;
import com.ultra.im.model.GroupUser;
import com.ultra.im.params.GroupParam;
import com.ultra.im.vo.GroupVo;

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
 * 2018年3月2日 下午3:04:49          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
public interface GroupService {

    /**
     * 创建群组
     * @param gName
     * @return
     */
    public GroupVo createGroup(GroupParam group);

    /**
     * 获得群组信息</br>用于群组信息提供者
     * @param groupId 群id
     * @return
     */
    public Group getGroupInfo(String groupId);

    /**
     *群详情信息</br>用于查看群信息页面
     * @param groupId
     * @return
     */
    public GroupVo getGroupDetail(String groupId, String loginAccount);

    /**
     * 退出群组
     * @param groupId 群id
     * @param account 退出人帐号
     */
    public void quitGroup(String groupId, String userId);

    /**
     * 解散群
     * @param groupId 群组id
     * @param userId 解散群组人
     */
    public void dismissGroup(String groupId, String userId);

    /***
     *加入群
     * @param groupId
     * @param joinUsers
     */
    public void joinGroup(String groupId, List<GroupUser> joinUsers);

    /**
     * 修改群名称
     * @param groupId
     * @param groupName
     */
    public void modifyGroupName(String groupId, String groupName);
}
