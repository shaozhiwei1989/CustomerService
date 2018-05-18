/*
 * FileName: TypeConfigDao.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra.cs.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.nicomama.annotation.DSParam;
import com.nicomama.annotation.DataSource;
import com.ultra.DataSourceStrategyImpl;
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
 * 2018年1月26日 下午10:22:19          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
public interface TypeConfigDao {
    /**
     * 添加
     * @param config
     */
    @DataSource(strategy = DataSourceStrategyImpl.class)
    public void insert(@DSParam TypeConfig config);

    /**
     * 更新
     * @param config
     */
    @DataSource("dataSource_0")
    public void update(TypeConfig config);

    /**
     * 删除
     * @param id
     */
    @DataSource(strategy = DataSourceStrategyImpl.class)
    public void delete(@DSParam @Param("id") Long id, @Param("name") String name);

    /**
     * 查询类别
     * @return
     */
    @DataSource("dataSource_0")
    public List<TypeConfig> listType(Map<String, Object> params);
}
