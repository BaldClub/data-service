package com.pearadmin.modules.data.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.modules.data.domain.DataProductTraceScan;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Select;

/**
 * 产品溯源扫码数据Service接口
 *
 * @author leo
 * @date 2023-02-23
 */
public interface IDataProductTraceScanService extends IService<DataProductTraceScan> {

    /**
     * 查询产品溯源扫码数据
     * @param dataProductTraceScan 产品溯源扫码数据
     * @param pageDomain
     * @return 产品溯源扫码数据 分页集合
     * */
    PageInfo<DataProductTraceScan> selectDataProductTraceScanPage(DataProductTraceScan dataProductTraceScan, PageDomain pageDomain);

}
