package com.pearadmin.mock;

import com.pearadmin.common.tools.SequenceUtil;
import com.pearadmin.modules.data.domain.DataBacterialBag;

/**
 * 菌包模拟实体
 *
 * @author leo
 * @date 2023-03-08
 */
public class DataBacterialBagMock extends MockBase<DataBacterialBag> {

    private final String[] typeList = new String[]{"平菇", "香菇", "茶树菇", "木耳", "金针菇", "杏鲍菇"};

    @Override
    public DataBacterialBag createData() {
        DataBacterialBag data = new DataBacterialBag();
        data.setId(SequenceUtil.makeStringId());
        data.setType(typeList[randomNumber(typeList.length)]);
        return data;
    }
}
