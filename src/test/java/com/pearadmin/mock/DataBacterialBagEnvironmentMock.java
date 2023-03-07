package com.pearadmin.mock;

import com.pearadmin.common.tools.SequenceUtil;
import com.pearadmin.modules.data.domain.DataBacterialBagEnvironment;

/**
 * 菌包环境模拟实体
 *
 * @author leo
 * @date 2023-03-08
 */
public class DataBacterialBagEnvironmentMock extends MockBase<DataBacterialBagEnvironment> {

    @Override
    public DataBacterialBagEnvironment createData() {
        DataBacterialBagEnvironment data = new DataBacterialBagEnvironment();
        data.setId(SequenceUtil.makeStringId());
        data.setTemperature(randomDoubleString(10, 30));
        data.setHumidity(randomDoubleString(10, 80));
        data.setPh(randomDoubleString(3, 9));
        data.setTime(randomLastYearLocalDate());
        return data;
    }
}
