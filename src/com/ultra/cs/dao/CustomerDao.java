/*
 * FileName: CustomerDao.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra.cs.dao;

import java.util.List;
import java.util.Map;

import com.ultra.cs.model.CusAccountConfig;
import com.ultra.cs.model.CustomerConfig;

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
 * 2018年1月23日 下午2:33:32          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
public interface CustomerDao {
    /**
     * 查询客户人员配置
     * @param conf
     * @return
     */
    public CustomerConfig findCustomerConfig(Map<String, Object> params);

    /**
     * 更新当前人的帐号
     * @param conf
     */
    public void updateCurrentAccount(CustomerConfig config);

    /**
     * 添加
     * @param config
     */
    public void insert(CustomerConfig config);

    /**
     * 更新
     * @param config
     */
    public void update(CustomerConfig config);

    /**
     * 删除
     * @param config
     */
    public void delete(long id);

    /**
     * 查询列表
     * @param params
     * @return
     */
    public List<CustomerConfig> listCustomerConfig(Map<String, Object> params);

    /**
     * 查询个数
     * @param params
     * @return
     */
    public int getCustomerConfigTotal(Map<String, Object> params);

    /**
     * 添加客服人员帐号
     * @param cusAccountConfig
     */
    public void insertCusAccountConfig(CusAccountConfig cusAccountConfig);

    /**
     * 更新客服人员帐号
     * @param cusAccountConfig
     */
    public void updateCusAccountConfigById(CusAccountConfig cusAccountConfig);

    /**
     * 删除客服人员帐号
     * @param id
     */
    public void deleteCusAccountConfigById(long id);

    /**
     * 删除客服人员帐号
     * @param cusConfigId 主表配置id
     */
    public void deleteCusAccountConfigByCusConfigId(long cusConfigId);

    /**
     * 查询列表
     * @param params
     * @return
     */
    public List<CusAccountConfig> listCusAccountConfig(Map<String, Object> params);

    /**
     * 查询个数
     * @param params
     * @return
     */
    public int getCusAccountConfigTotal(Map<String, Object> params);

}
