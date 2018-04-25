/*
 * FileName: CustomerController.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra.cs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ultra.cs.params.CsAssignParam;
import com.ultra.cs.params.CsTransferParam;
import com.ultra.cs.service.CustomerService;
import com.ultra.im.vo.GroupVo;
import com.ultra.vo.RespData;

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
 * 2018年1月23日 下午3:08:33          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @ResponseBody
    @RequestMapping(value = "/assign", method = RequestMethod.POST)
    public RespData<GroupVo> assign(@RequestBody CsAssignParam param) {
        try {
            GroupVo group = customerService.assignCustomer(param);
            return new RespData<GroupVo>(200, group);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespData<GroupVo>(500, e.getMessage(), null);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public RespData<String> transfer(@RequestBody CsTransferParam param) {
        try {
            customerService.transferToOtherCs(param);
            return new RespData<String>(200, "客服转接成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new RespData<String>(500, e.getMessage(), null);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/test")
    public RespData<GroupVo> test() {
        try {
            CsAssignParam param = new CsAssignParam();
            param.setUserAccount("ceshi1");
            param.setUserName("测试1");
            param.setSystem("沃易售");
            param.setType("业务问题");
            GroupVo group = customerService.assignCustomer(param);
            return new RespData<GroupVo>(200, group);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespData<GroupVo>(500, e.getMessage(), null);
        }
    }

}
