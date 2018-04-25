/*
 * FileName: SystemConfigServiceImpl.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra.cs.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ultra.cs.dao.SystemConfigDao;
import com.ultra.cs.model.SystemConfig;
import com.ultra.cs.service.SystemConfigService;
import com.ultra.utils.WebUtils;

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
 * 2018年1月26日 下午6:00:44          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
@Service
@Transactional
public class SystemConfigServiceImpl implements SystemConfigService {
    @Autowired
    private SystemConfigDao systemConfigDao;

    @Override
    public void insert(SystemConfig config) {
        systemConfigDao.insert(config);
    }

    @Override
    public void update(SystemConfig config) throws Exception {
        systemConfigDao.update(config);
    }

    @Override
    public void delete(Long id) {
        SystemConfig config = systemConfigDao.getById(id);
        File f = new File(WebUtils.getRootPath() + "/systemconfig/" + config.getIcon());
        f.delete();
        systemConfigDao.delete(config.getId());
    }

    @Override
    public List<SystemConfig> listSystem() {
        return systemConfigDao.listSystem();
    }

    //
    //    private String transferFile(MultipartFile file) throws IllegalStateException, IOException {
    //        HttpSession session = WebUtils.getHttpServletRequest().getSession();
    //        String orgiginalName = file.getOriginalFilename();
    //        String newImageName = UUID.randomUUID().toString() + orgiginalName.substring(orgiginalName.lastIndexOf("."), orgiginalName.length());
    //        String iconPath = session.getServletContext().getRealPath("/systemconfig/") + newImageName;
    //        file.transferTo(new File(iconPath));
    //        return WebUtils.getAppBasePath() + "/systemconfig/" + newImageName;
    //    }

}
