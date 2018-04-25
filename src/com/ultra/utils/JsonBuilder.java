/*
 * FileName: JsonBuilder.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra.utils;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

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
 * 2018年3月4日 上午10:12:19          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
public class JsonBuilder {
    Map<String, Object> jsonMap = new HashMap<String, Object>();

    private JsonBuilder() {

    }

    public static JsonBuilder create() {
        return new JsonBuilder();
    }

    public JsonBuilder add(String key, Object value) {
        jsonMap.put(key, value);
        return this;
    }

    public String toJsonString() {
        return JSON.toJSONString(jsonMap);
    }
}
