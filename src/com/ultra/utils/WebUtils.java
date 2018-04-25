/*
 * FileName: WebUtils.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra.utils;

import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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
 * 2017年5月22日 上午10:41:08          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
public class WebUtils {

    public static HttpServletRequest getHttpServletRequest() {
        ServletRequestAttributes requestAttributes = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
        if (requestAttributes == null) {
            return null;
        }
        return requestAttributes.getRequest();
    }

    public static String getRootPath() {
        URL url = WebUtils.class.getResource("/");
        String path = url.toString();
        int beginIndex = path.indexOf("/");
        int endIndex = path.indexOf("WEB-INF") - 1;
        return path.substring(beginIndex, endIndex);
    }

    public static String getAppBasePath() {
        HttpServletRequest request = getHttpServletRequest();
        if (request == null) {
            return null;
        }
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        return basePath + path;
    }

}
