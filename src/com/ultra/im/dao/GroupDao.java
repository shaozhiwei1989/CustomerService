/*
 * FileName: GroupDao.java
 *
 * Company: 北京神州泰岳软件股份有限公司
 * Copyright 2011-2012 (C) Ultrapower Software CO., LTD. All Rights Reserved.
 */
package com.ultra.im.dao;

import com.ultra.im.model.Group;

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
 * 2018年3月2日 上午10:09:47          zhiweishao        4.1         To create
 * </p>
 *
 * @since
 * @see
 */
public interface GroupDao {

    /**
     * 添加
     * @param group
     */
    public void insert(Group group);

    /**
     * 删除
     * @param id
     */
    public void delete(String id);

    /**
     * 查询
     * @param id
     * @return
     */
    public Group find(String id);

    /**
     * 更新
     * @param group
     */
    public void update(Group group);

}
