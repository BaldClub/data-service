package com.pearadmin.mock;

import com.pearadmin.common.tools.SequenceUtil;
import com.pearadmin.modules.data.domain.DataStrains;

/**
 * 菌株实体
 *
 * @author leo
 * @date 2023-03-08
 */
public class DataStrainsMock extends MockBase<DataStrains> {

    private final String[] typeList = new String[]{"平菇", "香菇", "茶树菇", "木耳", "金针菇", "杏鲍菇"};

    @Override
    public DataStrains createData() {
        DataStrains data = new DataStrains();
        data.setId(SequenceUtil.makeStringId());
        data.setType(typeList[randomNumber(typeList.length)]);
        data.setNumber(randomNumber(1L, 100L));
        data.setOutput(randomNumber(1L, 1000L));
        return data;
    }
}
