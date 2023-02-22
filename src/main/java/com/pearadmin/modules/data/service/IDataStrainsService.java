package com.pearadmin.modules.data.service;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.modules.data.domain.DataStrains;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 菌株Service接口
 *
 * @author leo
 * @date 2023-02-23
 */
public interface IDataStrainsService extends IService<DataStrains> {

    /**
     * 查询菌株
     * @param dataStrains 菌株
     * @param pageDomain
     * @return 菌株 分页集合
     * */
    PageInfo<DataStrains> selectDataStrainsPage(DataStrains dataStrains, PageDomain pageDomain);

}
