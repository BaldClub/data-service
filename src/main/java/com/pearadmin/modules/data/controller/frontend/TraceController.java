package com.pearadmin.modules.data.controller.frontend;

import com.alibaba.fastjson.JSONObject;
import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.response.module.ResultTable;
import com.pearadmin.modules.data.mapper.DataProductTraceScanMapper;
import com.pearadmin.modules.data.service.IDataProductSaleService;
import com.pearadmin.modules.data.service.IDataProductTraceScanService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDate;

@RestController
@Api(tags = {"溯源页面数据"})
@RequestMapping("/api/trace")
public class TraceController extends BaseController {

    @Resource
    private IDataProductTraceScanService scanService;

    @Resource
    private IDataProductSaleService saleService;

    @Resource
    private DataProductTraceScanMapper scanMapper;

    /**
     * 扫码数据分析
     */
    @GetMapping("scan")
    public ResultTable scan() {
        JSONObject result = new JSONObject();
        result.put("todayScanCount", scanService.query().gt("time", LocalDate.now().plusDays(-1)).count());
        result.put("scanCount", scanService.count());
        result.put("todaySoldCount", saleService.query().gt("time", LocalDate.now().plusDays(-1)).count());
        result.put("soldCount", saleService.count());

        return dataTable(result);
    }

    /**
     * 扫码趋势
     * @return
     */
    @GetMapping("scanTrend")
    public ResultTable scanTrend() {
        return dataTable(scanMapper.groupByMonth());
    }

    //扫码销售对比
    //月份
    //类型（扫码、销售）【也可去除，可返回两条数据】
    //数量
//    @GetMapping("")
//    public

    //扫码记录
        //产品名称
        //产品编号
        //扫码时间
    //🚧客户分布统计 （无数据库）
    //贵州：650；重庆：423；四川：310；湖南：280；湖北：220；广东：180；上海：150等
    //省份
    //数量

}
