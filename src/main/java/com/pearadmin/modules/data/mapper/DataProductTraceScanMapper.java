package com.pearadmin.modules.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.pearadmin.modules.data.domain.DataProductTraceScan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 产品溯源扫码数据Mapper接口
 *
 * @author leo
 * @date 2023-02-23
 */
@Mapper
public interface DataProductTraceScanMapper extends BaseMapper<DataProductTraceScan> {
    /**
     * 查询产品溯源扫码数据列表
     *
     * @param dataProductTraceScan 产品溯源扫码数据
     * @return 产品溯源扫码数据集合
     */
    List<DataProductTraceScan> selectDataProductTraceScanList(DataProductTraceScan dataProductTraceScan);

}
