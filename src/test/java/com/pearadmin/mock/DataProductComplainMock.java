package com.pearadmin.mock;

import com.pearadmin.common.tools.SequenceUtil;
import com.pearadmin.modules.data.domain.DataProductComplain;

/**
 * 产品投诉实体
 *
 * @author leo
 * @date 2023-02-23
 */
public class DataProductComplainMock extends MockBase<DataProductComplain> {

    @Override
    public DataProductComplain createData() {
        DataProductComplain data = new DataProductComplain();
        data.setId(SequenceUtil.makeStringId());
        data.setTime(randomLastYearLocalDate());
        data.setContent(faker.random().hex());
        return data;
    }
}
