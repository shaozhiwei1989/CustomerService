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
    public void insert(TypeConfig config);

    /**
     * 更新
     * @param config
     */
    public void update(TypeConfig config);

    /**
     * 删除
     * @param id
     */
    public void delete(@Param("id") Long id, @Param("name") String name);

    /**
     * 查询类别
     * @return
     */
    public List<TypeConfig> listType(Map<String, Object> params);
}
