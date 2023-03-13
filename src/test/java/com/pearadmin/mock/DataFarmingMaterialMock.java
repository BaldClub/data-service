package com.pearadmin.mock;

import com.pearadmin.common.tools.SequenceUtil;
import com.pearadmin.modules.data.domain.DataFarmingMaterial;

/**
 * 农事材料实体
 *
 * @author leo
 * @date 2023-03-08
 */
public class DataFarmingMaterialMock extends MockBase<DataFarmingMaterial> {

    private final String[] typeList = new String[]{"原材料购买", "原材料消耗", "能源消耗", "药品消耗"};

    @Override
    public DataFarmingMaterial createData() {
        DataFarmingMaterial data = new DataFarmingMaterial();
        data.setId(SequenceUtil.makeStringId());
        data.setType(typeList[randomNumber(typeList.length)]);
        data.setPrice(randomDoubleString(1000));
        data.setTime(randomLastYearLocalDate());
        return data;
    }
}
