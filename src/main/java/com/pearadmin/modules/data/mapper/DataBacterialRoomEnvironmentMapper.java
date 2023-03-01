package com.pearadmin.modules.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.pearadmin.modules.data.domain.DataBacterialRoomEnvironment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 菌房Mapper接口
 *
 * @author leo
 * @date 2023-02-23
 */
@Mapper
public interface DataBacterialRoomEnvironmentMapper extends BaseMapper<DataBacterialRoomEnvironment> {
    /**
     * 查询菌房列表
     *
     * @param dataBacterialRoomEnvironment 菌房
     * @return 菌房集合
     */
    List<DataBacterialRoomEnvironment> selectDataBacterialRoomEnvironmentList(DataBacterialRoomEnvironment dataBacterialRoomEnvironment);

}
