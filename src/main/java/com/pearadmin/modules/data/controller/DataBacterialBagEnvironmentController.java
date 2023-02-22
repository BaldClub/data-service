package com.pearadmin.modules.data.controller;

import com.github.pagehelper.PageInfo;
import com.pearadmin.common.context.UserContext;
import com.pearadmin.modules.data.domain.DataBacterialBagEnvironment;
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
import com.pearadmin.modules.data.service.IDataBacterialBagEnvironmentService;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 菌包Controller
 *
 * @author leo
 * @date 2023-02-23
 */
@RestController
@RequestMapping("/data/bacterialBagEnvironment")
public class DataBacterialBagEnvironmentController extends BaseController {

    private String prefix = "data/bacterialBagEnvironment";

    @Autowired
    private IDataBacterialBagEnvironmentService dataBacterialBagEnvironmentService;

    @GetMapping("/main")
    @PreAuthorize("hasPermission('/data/bacterialBagEnvironment/main','data:bacterialBagEnvironment:main')")
    public ModelAndView main() {
        return jumpPage(prefix + "/main");
    }

    /**
     * 查询菌包列表
     */
    @ResponseBody
    @GetMapping("/data")
    @PreAuthorize("hasPermission('/data/bacterialBagEnvironment/data','data:bacterialBagEnvironment:data')")
    public ResultTable list(@ModelAttribute DataBacterialBagEnvironment dataBacterialBagEnvironment, PageDomain pageDomain) {
        PageInfo<DataBacterialBagEnvironment> pageInfo = dataBacterialBagEnvironmentService.selectDataBacterialBagEnvironmentPage(dataBacterialBagEnvironment, pageDomain);
        return pageTable(pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 新增菌包
     */
    @GetMapping("/add")
    @PreAuthorize("hasPermission('/data/bacterialBagEnvironment/add','data:bacterialBagEnvironment:add')")
    public ModelAndView add() {
        return jumpPage(prefix + "/add");
    }

    /**
     * 新增菌包
     */
    @ResponseBody
    @PostMapping("/save")
    @PreAuthorize("hasPermission('/data/bacterialBagEnvironment/add','data:bacterialBagEnvironment:add')")
    public Result save(@RequestBody DataBacterialBagEnvironment dataBacterialBagEnvironment) {
        return decide(dataBacterialBagEnvironmentService.save(dataBacterialBagEnvironment));
    }

    /**
     * 修改菌包
     */
    @GetMapping("/edit")
    @PreAuthorize("hasPermission('/data/bacterialBagEnvironment/edit','data:bacterialBagEnvironment:edit')")
    public ModelAndView edit(Long id, ModelMap map) {
        DataBacterialBagEnvironment dataBacterialBagEnvironment =dataBacterialBagEnvironmentService.getById(id);
        map.put("dataBacterialBagEnvironment", dataBacterialBagEnvironment);
        return jumpPage(prefix + "/edit");
    }

    /**
     * 修改菌包
     */
    @ResponseBody
    @PutMapping("/update")
    @PreAuthorize("hasPermission('/data/bacterialBagEnvironment/edit','data:bacterialBagEnvironment:edit')")
    public Result update(@RequestBody DataBacterialBagEnvironment dataBacterialBagEnvironment) {
        return decide(dataBacterialBagEnvironmentService.updateById(dataBacterialBagEnvironment));
    }

    /**
     * 删除菌包
     */
    @ResponseBody
    @DeleteMapping("/batchRemove")
    @PreAuthorize("hasPermission('/data/bacterialBagEnvironment/remove','data:bacterialBagEnvironment:remove')")
    public Result batchRemove(String ids) {
        return decide(dataBacterialBagEnvironmentService.removeByIds(Arrays.asList(ids.split(","))));
    }

    /**
     * 删除菌包
     */
    @ResponseBody
    @DeleteMapping("/remove/{id}")
    @PreAuthorize("hasPermission('/data/bacterialBagEnvironment/remove','data:bacterialBagEnvironment:remove')")
    public Result remove(@PathVariable("id") Long id) {
        return decide(dataBacterialBagEnvironmentService.removeById(id));
    }
}
