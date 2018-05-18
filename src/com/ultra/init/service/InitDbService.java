/*
 * FileName: InitDbService.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra.init.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

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
 * 2018年2月1日 下午8:03:22          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
//@Service
@Transactional
public class InitDbService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void initDDL() throws IOException {
        List<String> sqls = readSqlFile("com/ultra/init/ddl.sql");
        execute(sqls);
    }

    public void initDML() throws IOException {
        List<String> sqls = readSqlFile("com/ultra/init/dml.sql");
        execute(sqls);
    }

    private List<String> readSqlFile(String fPath) throws IOException {
        List<String> sqls = new ArrayList<String>();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream in = loader.getResourceAsStream(fPath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        try {
            for (String strs; (strs = reader.readLine()) != null;) {
                if (!strs.trim().startsWith("--")) {
                    sqls.add(strs);
                }
            }
        } finally {
            IOUtils.closeQuietly(reader);
        }
        return sqls;
    }

    private void execute(List<String> sqls) {
        for (String sql : sqls) {
            if (StringUtils.isNotBlank(sql)) {
                jdbcTemplate.execute(sql);
            }
        }
    }

}
