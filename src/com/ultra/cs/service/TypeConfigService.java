/*
 * FileName: TypeConfigService.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra.cs.service;

import java.util.List;

import com.ultra.cs.model.SystemConfig;
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
 * 2018年1月26日 下午10:26:51          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
public interface TypeConfigService {
    /**
     * 添加
     * @param config
     */
    public void insert(SystemConfig config);

    /**
     * 更新
     * @param config
     */
    public void update(SystemConfig config);

    /**
     * 删除
     * @param id
     */
    public void delete(Long id);

    /**
     * 查询类别
     * @return
     */
    public List<TypeConfig> listType();
}
