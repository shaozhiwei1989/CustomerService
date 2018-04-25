/*
 * FileName: GroupServiceImpl.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra.im.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ultra.cs.dao.CustomerDao;
import com.ultra.exception.SystemException;
import com.ultra.im.IMConstant;
import com.ultra.im.dao.GroupDao;
import com.ultra.im.dao.GroupUserDao;
import com.ultra.im.model.Group;
import com.ultra.im.model.GroupUser;
import com.ultra.im.params.GroupParam;
import com.ultra.im.service.GroupService;
import com.ultra.im.vo.BtnPermissionVo;
import com.ultra.im.vo.GroupVo;

import io.rong.models.CodeSuccessResult;

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
 * 2018年3月2日 下午6:33:53          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
@Service
@Transactional
public class GroupServiceImpl implements GroupService {
    static final Logger logger = Logger.getLogger(GroupServiceImpl.class);
    @Autowired
    private GroupDao groupDao;
    @Autowired
    private GroupUserDao groupUserDao;
    @Autowired
    private CustomerDao customerDao;

    @Override
    public GroupVo createGroup(GroupParam groupParam) {
        if (groupParam.getUsers() == null) {
            throw new SystemException("群里内没有人员不能创建。");
        }
        groupDao.insert(groupParam);
        for (GroupUser user : groupParam.getUsers()) {
            user.setGroupId(groupParam.getId());
            groupUserDao.insert(user);
        }
        createGroup0(groupParam);
        Group group = groupDao.find(groupParam.getId());
        BtnPermissionVo btnVo = findBtnPermission(group, groupParam.getCreator());
        return new GroupVo(group, groupParam.getUsers(), btnVo);
    }

    @Override
    public Group getGroupInfo(String groupId) {
        Group group = groupDao.find(groupId);
        if (group == null) {
            throw new SystemException("Id为" + groupId + "的群组不存在。");
        }
        return group;
    }

    @Override
    public GroupVo getGroupDetail(String groupId, String loginAccount) {
        Group group = groupDao.find(groupId);
        if (group == null) {
            throw new SystemException("Id为" + groupId + "的群组不存在。");
        }
        List<GroupUser> users = groupUserDao.listGroupUserByGroupId(group.getId());
        BtnPermissionVo btnVo = findBtnPermission(group, loginAccount);
        return new GroupVo(group, users, btnVo);
    }

    @Override
    public void quitGroup(String groupId, String userId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("account", userId);
        params.put("groupId", groupId);
        groupUserDao.delete(params);
        quitGroup0(userId, groupId);

        Group group = getGroupInfo(groupId);
        if (!group.isCsGroup() && groupUserDao.getGroupUserTotal(group.getId()) <= 0) {
            dismissGroup(groupId, userId);
        }
    }

    @Override
    public void dismissGroup(String groupId, String userId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("groupId", groupId);
        groupUserDao.delete(params);
        groupDao.delete(groupId);
        dismissGroup0(groupId, userId);
    }

    @Override
    public void joinGroup(String groupId, List<GroupUser> joinUsers) {
        for (GroupUser user : joinUsers) {
            user.setGroupId(groupId);
            groupUserDao.insert(user);
        }
        joinGroup0(groupId, joinUsers);
    }

    @Override
    public void modifyGroupName(String groupId, String groupName) {
        Group group = groupDao.find(groupId);
        group.setName(groupName);
        groupDao.update(group);
        modifyGroupName0(group);
    }

    private BtnPermissionVo findBtnPermission(Group group, String loginAccount) {
        Map<String, Object> sqlParams = new HashMap<String, Object>();
        sqlParams.put("account", loginAccount);
        int cnt = customerDao.getCusAccountConfigTotal(sqlParams);

        BtnPermissionVo btnVo = new BtnPermissionVo();
        btnVo.setTransferBtn((cnt > 0 && group.isCsGroup()) ? 1 : 0);
        return btnVo;
    }

    private void createGroup0(GroupParam group) {
        String[] userIds = new String[group.getUsers().size()];
        for (int i = 0; i < group.getUsers().size(); i++) {
            GroupUser user = group.getUsers().get(i);
            userIds[i] = user.getAccount();
        }
        try {
            CodeSuccessResult codeSuccessResult = IMConstant.RONG_CLOUD.group.create(userIds, group.getId(), group.getName());
            logger.info("createGroup0:" + codeSuccessResult);

            //            GroupNtfMessage grpNtfMessage = new CreateGroupNtfMessage(group.getCreator(), group.getCreatorName(), group.getName());
            //            IMConstant.RONG_CLOUD.message.publishGroup("", new String[] { group.getId() }, grpNtfMessage, "", "", 1, 0, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void quitGroup0(String userId, String groupId) {
        try {
            CodeSuccessResult codeSuccessResult = IMConstant.RONG_CLOUD.group.quit(new String[] { userId }, groupId);
            logger.info("quitGroup0:" + codeSuccessResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dismissGroup0(String groupId, String userId) {
        try {
            CodeSuccessResult codeSuccessResult = IMConstant.RONG_CLOUD.group.dismiss(userId, groupId);
            logger.info("dismissGroup0:" + codeSuccessResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void joinGroup0(String groupId, List<GroupUser> joinUsers) {
        Group group = groupDao.find(groupId);
        String[] userIds = new String[joinUsers.size()];
        for (int i = 0; i < joinUsers.size(); i++) {
            GroupUser user = joinUsers.get(i);
            userIds[i] = user.getAccount();
        }
        try {
            CodeSuccessResult codeSuccessResult = IMConstant.RONG_CLOUD.group.join(userIds, group.getId(), group.getName());
            logger.info("dismissGroup0:" + codeSuccessResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void modifyGroupName0(Group group) {
        try {
            CodeSuccessResult codeSuccessResult = IMConstant.RONG_CLOUD.group.refresh(group.getId(), group.getName());
            logger.info("modifyGroupName0:" + codeSuccessResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
