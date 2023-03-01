package com.pearadmin.modules.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.pearadmin.modules.data.domain.DataBacterialRoom;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 菌房Mapper接口
 *
 * @author leo
 * @date 2023-02-23
 */
@Mapper
public interface DataBacterialRoomMapper extends BaseMapper<DataBacterialRoom> {
    /**
     * 查询菌房列表
     *
     * @param dataBacterialRoom 菌房
     * @return 菌房集合
     */
    List<DataBacterialRoom> selectDataBacterialRoomList(DataBacterialRoom dataBacterialRoom);

}
