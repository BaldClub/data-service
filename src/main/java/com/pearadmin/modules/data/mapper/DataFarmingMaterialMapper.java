package com.pearadmin.modules.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.pearadmin.modules.data.domain.DataFarmingMaterial;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 农事材料Mapper接口
 *
 * @author leo
 * @date 2023-02-23
 */
@Mapper
public interface DataFarmingMaterialMapper extends BaseMapper<DataFarmingMaterial> {
    /**
     * 查询农事材料列表
     *
     * @param dataFarmingMaterial 农事材料
     * @return 农事材料集合
     */
    List<DataFarmingMaterial> selectDataFarmingMaterialList(DataFarmingMaterial dataFarmingMaterial);

}
