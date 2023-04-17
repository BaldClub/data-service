package com.pearadmin.modules.data.service;

import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.modules.data.domain.DataCustom;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 自定义数据Service接口
 *
 * @author leo
 * @date 2023-04-12
 */
public interface IDataCustomService extends IService<DataCustom> {

    /**
     * 查询自定义数据
     *
     * @param dataCustom 自定义数据
     * @param pageDomain
     * @return 自定义数据 分页集合
     */
    PageInfo<DataCustom> selectDataCustomPage(DataCustom dataCustom, PageDomain pageDomain);

}
