package com.pearadmin.mock;

import com.pearadmin.common.tools.SequenceUtil;
import com.pearadmin.modules.data.domain.DataFarmingStatistics;

/**
 * 农事统计实体
 *
 * @author leo
 * @date 2023-03-08
 */
public class DataFarmingStatisticsMock extends MockBase<DataFarmingStatistics> {

    private final String[] typeList = new String[]{"采摘", "病虫害防治", "菌包上下架"};

    @Override
    public DataFarmingStatistics createData() {
        DataFarmingStatistics data = new DataFarmingStatistics();
        data.setId(SequenceUtil.makeStringId());
        data.setType(typeList[randomNumber(typeList.length)]);
        data.setCount(randomNumber(1L, 100L));
        data.setTime(randomLastYearLocalDate());
        return data;
    }
}
