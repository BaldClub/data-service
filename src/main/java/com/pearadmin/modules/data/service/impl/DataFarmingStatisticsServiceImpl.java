package com.pearadmin.modules.data.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearadmin.modules.data.mapper.DataFarmingStatisticsMapper;
import com.pearadmin.modules.data.domain.DataFarmingStatistics;
import com.pearadmin.modules.data.service.IDataFarmingStatisticsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.Arrays;
/**
 * 农事统计Service业务层处理
 *
 * @author leo
 * @date 2023-02-23
 */
@Service
public class DataFarmingStatisticsServiceImpl extends ServiceImpl<DataFarmingStatisticsMapper,DataFarmingStatistics> implements IDataFarmingStatisticsService {


    /**
     * 查询农事统计
     * @param dataFarmingStatistics 农事统计
     * @param pageDomain
     * @return 农事统计 分页集合
     * */
    @Override
    public PageInfo<DataFarmingStatistics> selectDataFarmingStatisticsPage(DataFarmingStatistics dataFarmingStatistics, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        List<DataFarmingStatistics> data = baseMapper.selectDataFarmingStatisticsList(dataFarmingStatistics);
        return new PageInfo<>(data);
    }

}
