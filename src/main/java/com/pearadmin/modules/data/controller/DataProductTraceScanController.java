package com.pearadmin.modules.data.controller;

import com.github.pagehelper.PageInfo;
import com.pearadmin.common.context.UserContext;
import com.pearadmin.modules.data.domain.DataProductTraceScan;
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
import com.pearadmin.modules.data.service.IDataProductTraceScanService;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 产品溯源扫码数据Controller
 *
 * @author leo
 * @date 2023-02-23
 */
@RestController
@RequestMapping("/data/productTraceScan")
public class DataProductTraceScanController extends BaseController {

    private String prefix = "data/productTraceScan";

    @Autowired
    private IDataProductTraceScanService dataProductTraceScanService;

    @GetMapping("/main")
    @PreAuthorize("hasPermission('/data/productTraceScan/main','data:productTraceScan:main')")
    public ModelAndView main() {
        return jumpPage(prefix + "/main");
    }

    /**
     * 查询产品溯源扫码数据列表
     */
    @ResponseBody
    @GetMapping("/data")
    @PreAuthorize("hasPermission('/data/productTraceScan/data','data:productTraceScan:data')")
    public ResultTable list(@ModelAttribute DataProductTraceScan dataProductTraceScan, PageDomain pageDomain) {
        PageInfo<DataProductTraceScan> pageInfo = dataProductTraceScanService.selectDataProductTraceScanPage(dataProductTraceScan, pageDomain);
        return pageTable(pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 新增产品溯源扫码数据
     */
    @GetMapping("/add")
    @PreAuthorize("hasPermission('/data/productTraceScan/add','data:productTraceScan:add')")
    public ModelAndView add() {
        return jumpPage(prefix + "/add");
    }

    /**
     * 新增产品溯源扫码数据
     */
    @ResponseBody
    @PostMapping("/save")
    @PreAuthorize("hasPermission('/data/productTraceScan/add','data:productTraceScan:add')")
    public Result save(@RequestBody DataProductTraceScan dataProductTraceScan) {
        return decide(dataProductTraceScanService.save(dataProductTraceScan));
    }

    /**
     * 修改产品溯源扫码数据
     */
    @GetMapping("/edit")
    @PreAuthorize("hasPermission('/data/productTraceScan/edit','data:productTraceScan:edit')")
    public ModelAndView edit(Long id, ModelMap map) {
        DataProductTraceScan dataProductTraceScan =dataProductTraceScanService.getById(id);
        map.put("dataProductTraceScan", dataProductTraceScan);
        return jumpPage(prefix + "/edit");
    }

    /**
     * 修改产品溯源扫码数据
     */
    @ResponseBody
    @PutMapping("/update")
    @PreAuthorize("hasPermission('/data/productTraceScan/edit','data:productTraceScan:edit')")
    public Result update(@RequestBody DataProductTraceScan dataProductTraceScan) {
        return decide(dataProductTraceScanService.updateById(dataProductTraceScan));
    }

    /**
     * 删除产品溯源扫码数据
     */
    @ResponseBody
    @DeleteMapping("/batchRemove")
    @PreAuthorize("hasPermission('/data/productTraceScan/remove','data:productTraceScan:remove')")
    public Result batchRemove(String ids) {
        return decide(dataProductTraceScanService.removeByIds(Arrays.asList(ids.split(","))));
    }

    /**
     * 删除产品溯源扫码数据
     */
    @ResponseBody
    @DeleteMapping("/remove/{id}")
    @PreAuthorize("hasPermission('/data/productTraceScan/remove','data:productTraceScan:remove')")
    public Result remove(@PathVariable("id") Long id) {
        return decide(dataProductTraceScanService.removeById(id));
    }
}
