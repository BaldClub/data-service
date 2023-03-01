package com.pearadmin.modules.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.pearadmin.modules.data.domain.DataFarmingStatistics;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 农事统计Mapper接口
 *
 * @author leo
 * @date 2023-02-23
 */
@Mapper
public interface DataFarmingStatisticsMapper extends BaseMapper<DataFarmingStatistics> {
    /**
     * 查询农事统计列表
     *
     * @param dataFarmingStatistics 农事统计
     * @return 农事统计集合
     */
    List<DataFarmingStatistics> selectDataFarmingStatisticsList(DataFarmingStatistics dataFarmingStatistics);

}
