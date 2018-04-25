/*
 * FileName: CreateGroupNtfMessage.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra.im.message;

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
 * 2018年3月4日 上午9:48:16          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
public class CreateGroupNtfMessage extends GroupNtfMessage {

    public CreateGroupNtfMessage(String userId, String userName, String groupName) {
        JsonBuilder builder = JsonBuilder.create();
        builder.add("operatorNickname", userName);
        builder.add("targetGroupName", groupName);
        initValue(userId, "Create", builder.toJsonString(), "创建群组", "");
    }

}
