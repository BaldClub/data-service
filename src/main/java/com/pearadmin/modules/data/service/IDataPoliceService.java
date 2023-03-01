package com.pearadmin.modules.data.service;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.modules.data.domain.DataPolice;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 报警Service接口
 *
 * @author leo
 * @date 2023-02-23
 */
public interface IDataPoliceService extends IService<DataPolice> {

    /**
     * 查询报警
     * @param dataPolice 报警
     * @param pageDomain
     * @return 报警 分页集合
     * */
    PageInfo<DataPolice> selectDataPolicePage(DataPolice dataPolice, PageDomain pageDomain);

}
