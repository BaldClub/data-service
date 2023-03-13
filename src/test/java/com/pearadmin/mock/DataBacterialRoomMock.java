package com.pearadmin.mock;

import com.pearadmin.common.tools.SequenceUtil;
import com.pearadmin.modules.data.domain.DataBacterialRoom;

/**
 * 菌房模拟
 *
 * @author leo
 * @date 2023-03-08
 */
public class DataBacterialRoomMock extends MockBase<DataBacterialRoom> {

    @Override
    public DataBacterialRoom createData() {
        DataBacterialRoom data = new DataBacterialRoom();
        data.setId(SequenceUtil.makeStringId());
        data.setName(faker.app().name());
        data.setLocation(faker.address().fullAddress());
        return data;
    }
}
