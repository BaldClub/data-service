package com.pearadmin.mock;

import com.pearadmin.common.tools.SequenceUtil;
import com.pearadmin.modules.data.domain.DataProductTraceScan;

/**
 * 产品溯源扫码数据模拟
 *
 * @author leo
 * @date 2023-03-08
 */
public class DataProductTraceScanMock extends MockBase<DataProductTraceScan> {

    @Override
    public DataProductTraceScan createData() {
        DataProductTraceScan data = new DataProductTraceScan();
        data.setId(SequenceUtil.makeStringId());
        data.setTime(randomLastYearLocalDate());
        return data;
    }
}
