/*
 * FileName: JoinGroupNtfMessage.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra.im.message;

import java.util.ArrayList;
import java.util.List;

import com.ultra.im.model.GroupUser;
import com.ultra.utils.JsonBuilder;

import io.rong.messages.GroupNtfMessage;

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
 * 2018年3月9日 下午3:18:38          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
public class JoinGroupNtfMessage extends GroupNtfMessage {

    public JoinGroupNtfMessage(String userId, String userName, List<GroupUser> joinUsers) {
        List<String> userIds = new ArrayList<String>();
        List<String> userNames = new ArrayList<String>();
        for (GroupUser user : joinUsers) {
            userIds.add(user.getAccount());
            userIds.add(user.getName());
        }
        JsonBuilder builder = JsonBuilder.create();
        builder.add("operatorNickname", userName);
        builder.add("targetUserIds", userIds);
        builder.add("targetUserDisplayNames", userNames);
        initValue(userId, "Add", builder.toJsonString(), "添加群成员", "");
    }
}
