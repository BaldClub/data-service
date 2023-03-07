package com.pearadmin.mock;

import com.pearadmin.common.tools.SequenceUtil;
import com.pearadmin.modules.data.domain.DataProductSale;

/**
 * 产品销售模拟
 *
 * @author leo
 * @date 2023-03-08
 */
public class DataProductSaleMock extends MockBase<DataProductSale> {

    @Override
    public DataProductSale createData() {
        DataProductSale data = new DataProductSale();
        data.setId(SequenceUtil.makeStringId());
        data.setTime(randomLastYearLocalDate());
        return data;
    }
}
