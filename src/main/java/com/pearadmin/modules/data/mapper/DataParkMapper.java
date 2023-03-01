package com.pearadmin.modules.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.pearadmin.modules.data.domain.DataPark;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 园区数据Mapper接口
 *
 * @author leo
 * @date 2023-02-23
 */
@Mapper
public interface DataParkMapper extends BaseMapper<DataPark> {
    /**
     * 查询园区数据列表
     *
     * @param dataPark 园区数据
     * @return 园区数据集合
     */
    List<DataPark> selectDataParkList(DataPark dataPark);

}
