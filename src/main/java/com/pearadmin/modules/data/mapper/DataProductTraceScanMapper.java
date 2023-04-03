package com.pearadmin.modules.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

import com.pearadmin.modules.data.domain.DataProductTraceScan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

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

    @Select("SELECT DATE_FORMAT(time, '%Y-%m') as month, COUNT(*) as count FROM data_product_trace_scan GROUP BY month ORDER BY month")
    List<Map<String, Object>> groupByMonth();
}
