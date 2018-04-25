/*
 * FileName: CusAccountConfig.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra.cs.model;

import java.io.Serializable;

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
 * 2018年2月9日 下午4:43:32          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
public class CusAccountConfig implements Serializable {
    private static final long serialVersionUID = 1588610817775159799L;
    private Long id;
    private String account;
    private String name;
    private Long cusConfigId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCusConfigId() {
        return cusConfigId;
    }

    public void setCusConfigId(Long cusConfigId) {
        this.cusConfigId = cusConfigId;
    }

}
