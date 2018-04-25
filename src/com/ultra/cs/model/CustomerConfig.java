/*
 * FileName: CustomerConfig.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra.cs.model;

import java.util.List;

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
 * 2018年1月23日 下午2:02:06          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
public class CustomerConfig {
    private Long id;
    private String system;
    private String type;
    private List<CusAccountConfig> accounts;
    private String currentAccount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<CusAccountConfig> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<CusAccountConfig> accounts) {
        this.accounts = accounts;
    }

    public String getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(String currentAccount) {
        this.currentAccount = currentAccount;
    }

}
