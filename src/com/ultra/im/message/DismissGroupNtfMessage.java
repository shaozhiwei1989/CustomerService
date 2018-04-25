/*
 * FileName: DismissGroupNtfMessage.java
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
 * 2018年3月9日 下午4:10:51          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
public class DismissGroupNtfMessage extends GroupNtfMessage {

    public DismissGroupNtfMessage(String userId, String userName) {
        JsonBuilder builder = JsonBuilder.create();
        builder.add("operatorNickname", userName);
        initValue(userId, "Rename", builder.toJsonString(), "解散群组", "");
    }
}
