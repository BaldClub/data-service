package com.pearadmin.modules.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.pearadmin.modules.data.domain.DataBacterialBag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 菌包Mapper接口
 *
 * @author leo
 * @date 2023-02-23
 */
@Mapper
public interface DataBacterialBagMapper extends BaseMapper<DataBacterialBag> {
    /**
     * 查询菌包列表
     *
     * @param dataBacterialBag 菌包
     * @return 菌包集合
     */
    List<DataBacterialBag> selectDataBacterialBagList(DataBacterialBag dataBacterialBag);

}
