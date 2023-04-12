package com.pearadmin.modules.data.controller.frontend;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.response.module.ResultTable;
import com.pearadmin.modules.data.domain.DataCustom;
import com.pearadmin.modules.data.service.IDataCustomService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(tags = {"自定义数据"})
@RequestMapping("/api/custom")
public class CustomController extends BaseController {

    @Resource
    private IDataCustomService customService;

    /**
     * 查询自定义页面数据
     *
     * @param pageName 页面名称
     */
    @GetMapping("/{pageName}")
    public ResultTable getData(@PathVariable("pageName") String pageName) {
        DataCustom data = customService.getOne(new QueryWrapper<DataCustom>().eq("page_name", pageName));
        return dataTable(data == null ? null : JSON.parse(data.getData()));
    }
}
