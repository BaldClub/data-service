package com.pearadmin.modules.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.pearadmin.modules.data.domain.DataProductSale;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 产品销售Mapper接口
 *
 * @author leo
 * @date 2023-02-23
 */
@Mapper
public interface DataProductSaleMapper extends BaseMapper<DataProductSale> {
    /**
     * 查询产品销售列表
     *
     * @param dataProductSale 产品销售
     * @return 产品销售集合
     */
    List<DataProductSale> selectDataProductSaleList(DataProductSale dataProductSale);

}
