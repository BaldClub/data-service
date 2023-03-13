package com.pearadmin.modules.data.controller;

import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.common.web.domain.response.Result;
import com.pearadmin.common.web.domain.response.module.ResultTable;
import com.pearadmin.modules.data.domain.DataPark;
import com.pearadmin.modules.data.service.IDataParkService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * 园区数据Controller
 *
 * @author leo
 * @date 2023-02-23
 */
@RestController
@RequestMapping("/data/park")
public class DataParkController extends BaseController {

    private String prefix = "data/park";

    @Resource
    private IDataParkService dataParkService;

    @GetMapping("/main")
    @PreAuthorize("hasPermission('/data/park/main','data:park:main')")
    public ModelAndView main() {
        return jumpPage(prefix + "/main");
    }

    /**
     * 查询园区数据列表
     */
    @ResponseBody
    @GetMapping("/data")
    @PreAuthorize("hasPermission('/data/park/data','data:park:data')")
    public ResultTable list(@ModelAttribute DataPark dataPark, PageDomain pageDomain) {
        PageInfo<DataPark> pageInfo = dataParkService.selectDataParkPage(dataPark, pageDomain);
        return pageTable(pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 新增园区数据
     */
    @GetMapping("/add")
    @PreAuthorize("hasPermission('/data/park/add','data:park:add')")
    public ModelAndView add() {
        return jumpPage(prefix + "/add");
    }

    /**
     * 新增园区数据
     */
    @ResponseBody
    @PostMapping("/save")
    @PreAuthorize("hasPermission('/data/park/add','data:park:add')")
    public Result save(@RequestBody DataPark dataPark) {
        return decide(dataParkService.save(dataPark));
    }

    /**
     * 修改园区数据
     */
    @GetMapping("/edit")
    @PreAuthorize("hasPermission('/data/park/edit','data:park:edit')")
    public ModelAndView edit(String id, ModelMap map) {
        DataPark dataPark =dataParkService.getById(id);
        map.put("dataPark", dataPark);
        return jumpPage(prefix + "/edit");
    }

    /**
     * 修改园区数据
     */
    @ResponseBody
    @PutMapping("/update")
    @PreAuthorize("hasPermission('/data/park/edit','data:park:edit')")
    public Result update(@RequestBody DataPark dataPark) {
        return decide(dataParkService.updateById(dataPark));
    }

    /**
     * 删除园区数据
     */
    @ResponseBody
    @DeleteMapping("/batchRemove")
    @PreAuthorize("hasPermission('/data/park/remove','data:park:remove')")
    public Result batchRemove(String ids) {
        return decide(dataParkService.removeByIds(Arrays.asList(ids.split(","))));
    }

    /**
     * 删除园区数据
     */
    @ResponseBody
    @DeleteMapping("/remove/{id}")
    @PreAuthorize("hasPermission('/data/park/remove','data:park:remove')")
    public Result remove(@PathVariable("id") Long id) {
        return decide(dataParkService.removeById(id));
    }
}
