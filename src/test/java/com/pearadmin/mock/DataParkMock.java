package com.pearadmin.mock;

import com.pearadmin.common.tools.SequenceUtil;
import com.pearadmin.modules.data.domain.DataPark;

/**
 * 园区数据实体
 *
 * @author leo
 * @date 2023-03-08
 */
public class DataParkMock extends MockBase<DataPark> {

    @Override
    public DataPark createData() {
        DataPark data = new DataPark();
        data.setId(SequenceUtil.makeStringId());
        data.setFactoryArea(randomNumber(1L, 100L));
        data.setMushroomHouses(randomNumber(1L, 50L));
        data.setCultivatedVarieties(randomNumber(1L, 1000L));
        data.setUrl(faker.internet().url());
        return data;
    }
}
