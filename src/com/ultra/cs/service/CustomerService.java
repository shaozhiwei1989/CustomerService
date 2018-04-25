/*
 * FileName: CustomerService.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra.cs.service;

import java.util.List;

import com.ultra.cs.model.CusAccountConfig;
import com.ultra.cs.model.CustomerConfig;
import com.ultra.cs.params.CsAssignParam;
import com.ultra.cs.params.CsTransferParam;
import com.ultra.im.vo.GroupVo;
import com.ultra.vo.PageData;

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
 * 2018年1月23日 下午2:52:41          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
public interface CustomerService {

    /**
     * 分派客服人员
     * @param sytem 系统
     * @param type 业务类型
     * @return 客服人员帐号
     */
    public GroupVo assignCustomer(CsAssignParam param);

    /**
     * 客服其他转接
     * @param param
     */
    public void transferToOtherCs(CsTransferParam param);

    /**
     * 添加
     * @param config
     */
    public void addCustomerConfig(CustomerConfig config);

    /**
     * 更新
     * @param config
     */
    public void modify(CustomerConfig config);

    /**
     * 删除
     * @param config
     */
    public void delete(long id);

    /**
     * 查询配置分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageData<CustomerConfig> findCustomerConfigPage(int pageNo, int pageSize);

    /**
     * 添加客服人员帐号
     * @param cusConfigId 主配置id
     * @param cusAccounts 帐号对象
     */
    public void addCusAccounts(long cusConfigId, List<CusAccountConfig> cusAccounts);

    /**
     * 更新客服人员帐号
     * @param cusAccountConfig
     */
    public void modifyCusAccountById(CusAccountConfig cusAccountConfig);

    /**
     * 删除客服人员帐号
     * @param id
     */
    public void deleteCusAccountById(long id);

    /**
     * 查询帐号分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageData<CusAccountConfig> findCusAccountPage(long cusConfigId, int pageNo, int pageSize);

}
