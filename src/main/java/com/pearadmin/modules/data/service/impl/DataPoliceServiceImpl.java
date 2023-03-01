package com.pearadmin.modules.data.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearadmin.modules.data.mapper.DataPoliceMapper;
import com.pearadmin.modules.data.domain.DataPolice;
import com.pearadmin.modules.data.service.IDataPoliceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.Arrays;
/**
 * 报警Service业务层处理
 *
 * @author leo
 * @date 2023-02-23
 */
@Service
public class DataPoliceServiceImpl extends ServiceImpl<DataPoliceMapper,DataPolice> implements IDataPoliceService {


    /**
     * 查询报警
     * @param dataPolice 报警
     * @param pageDomain
     * @return 报警 分页集合
     * */
    @Override
    public PageInfo<DataPolice> selectDataPolicePage(DataPolice dataPolice, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        List<DataPolice> data = baseMapper.selectDataPoliceList(dataPolice);
        return new PageInfo<>(data);
    }

}
