/*
 * FileName: SystemConfigService.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra.cs.service;

import java.util.List;

import com.ultra.cs.model.SystemConfig;

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
 * 2018年1月26日 下午6:00:19          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
public interface SystemConfigService {

    /**
     * 添加
     * @param config
     */
    public void insert(SystemConfig config) throws Exception;

    /**
     * 更新
     * @param config
     */
    public void update(SystemConfig config) throws Exception;

    /**
     * 删除
     * @param id
     */
    public void delete(Long id);

    /**
     * 查询系统
     * @return
     */
    public List<SystemConfig> listSystem();
}
