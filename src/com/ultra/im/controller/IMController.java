/*
 * FileName: IMController.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra.im.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ultra.im.IMConstant;
import com.ultra.vo.RespData;

import io.rong.models.TokenResult;

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
 * 2018年1月23日 下午4:12:00          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
@Controller
@RequestMapping("/im")
public class IMController {
    static final Logger logger = Logger.getLogger(IMController.class);

    @ResponseBody
    @RequestMapping("/getToken")
    public RespData<String> getToken(String userCode, String userName, String portraitUrl) {
        if (StringUtils.isBlank(userName)) {
            userName = userCode;
        }
        if (StringUtils.isBlank(portraitUrl)) {
            portraitUrl = "";
        }
        try {
            TokenResult tokenResult = IMConstant.RONG_CLOUD.user.getToken(userCode, userName, portraitUrl);
            logger.info("getToken:  " + tokenResult.toString());
            return new RespData<String>(200, null, tokenResult.getToken());
        } catch (Exception e) {
            e.printStackTrace();
            return new RespData<String>(500, e.getMessage(), null);
        }
    }
}
