package com.pearadmin.modules.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.pearadmin.modules.data.domain.DataBacterialRoomDevice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 菌房设备Mapper接口
 *
 * @author leo
 * @date 2023-02-23
 */
@Mapper
public interface DataBacterialRoomDeviceMapper extends BaseMapper<DataBacterialRoomDevice> {
    /**
     * 查询菌房设备列表
     *
     * @param dataBacterialRoomDevice 菌房设备
     * @return 菌房设备集合
     */
    List<DataBacterialRoomDevice> selectDataBacterialRoomDeviceList(DataBacterialRoomDevice dataBacterialRoomDevice);

}
