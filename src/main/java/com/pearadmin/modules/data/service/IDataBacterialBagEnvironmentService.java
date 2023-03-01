package com.pearadmin.modules.data.service;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.modules.data.domain.DataBacterialBagEnvironment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 菌包Service接口
 *
 * @author leo
 * @date 2023-02-23
 */
public interface IDataBacterialBagEnvironmentService extends IService<DataBacterialBagEnvironment> {

    /**
     * 查询菌包
     * @param dataBacterialBagEnvironment 菌包
     * @param pageDomain
     * @return 菌包 分页集合
     * */
    PageInfo<DataBacterialBagEnvironment> selectDataBacterialBagEnvironmentPage(DataBacterialBagEnvironment dataBacterialBagEnvironment, PageDomain pageDomain);

}
