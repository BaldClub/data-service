package com.pearadmin.modules.data.controller;

import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.common.web.domain.response.Result;
import com.pearadmin.common.web.domain.response.module.ResultTable;
import com.pearadmin.modules.data.domain.DataCustom;
import com.pearadmin.modules.data.service.IDataCustomService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * 自定义数据Controller
 *
 * @author leo
 * @date 2023-04-12
 */
@RestController
@RequestMapping("/data/custom")
public class DataCustomController extends BaseController {

    private String prefix = "data/custom";

    @Resource
    private IDataCustomService dataCustomService;

    @GetMapping("/main")
    @PreAuthorize("hasPermission('/data/custom/main','data:custom:main')")
    public ModelAndView main() {
        return jumpPage(prefix + "/main");
    }

    /**
     * 查询自定义数据列表
     */
    @ResponseBody
    @GetMapping("/data")
    @PreAuthorize("hasPermission('/data/custom/data','data:custom:data')")
    public ResultTable list(@ModelAttribute DataCustom dataCustom, PageDomain pageDomain) {
        PageInfo<DataCustom> pageInfo = dataCustomService.selectDataCustomPage(dataCustom, pageDomain);
        return pageTable(pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 新增自定义数据
     */
    @GetMapping("/add")
    @PreAuthorize("hasPermission('/data/custom/add','data:custom:add')")
    public ModelAndView add() {
        return jumpPage(prefix + "/add");
    }

    /**
     * 新增自定义数据
     */
    @ResponseBody
    @PostMapping("/save")
    @PreAuthorize("hasPermission('/data/custom/add','data:custom:add')")
    public Result save(@RequestBody DataCustom dataCustom) {
        return decide(dataCustomService.save(dataCustom));
    }

    /**
     * 修改自定义数据
     */
    @GetMapping("/edit")
    @PreAuthorize("hasPermission('/data/custom/edit','data:custom:edit')")
    public ModelAndView edit(String id, ModelMap map) {
        DataCustom dataCustom = dataCustomService.getById(id);
        map.put("dataCustom", dataCustom);
        return jumpPage(prefix + "/edit");
    }

    /**
     * 修改自定义数据
     */
    @ResponseBody
    @PutMapping("/update")
    @PreAuthorize("hasPermission('/data/custom/edit','data:custom:edit')")
    public Result update(@RequestBody DataCustom dataCustom) {
        return decide(dataCustomService.updateById(dataCustom));
    }

    /**
     * 删除自定义数据
     */
    @ResponseBody
    @DeleteMapping("/batchRemove")
    @PreAuthorize("hasPermission('/data/custom/remove','data:custom:remove')")
    public Result batchRemove(String ids) {
        return decide(dataCustomService.removeByIds(Arrays.asList(ids.split(","))));
    }

    /**
     * 删除自定义数据
     */
    @ResponseBody
    @DeleteMapping("/remove/{id}")
    @PreAuthorize("hasPermission('/data/custom/remove','data:custom:remove')")
    public Result remove(@PathVariable("id") String id) {
        return decide(dataCustomService.removeById(id));
    }
}
