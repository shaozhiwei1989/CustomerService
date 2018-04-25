/*
 * FileName: InitDbController.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra.init.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ultra.init.service.InitDbService;

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
 * 2018年2月1日 下午8:16:09          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
@Controller
@RequestMapping("/initDb")
public class InitDbController {
    @Autowired
    private InitDbService initDbService;

    @ResponseBody
    @RequestMapping("/initDDL")
    public int initDDL() throws IOException {
        initDbService.initDDL();
        return 1;
    }

    @ResponseBody
    @RequestMapping("/initDML")
    public int initDML() throws IOException {
        initDbService.initDML();
        return 1;
    }

}
