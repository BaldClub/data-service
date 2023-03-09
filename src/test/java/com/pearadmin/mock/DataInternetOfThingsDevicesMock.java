package com.pearadmin.mock;

import com.pearadmin.common.tools.SequenceUtil;
import com.pearadmin.modules.data.domain.DataBacterialRoom;
import com.pearadmin.modules.data.domain.DataInternetOfThingsDevices;

/**
 * 物联网设备数据实体
 *
 * @author leo
 * @date 2023-03-08
 */
public class DataInternetOfThingsDevicesMock extends MockBase<DataInternetOfThingsDevices> {

    private final String[] typeList = new String[]{"环境监测设备", "远程监控设备", "食用菌生产设备", "溯源设备"};
    private final String[] statusList = new String[]{"在线", "离线", "异常"};

    @Override
    public DataInternetOfThingsDevices createData() {
        DataInternetOfThingsDevices data = new DataInternetOfThingsDevices();
        data.setId(SequenceUtil.makeStringId());
        data.setStatus(statusList[randomStatusNumber()]);
        data.setType(typeList[randomNumber(typeList.length)]);
        data.setPrice(randomNumber(1L, 1000L));
        data.setConfigTime(randomLastYearDate());
        data.setUrl(faker.internet().url());
        return data;
    }
}
