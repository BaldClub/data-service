package com.pearadmin.mock;

import com.pearadmin.common.tools.SequenceUtil;
import com.pearadmin.modules.data.domain.DataBacterialRoomEnvironment;

/**
 * 菌房实体
 *
 * @author leo
 * @date 2023-03-08
 */
public class DataBacterialRoomEnvironmentMock extends MockBase<DataBacterialRoomEnvironment> {

    @Override
    public DataBacterialRoomEnvironment createData() {
        DataBacterialRoomEnvironment data = new DataBacterialRoomEnvironment();
        data.setId(SequenceUtil.makeStringId());
        data.setTemperature(randomDoubleString(10, 30));
        data.setHumidity(randomDoubleString(10, 80));
        data.setIllumination(randomDoubleString(100));
        data.setTime(randomLastYearLocalDate());
        data.setCarbonDioxide(randomDoubleString(10, 90));
        data.setCarbonMonoxide(randomDoubleString(10, 90));
        return data;
    }
}
