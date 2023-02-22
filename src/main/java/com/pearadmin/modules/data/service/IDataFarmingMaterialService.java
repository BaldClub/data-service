package com.pearadmin.modules.data.service;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.modules.data.domain.DataFarmingMaterial;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 农事材料Service接口
 *
 * @author leo
 * @date 2023-02-23
 */
public interface IDataFarmingMaterialService extends IService<DataFarmingMaterial> {

    /**
     * 查询农事材料
     * @param dataFarmingMaterial 农事材料
     * @param pageDomain
     * @return 农事材料 分页集合
     * */
    PageInfo<DataFarmingMaterial> selectDataFarmingMaterialPage(DataFarmingMaterial dataFarmingMaterial, PageDomain pageDomain);

}
