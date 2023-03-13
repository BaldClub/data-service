package com.pearadmin.modules.data.controller;

import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.common.web.domain.response.Result;
import com.pearadmin.common.web.domain.response.module.ResultTable;
import com.pearadmin.modules.data.domain.DataProductSale;
import com.pearadmin.modules.data.service.IDataProductSaleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * 产品销售Controller
 *
 * @author leo
 * @date 2023-02-23
 */
@RestController
@RequestMapping("/data/productSale")
public class DataProductSaleController extends BaseController {

    private String prefix = "data/productSale";

    @Resource
    private IDataProductSaleService dataProductSaleService;

    @GetMapping("/main")
    @PreAuthorize("hasPermission('/data/productSale/main','data:productSale:main')")
    public ModelAndView main() {
        return jumpPage(prefix + "/main");
    }

    /**
     * 查询产品销售列表
     */
    @ResponseBody
    @GetMapping("/data")
    @PreAuthorize("hasPermission('/data/productSale/data','data:productSale:data')")
    public ResultTable list(@ModelAttribute DataProductSale dataProductSale, PageDomain pageDomain) {
        PageInfo<DataProductSale> pageInfo = dataProductSaleService.selectDataProductSalePage(dataProductSale, pageDomain);
        return pageTable(pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 新增产品销售
     */
    @GetMapping("/add")
    @PreAuthorize("hasPermission('/data/productSale/add','data:productSale:add')")
    public ModelAndView add() {
        return jumpPage(prefix + "/add");
    }

    /**
     * 新增产品销售
     */
    @ResponseBody
    @PostMapping("/save")
    @PreAuthorize("hasPermission('/data/productSale/add','data:productSale:add')")
    public Result save(@RequestBody DataProductSale dataProductSale) {
        return decide(dataProductSaleService.save(dataProductSale));
    }

    /**
     * 修改产品销售
     */
    @GetMapping("/edit")
    @PreAuthorize("hasPermission('/data/productSale/edit','data:productSale:edit')")
    public ModelAndView edit(String id, ModelMap map) {
        DataProductSale dataProductSale =dataProductSaleService.getById(id);
        map.put("dataProductSale", dataProductSale);
        return jumpPage(prefix + "/edit");
    }

    /**
     * 修改产品销售
     */
    @ResponseBody
    @PutMapping("/update")
    @PreAuthorize("hasPermission('/data/productSale/edit','data:productSale:edit')")
    public Result update(@RequestBody DataProductSale dataProductSale) {
        return decide(dataProductSaleService.updateById(dataProductSale));
    }

    /**
     * 删除产品销售
     */
    @ResponseBody
    @DeleteMapping("/batchRemove")
    @PreAuthorize("hasPermission('/data/productSale/remove','data:productSale:remove')")
    public Result batchRemove(String ids) {
        return decide(dataProductSaleService.removeByIds(Arrays.asList(ids.split(","))));
    }

    /**
     * 删除产品销售
     */
    @ResponseBody
    @DeleteMapping("/remove/{id}")
    @PreAuthorize("hasPermission('/data/productSale/remove','data:productSale:remove')")
    public Result remove(@PathVariable("id") Long id) {
        return decide(dataProductSaleService.removeById(id));
    }
}
