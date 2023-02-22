package com.pearadmin.modules.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.pearadmin.modules.data.domain.DataStrains;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 菌株Mapper接口
 *
 * @author leo
 * @date 2023-02-23
 */
@Mapper
public interface DataStrainsMapper extends BaseMapper<DataStrains> {
    /**
     * 查询菌株列表
     *
     * @param dataStrains 菌株
     * @return 菌株集合
     */
    List<DataStrains> selectDataStrainsList(DataStrains dataStrains);

}
