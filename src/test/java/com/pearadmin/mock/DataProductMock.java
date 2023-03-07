package com.pearadmin.mock;

import com.pearadmin.common.tools.SequenceUtil;
import com.pearadmin.modules.data.domain.DataProduct;

/**
 * 产品模拟
 *
 * @author leo
 * @date 2023-03-08
 */
public class DataProductMock extends MockBase<DataProduct> {

    @Override
    public DataProduct createData() {
        DataProduct data = new DataProduct();
        data.setId(SequenceUtil.makeStringId());
        data.setName(faker.app().name());
        data.setPrice(randomDouble(1000));
        return data;
    }
}
