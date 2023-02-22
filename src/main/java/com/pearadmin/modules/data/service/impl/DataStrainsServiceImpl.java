package com.pearadmin.modules.data.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearadmin.modules.data.mapper.DataStrainsMapper;
import com.pearadmin.modules.data.domain.DataStrains;
import com.pearadmin.modules.data.service.IDataStrainsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.Arrays;
/**
 * 菌株Service业务层处理
 *
 * @author leo
 * @date 2023-02-23
 */
@Service
public class DataStrainsServiceImpl extends ServiceImpl<DataStrainsMapper,DataStrains> implements IDataStrainsService {


    /**
     * 查询菌株
     * @param dataStrains 菌株
     * @param pageDomain
     * @return 菌株 分页集合
     * */
    @Override
    public PageInfo<DataStrains> selectDataStrainsPage(DataStrains dataStrains, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        List<DataStrains> data = baseMapper.selectDataStrainsList(dataStrains);
        return new PageInfo<>(data);
    }

}
