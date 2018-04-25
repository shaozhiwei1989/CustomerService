/*
 * FileName: CustomerServiceImpl.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra.cs.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ultra.cs.dao.CustomerDao;
import com.ultra.cs.model.CusAccountConfig;
import com.ultra.cs.model.CustomerConfig;
import com.ultra.cs.params.CsAssignParam;
import com.ultra.cs.params.CsTransferParam;
import com.ultra.cs.service.CustomerService;
import com.ultra.exception.SystemException;
import com.ultra.im.model.GroupUser;
import com.ultra.im.params.GroupParam;
import com.ultra.im.service.GroupService;
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
 * 2018年1月23日 下午2:56:49          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private GroupService groupService;

    @Override
    public GroupVo assignCustomer(CsAssignParam param) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("system", param.getSystem());
        params.put("type", param.getType());
        CustomerConfig config = customerDao.findCustomerConfig(params);
        CusAccountConfig nextAccount = findNextAccount(config);
        config.setCurrentAccount(nextAccount.getAccount());
        customerDao.updateCurrentAccount(config);

        List<GroupUser> users = new ArrayList<GroupUser>();
        users.add(new GroupUser(param.getUserAccount(), param.getUserName()));
        users.add(new GroupUser(nextAccount.getAccount(), nextAccount.getName()));
        GroupVo group = groupService.createGroup(new GroupParam(param.getSystem(), param.getUserAccount(), true, users));
        return group;
    }

    @Override
    public void transferToOtherCs(CsTransferParam param) {
        groupService.joinGroup(param.getGroupId(), param.getUsers());
    }

    @Override
    public void addCustomerConfig(CustomerConfig config) {
        customerDao.insert(config);
    }

    @Override
    public void modify(CustomerConfig config) {
        customerDao.update(config);
    }

    @Override
    public void delete(long id) {
        customerDao.delete(id);
        customerDao.deleteCusAccountConfigByCusConfigId(id);
    }

    @Override
    public PageData<CustomerConfig> findCustomerConfigPage(int pageNo, int pageSize) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("offset", (pageNo - 1) * pageSize);
        params.put("limit", pageSize);
        List<CustomerConfig> configs = customerDao.listCustomerConfig(params);
        int total = customerDao.getCustomerConfigTotal(params);
        return new PageData<CustomerConfig>(200, configs, total, pageNo, pageSize);
    }

    @Override
    public void addCusAccounts(long cusConfigId, List<CusAccountConfig> cusAccountConfigs) {
        for (CusAccountConfig cusAccount : cusAccountConfigs) {
            cusAccount.setCusConfigId(cusConfigId);
            customerDao.insertCusAccountConfig(cusAccount);
        }
    }

    @Override
    public void modifyCusAccountById(CusAccountConfig cusAccountConfig) {
        customerDao.updateCusAccountConfigById(cusAccountConfig);
    }

    @Override
    public void deleteCusAccountById(long id) {
        customerDao.deleteCusAccountConfigById(id);
    }

    @Override
    public PageData<CusAccountConfig> findCusAccountPage(long cusConfigId, int pageNo, int pageSize) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("offset", (pageNo - 1) * pageSize);
        params.put("limit", pageSize);
        params.put("cusConfigId", cusConfigId);
        List<CusAccountConfig> configs = customerDao.listCusAccountConfig(params);
        int total = customerDao.getCusAccountConfigTotal(params);
        return new PageData<CusAccountConfig>(200, configs, total, pageNo, pageSize);
    }

    private CusAccountConfig findNextAccount(CustomerConfig config) {
        List<CusAccountConfig> accounts = config.getAccounts();
        if (accounts == null || accounts.isEmpty()) {
            throw new SystemException("此系统的问题分类还没有配置客服人员，请联系管理员。");
        }
        int index = -1;
        for (int i = 0; i < accounts.size(); i++) {
            CusAccountConfig cusAccount = accounts.get(i);
            if (cusAccount.getAccount().equals(config.getCurrentAccount())) {
                index = i;
                break;
            }
        }
        if (index == -1 || (index + 1) >= accounts.size()) {
            return accounts.get(0);
        }
        return accounts.get(index + 1);
    }

}
