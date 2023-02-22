package com.pearadmin.modules.data.controller;

import com.github.pagehelper.PageInfo;
import com.pearadmin.common.context.UserContext;
import com.pearadmin.modules.data.domain.DataStrains;
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
import com.pearadmin.modules.data.service.IDataStrainsService;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 菌株Controller
 *
 * @author leo
 * @date 2023-02-23
 */
@RestController
@RequestMapping("/data/strains")
public class DataStrainsController extends BaseController {

    private String prefix = "data/strains";

    @Autowired
    private IDataStrainsService dataStrainsService;

    @GetMapping("/main")
    @PreAuthorize("hasPermission('/data/strains/main','data:strains:main')")
    public ModelAndView main() {
        return jumpPage(prefix + "/main");
    }

    /**
     * 查询菌株列表
     */
    @ResponseBody
    @GetMapping("/data")
    @PreAuthorize("hasPermission('/data/strains/data','data:strains:data')")
    public ResultTable list(@ModelAttribute DataStrains dataStrains, PageDomain pageDomain) {
        PageInfo<DataStrains> pageInfo = dataStrainsService.selectDataStrainsPage(dataStrains, pageDomain);
        return pageTable(pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 新增菌株
     */
    @GetMapping("/add")
    @PreAuthorize("hasPermission('/data/strains/add','data:strains:add')")
    public ModelAndView add() {
        return jumpPage(prefix + "/add");
    }

    /**
     * 新增菌株
     */
    @ResponseBody
    @PostMapping("/save")
    @PreAuthorize("hasPermission('/data/strains/add','data:strains:add')")
    public Result save(@RequestBody DataStrains dataStrains) {
        return decide(dataStrainsService.save(dataStrains));
    }

    /**
     * 修改菌株
     */
    @GetMapping("/edit")
    @PreAuthorize("hasPermission('/data/strains/edit','data:strains:edit')")
    public ModelAndView edit(Long id, ModelMap map) {
        DataStrains dataStrains =dataStrainsService.getById(id);
        map.put("dataStrains", dataStrains);
        return jumpPage(prefix + "/edit");
    }

    /**
     * 修改菌株
     */
    @ResponseBody
    @PutMapping("/update")
    @PreAuthorize("hasPermission('/data/strains/edit','data:strains:edit')")
    public Result update(@RequestBody DataStrains dataStrains) {
        return decide(dataStrainsService.updateById(dataStrains));
    }

    /**
     * 删除菌株
     */
    @ResponseBody
    @DeleteMapping("/batchRemove")
    @PreAuthorize("hasPermission('/data/strains/remove','data:strains:remove')")
    public Result batchRemove(String ids) {
        return decide(dataStrainsService.removeByIds(Arrays.asList(ids.split(","))));
    }

    /**
     * 删除菌株
     */
    @ResponseBody
    @DeleteMapping("/remove/{id}")
    @PreAuthorize("hasPermission('/data/strains/remove','data:strains:remove')")
    public Result remove(@PathVariable("id") Long id) {
        return decide(dataStrainsService.removeById(id));
    }
}
