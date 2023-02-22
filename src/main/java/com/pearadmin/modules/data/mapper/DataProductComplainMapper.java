package com.pearadmin.modules.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.pearadmin.modules.data.domain.DataProductComplain;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 产品投诉Mapper接口
 *
 * @author leo
 * @date 2023-02-23
 */
@Mapper
public interface DataProductComplainMapper extends BaseMapper<DataProductComplain> {
    /**
     * 查询产品投诉列表
     *
     * @param dataProductComplain 产品投诉
     * @return 产品投诉集合
     */
    List<DataProductComplain> selectDataProductComplainList(DataProductComplain dataProductComplain);

}
