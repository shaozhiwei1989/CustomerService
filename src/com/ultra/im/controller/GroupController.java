/*
 * FileName: GroupController.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra.im.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ultra.im.model.Group;
import com.ultra.im.model.GroupUser;
import com.ultra.im.params.GroupParam;
import com.ultra.im.service.GroupService;
import com.ultra.im.vo.GroupVo;
import com.ultra.vo.RespData;

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
 * 2018年3月3日 下午12:42:08          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
@Controller
@RequestMapping("/im/group")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public RespData<GroupVo> create(@RequestBody GroupParam groupParam) {
        try {
            groupParam.setGroupHolder(groupParam.getCreator());
            groupParam.setCreateTime(new Date());
            groupParam.setCsGroup(false);
            GroupVo group = groupService.createGroup(groupParam);
            return new RespData<GroupVo>(200, group);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespData<GroupVo>(500, e.getMessage(), null);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/get/{groupId}", method = RequestMethod.GET)
    public RespData<Group> get(@PathVariable String groupId) {
        try {
            Group group = groupService.getGroupInfo(groupId);
            return new RespData<Group>(200, group);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespData<Group>(500, e.getMessage(), null);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/detail/{groupId}/{loginAccount}", method = RequestMethod.GET)
    public RespData<GroupVo> detail(@PathVariable String groupId, @PathVariable String loginAccount) {
        try {
            GroupVo group = groupService.getGroupDetail(groupId, loginAccount);
            return new RespData<GroupVo>(200, group);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespData<GroupVo>(500, e.getMessage(), null);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/quit", method = RequestMethod.POST)
    public RespData<String> quit(@RequestBody GroupUser groupUser) {
        try {
            groupService.quitGroup(groupUser.getGroupId(), groupUser.getAccount());
            return new RespData<String>(200, "退出群组成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return new RespData<String>(500, e.getMessage(), "退出群组异常!");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/dismiss", method = RequestMethod.POST)
    public RespData<String> dismiss(@RequestBody GroupUser groupUser) {
        try {
            groupService.dismissGroup(groupUser.getGroupId(), groupUser.getAccount());
            return new RespData<String>(200, "解散群组成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return new RespData<String>(500, e.getMessage(), "解散群组异常!");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public RespData<String> join(@RequestBody GroupParam group) {
        try {
            groupService.joinGroup(group.getId(), group.getUsers());
            return new RespData<String>(200, "加入群组成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return new RespData<String>(500, e.getMessage(), "加入群组异常!");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public RespData<String> modify(@RequestBody GroupParam group) {
        try {
            groupService.modifyGroupName(group.getId(), group.getName());
            return new RespData<String>(200, "修改群名称成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return new RespData<String>(500, e.getMessage(), "修改群名称异常!");
        }
    }

}
