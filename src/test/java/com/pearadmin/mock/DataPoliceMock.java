package com.pearadmin.mock;

import com.pearadmin.common.tools.SequenceUtil;
import com.pearadmin.modules.data.domain.DataPolice;

/**
 * 报警实体
 *
 * @author leo
 * @date 2023-03-08
 */
public class DataPoliceMock extends MockBase<DataPolice> {

    private final String[] typeList = new String[]{"环境报警", "生产报警", "设备报警", "农资农事报警", "监控报警"};

    @Override
    public DataPolice createData() {
        DataPolice data = new DataPolice();
        data.setId(SequenceUtil.makeStringId());
        data.setType(typeList[randomNumber(typeList.length)]);
        data.setTime(randomLastYearLocalDate());
        return data;
    }
}
