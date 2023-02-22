package com.pearadmin.modules.data.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearadmin.modules.data.mapper.DataFarmingMaterialMapper;
import com.pearadmin.modules.data.domain.DataFarmingMaterial;
import com.pearadmin.modules.data.service.IDataFarmingMaterialService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.Arrays;
/**
 * 农事材料Service业务层处理
 *
 * @author leo
 * @date 2023-02-23
 */
@Service
public class DataFarmingMaterialServiceImpl extends ServiceImpl<DataFarmingMaterialMapper,DataFarmingMaterial> implements IDataFarmingMaterialService {


    /**
     * 查询农事材料
     * @param dataFarmingMaterial 农事材料
     * @param pageDomain
     * @return 农事材料 分页集合
     * */
    @Override
    public PageInfo<DataFarmingMaterial> selectDataFarmingMaterialPage(DataFarmingMaterial dataFarmingMaterial, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        List<DataFarmingMaterial> data = baseMapper.selectDataFarmingMaterialList(dataFarmingMaterial);
        return new PageInfo<>(data);
    }

}
