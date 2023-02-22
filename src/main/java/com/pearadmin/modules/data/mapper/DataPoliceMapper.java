package com.pearadmin.modules.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.pearadmin.modules.data.domain.DataPolice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 报警Mapper接口
 *
 * @author leo
 * @date 2023-02-23
 */
@Mapper
public interface DataPoliceMapper extends BaseMapper<DataPolice> {
    /**
     * 查询报警列表
     *
     * @param dataPolice 报警
     * @return 报警集合
     */
    List<DataPolice> selectDataPoliceList(DataPolice dataPolice);

}
