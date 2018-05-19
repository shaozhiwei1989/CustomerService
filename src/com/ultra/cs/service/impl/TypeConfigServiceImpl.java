/*
 * FileName: TypeConfigServiceImpl.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra.cs.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ultra.cs.dao.TypeConfigDao;
import com.ultra.cs.model.TypeConfig;
import com.ultra.cs.service.TypeConfigService;

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
 * 2018年1月26日 下午10:27:28          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
@Service
@Transactional
public class TypeConfigServiceImpl implements TypeConfigService {
    @Autowired
    private TypeConfigDao typeConfigDao;

    @Override
    public void insert(TypeConfig config) {
        typeConfigDao.insert(config);
    }

    @Override
    public void update(TypeConfig config) {
        typeConfigDao.update(config);
    }

    @Override
    public void delete(Long id) {
        typeConfigDao.delete(id, "name:" + id);
    }

    @Override
    public List<TypeConfig> list(Long shardKey, Map<String, Object> params) {
        return typeConfigDao.listType(params);
    }

}
