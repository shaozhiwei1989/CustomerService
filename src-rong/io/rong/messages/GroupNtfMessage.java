/*
 * FileName: GroupNtfMessage.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package io.rong.messages;

import io.rong.util.GsonUtil;

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
 * 2017年8月10日 下午5:05:14          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
public class GroupNtfMessage extends BaseMessage {
    private String operatorUserId;
    private String operation;
    private String data;
    private String message;
    private String extra;
    private transient static final String TYPE = "RC:GrpNtf";

    public void initValue(String operatorUserId, String operation, String data, String message, String extra) {
        this.operatorUserId = operatorUserId;
        this.operation = operation;
        this.data = data;
        this.message = message;
        this.extra = extra;
    }

    public String getOperatorUserId() {
        return operatorUserId;
    }

    public void setOperatorUserId(String operatorUserId) {
        this.operatorUserId = operatorUserId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public String toString() {
        return GsonUtil.toJson(this, GroupNtfMessage.class);
    }

}
