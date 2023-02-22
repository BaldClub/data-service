package com.pearadmin.modules.data.controller;

import com.github.pagehelper.PageInfo;
import com.pearadmin.common.context.UserContext;
import com.pearadmin.modules.data.domain.DataProductComplain;
import com.pearadmin.common.tools.string.Convert;
import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.common.web.domain.response.Result;
import com.pearadmin.common.web.domain.response.module.ResultTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.pearadmin.modules.data.service.IDataProductComplainService;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 产品投诉Controller
 *
 * @author leo
 * @date 2023-02-23
 */
@RestController
@RequestMapping("/data/productComplain")
public class DataProductComplainController extends BaseController {

    private String prefix = "data/productComplain";

    @Autowired
    private IDataProductComplainService dataProductComplainService;

    @GetMapping("/main")
    @PreAuthorize("hasPermission('/data/productComplain/main','data:productComplain:main')")
    public ModelAndView main() {
        return jumpPage(prefix + "/main");
    }

    /**
     * 查询产品投诉列表
     */
    @ResponseBody
    @GetMapping("/data")
    @PreAuthorize("hasPermission('/data/productComplain/data','data:productComplain:data')")
    public ResultTable list(@ModelAttribute DataProductComplain dataProductComplain, PageDomain pageDomain) {
        PageInfo<DataProductComplain> pageInfo = dataProductComplainService.selectDataProductComplainPage(dataProductComplain, pageDomain);
        return pageTable(pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 新增产品投诉
     */
    @GetMapping("/add")
    @PreAuthorize("hasPermission('/data/productComplain/add','data:productComplain:add')")
    public ModelAndView add() {
        return jumpPage(prefix + "/add");
    }

    /**
     * 新增产品投诉
     */
    @ResponseBody
    @PostMapping("/save")
    @PreAuthorize("hasPermission('/data/productComplain/add','data:productComplain:add')")
    public Result save(@RequestBody DataProductComplain dataProductComplain) {
        return decide(dataProductComplainService.save(dataProductComplain));
    }

    /**
     * 修改产品投诉
     */
    @GetMapping("/edit")
    @PreAuthorize("hasPermission('/data/productComplain/edit','data:productComplain:edit')")
    public ModelAndView edit(Long id, ModelMap map) {
        DataProductComplain dataProductComplain =dataProductComplainService.getById(id);
        map.put("dataProductComplain", dataProductComplain);
        return jumpPage(prefix + "/edit");
    }

    /**
     * 修改产品投诉
     */
    @ResponseBody
    @PutMapping("/update")
    @PreAuthorize("hasPermission('/data/productComplain/edit','data:productComplain:edit')")
    public Result update(@RequestBody DataProductComplain dataProductComplain) {
        return decide(dataProductComplainService.updateById(dataProductComplain));
    }

    /**
     * 删除产品投诉
     */
    @ResponseBody
    @DeleteMapping("/batchRemove")
    @PreAuthorize("hasPermission('/data/productComplain/remove','data:productComplain:remove')")
    public Result batchRemove(String ids) {
        return decide(dataProductComplainService.removeByIds(Arrays.asList(ids.split(","))));
    }

    /**
     * 删除产品投诉
     */
    @ResponseBody
    @DeleteMapping("/remove/{id}")
    @PreAuthorize("hasPermission('/data/productComplain/remove','data:productComplain:remove')")
    public Result remove(@PathVariable("id") Long id) {
        return decide(dataProductComplainService.removeById(id));
    }
}
