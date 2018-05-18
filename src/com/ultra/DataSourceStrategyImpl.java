/*
 * FileName: DataSourceStrategyImpl.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra;

import com.nicomama.strategy.DataSourceStrategy;
import com.ultra.cs.model.TypeConfig;

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
 * 2018年5月19日 上午12:04:57          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
public class DataSourceStrategyImpl implements DataSourceStrategy {

    @Override
    public String parse(Object[] args) {
        if (args[0] instanceof TypeConfig) {
            TypeConfig typeConfig = (TypeConfig) args[0];
            return "dataSource_" + typeConfig.getId() % 2;
        } else if (args[0] instanceof Long) {
            Long id = (Long) args[0];
            return "dataSource_" + id % 2;
        }
        return null;
    }

}
