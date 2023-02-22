package com.pearadmin.modules.data.controller;

import com.github.pagehelper.PageInfo;
import com.pearadmin.common.context.UserContext;
import com.pearadmin.modules.data.domain.DataProduct;
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
import com.pearadmin.modules.data.service.IDataProductService;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 产品Controller
 *
 * @author leo
 * @date 2023-02-23
 */
@RestController
@RequestMapping("/data/product")
public class DataProductController extends BaseController {

    private String prefix = "data/product";

    @Autowired
    private IDataProductService dataProductService;

    @GetMapping("/main")
    @PreAuthorize("hasPermission('/data/product/main','data:product:main')")
    public ModelAndView main() {
        return jumpPage(prefix + "/main");
    }

    /**
     * 查询产品列表
     */
    @ResponseBody
    @GetMapping("/data")
    @PreAuthorize("hasPermission('/data/product/data','data:product:data')")
    public ResultTable list(@ModelAttribute DataProduct dataProduct, PageDomain pageDomain) {
        PageInfo<DataProduct> pageInfo = dataProductService.selectDataProductPage(dataProduct, pageDomain);
        return pageTable(pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 新增产品
     */
    @GetMapping("/add")
    @PreAuthorize("hasPermission('/data/product/add','data:product:add')")
    public ModelAndView add() {
        return jumpPage(prefix + "/add");
    }

    /**
     * 新增产品
     */
    @ResponseBody
    @PostMapping("/save")
    @PreAuthorize("hasPermission('/data/product/add','data:product:add')")
    public Result save(@RequestBody DataProduct dataProduct) {
        return decide(dataProductService.save(dataProduct));
    }

    /**
     * 修改产品
     */
    @GetMapping("/edit")
    @PreAuthorize("hasPermission('/data/product/edit','data:product:edit')")
    public ModelAndView edit(Long id, ModelMap map) {
        DataProduct dataProduct =dataProductService.getById(id);
        map.put("dataProduct", dataProduct);
        return jumpPage(prefix + "/edit");
    }

    /**
     * 修改产品
     */
    @ResponseBody
    @PutMapping("/update")
    @PreAuthorize("hasPermission('/data/product/edit','data:product:edit')")
    public Result update(@RequestBody DataProduct dataProduct) {
        return decide(dataProductService.updateById(dataProduct));
    }

    /**
     * 删除产品
     */
    @ResponseBody
    @DeleteMapping("/batchRemove")
    @PreAuthorize("hasPermission('/data/product/remove','data:product:remove')")
    public Result batchRemove(String ids) {
        return decide(dataProductService.removeByIds(Arrays.asList(ids.split(","))));
    }

    /**
     * 删除产品
     */
    @ResponseBody
    @DeleteMapping("/remove/{id}")
    @PreAuthorize("hasPermission('/data/product/remove','data:product:remove')")
    public Result remove(@PathVariable("id") Long id) {
        return decide(dataProductService.removeById(id));
    }
}
