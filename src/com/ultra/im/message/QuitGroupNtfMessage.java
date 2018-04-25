/*
 * FileName: QuitGroupNtfMessage.java
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
 * 2018年3月9日 下午3:38:37          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
public class QuitGroupNtfMessage extends GroupNtfMessage {

    public QuitGroupNtfMessage(String userId, String userName, boolean isGroupHolder) {
        JsonBuilder builder = JsonBuilder.create();
        builder.add("operatorNickname", userName);
        builder.add("targetUserIds", new String[] { userId });
        builder.add("targetUserDisplayNames", new String[] { userName });
        builder.add("newCreatorId", isGroupHolder ? userId : null);
        initValue(userId, "Quit", builder.toJsonString(), "退出群组", "");
    }
}
