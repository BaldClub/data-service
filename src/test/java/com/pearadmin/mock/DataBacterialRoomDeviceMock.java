package com.pearadmin.mock;

import com.pearadmin.common.tools.SequenceUtil;
import com.pearadmin.modules.data.domain.DataBacterialRoomDevice;

/**
 * 菌房设备模拟
 *
 * @author leo
 * @date 2023-03-08
 */
public class DataBacterialRoomDeviceMock extends MockBase<DataBacterialRoomDevice> {

    @Override
    public DataBacterialRoomDevice createData() {
        DataBacterialRoomDevice data = new DataBacterialRoomDevice();
        data.setId(SequenceUtil.makeStringId());
        data.setType(faker.address().fullAddress());
        return data;
    }
}
