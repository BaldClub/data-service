package com.pearadmin.modules.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.pearadmin.modules.data.domain.DataProduct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 产品Mapper接口
 *
 * @author leo
 * @date 2023-02-23
 */
@Mapper
public interface DataProductMapper extends BaseMapper<DataProduct> {
    /**
     * 查询产品列表
     *
     * @param dataProduct 产品
     * @return 产品集合
     */
    List<DataProduct> selectDataProductList(DataProduct dataProduct);

}
