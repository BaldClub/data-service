package com.pearadmin.modules.data.service;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.modules.data.domain.DataFarmingStatistics;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 农事统计Service接口
 *
 * @author leo
 * @date 2023-02-23
 */
public interface IDataFarmingStatisticsService extends IService<DataFarmingStatistics> {

    /**
     * 查询农事统计
     * @param dataFarmingStatistics 农事统计
     * @param pageDomain
     * @return 农事统计 分页集合
     * */
    PageInfo<DataFarmingStatistics> selectDataFarmingStatisticsPage(DataFarmingStatistics dataFarmingStatistics, PageDomain pageDomain);

}
