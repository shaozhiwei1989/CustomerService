/*
 * FileName: TypeShardStrategy.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra;

import com.nicomama.parser.SqlParam;
import com.nicomama.strategy.ShardStrategy;

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
 * 2018年5月12日 上午11:54:04          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
public class TypeShardStrategy implements ShardStrategy {

    @Override
    public String parse(SqlParam sqlParam) {
        Long id = (Long) sqlParam.get("id");
        System.out.println(sqlParam.getParamType());
        return "_" + id % 3;//返回分表的后缀
    }

}
