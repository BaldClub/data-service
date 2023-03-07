package com.pearadmin.modules.data.controller;

import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.common.web.domain.response.Result;
import com.pearadmin.common.web.domain.response.module.ResultTable;
import com.pearadmin.modules.data.domain.DataFarmingMaterial;
import com.pearadmin.modules.data.service.IDataFarmingMaterialService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * 农事材料Controller
 *
 * @author leo
 * @date 2023-02-23
 */
@RestController
@RequestMapping("/data/farmingMaterial")
public class DataFarmingMaterialController extends BaseController {

    private String prefix = "data/farmingMaterial";

    @Resource
    private IDataFarmingMaterialService dataFarmingMaterialService;

    @GetMapping("/main")
    @PreAuthorize("hasPermission('/data/farmingMaterial/main','data:farmingMaterial:main')")
    public ModelAndView main() {
        return jumpPage(prefix + "/main");
    }

    /**
     * 查询农事材料列表
     */
    @ResponseBody
    @GetMapping("/data")
    @PreAuthorize("hasPermission('/data/farmingMaterial/data','data:farmingMaterial:data')")
    public ResultTable list(@ModelAttribute DataFarmingMaterial dataFarmingMaterial, PageDomain pageDomain) {
        PageInfo<DataFarmingMaterial> pageInfo = dataFarmingMaterialService.selectDataFarmingMaterialPage(dataFarmingMaterial, pageDomain);
        return pageTable(pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 新增农事材料
     */
    @GetMapping("/add")
    @PreAuthorize("hasPermission('/data/farmingMaterial/add','data:farmingMaterial:add')")
    public ModelAndView add() {
        return jumpPage(prefix + "/add");
    }

    /**
     * 新增农事材料
     */
    @ResponseBody
    @PostMapping("/save")
    @PreAuthorize("hasPermission('/data/farmingMaterial/add','data:farmingMaterial:add')")
    public Result save(@RequestBody DataFarmingMaterial dataFarmingMaterial) {
        return decide(dataFarmingMaterialService.save(dataFarmingMaterial));
    }

    /**
     * 修改农事材料
     */
    @GetMapping("/edit")
    @PreAuthorize("hasPermission('/data/farmingMaterial/edit','data:farmingMaterial:edit')")
    public ModelAndView edit(String id, ModelMap map) {
        DataFarmingMaterial dataFarmingMaterial =dataFarmingMaterialService.getById(id);
        map.put("dataFarmingMaterial", dataFarmingMaterial);
        return jumpPage(prefix + "/edit");
    }

    /**
     * 修改农事材料
     */
    @ResponseBody
    @PutMapping("/update")
    @PreAuthorize("hasPermission('/data/farmingMaterial/edit','data:farmingMaterial:edit')")
    public Result update(@RequestBody DataFarmingMaterial dataFarmingMaterial) {
        return decide(dataFarmingMaterialService.updateById(dataFarmingMaterial));
    }

    /**
     * 删除农事材料
     */
    @ResponseBody
    @DeleteMapping("/batchRemove")
    @PreAuthorize("hasPermission('/data/farmingMaterial/remove','data:farmingMaterial:remove')")
    public Result batchRemove(String ids) {
        return decide(dataFarmingMaterialService.removeByIds(Arrays.asList(ids.split(","))));
    }

    /**
     * 删除农事材料
     */
    @ResponseBody
    @DeleteMapping("/remove/{id}")
    @PreAuthorize("hasPermission('/data/farmingMaterial/remove','data:farmingMaterial:remove')")
    public Result remove(@PathVariable("id") Long id) {
        return decide(dataFarmingMaterialService.removeById(id));
    }
}
