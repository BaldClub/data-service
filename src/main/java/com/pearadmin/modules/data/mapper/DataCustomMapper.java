package com.pearadmin.modules.data.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import com.pearadmin.modules.data.domain.DataCustom;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 自定义数据Mapper接口
 *
 * @author leo
 * @date 2023-04-12
 */
@Mapper
public interface DataCustomMapper extends BaseMapper<DataCustom> {
    /**
     * 查询自定义数据列表
     *
     * @param dataCustom 自定义数据
     * @return 自定义数据集合
     */
    List<DataCustom> selectDataCustomList(DataCustom dataCustom);

}
