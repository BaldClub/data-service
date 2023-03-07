package com.pearadmin;

import com.pearadmin.mock.*;
import com.pearadmin.modules.data.domain.*;
import com.pearadmin.modules.data.service.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockData extends FakerUtil {

    private static int count = 100;

    @Resource
    private IDataBacterialBagEnvironmentService dataBacterialBagEnvironmentService;

    @Resource
    private IDataBacterialBagService dataBacterialBagService;

    @Resource
    private IDataBacterialRoomDeviceService dataBacterialRoomDeviceService;

    @Resource
    private IDataBacterialRoomEnvironmentService dataBacterialRoomEnvironmentService;

    @Resource
    private IDataBacterialRoomService dataBacterialRoomService;

    @Resource
    private IDataFarmingMaterialService dataFarmingMaterialService;

    @Resource
    private IDataFarmingStatisticsService dataFarmingStatisticsService;

    @Resource
    private IDataInternetOfThingsDevicesService dataInternetOfThingsDevicesService;

    @Resource
    private IDataParkService dataParkService;

    @Resource
    private IDataPoliceService dataPoliceService;

    @Resource
    private IDataProductComplainService dataProductComplainService;

    @Resource
    private IDataProductSaleService dataProductSaleService;

    @Resource
    private IDataProductService dataProductService;

    @Resource
    private IDataProductTraceScanService dataProductTraceScanService;

    @Resource
    private IDataStrainsService dataStrainsService;

    private List<DataBacterialRoom> roomList;

    private List<DataProduct> productList;

    @Test
    public void mockDataBacterialBagEnvironment() {
        List<DataBacterialBagEnvironment> list = new ArrayList<>();
        DataBacterialBagEnvironmentMock mock = new DataBacterialBagEnvironmentMock();

        for (int i = 0; i < count; i++) {
            list.add(mock.createData());
        }

        Assert.assertTrue(dataBacterialBagEnvironmentService.saveBatch(list));
    }

    @Test
    public void mockDataBacterialBag() {
        List<DataBacterialBag> list = new ArrayList<>();
        DataBacterialBagMock mock = new DataBacterialBagMock();
        DataBacterialBag data = null;

        for (int i = 0; i < count; i++) {
            data = mock.createData();
            data.setBacterialRoomId(getBacterialRoomId());
            list.add(data);
        }

        Assert.assertTrue(dataBacterialBagService.saveBatch(list));
    }


    @Test
    public void mockDataBacterialRoomDevice() {
        List<DataBacterialRoomDevice> list = new ArrayList<>();
        DataBacterialRoomDeviceMock mock = new DataBacterialRoomDeviceMock();
        DataBacterialRoomDevice data;

        for (int i = 0; i < count; i++) {
            data = mock.createData();
            data.setBacterialRoomId(getBacterialRoomId());
            list.add(data);
        }

        Assert.assertTrue(dataBacterialRoomDeviceService.saveBatch(list));
    }

    @Test
    public void mockDataBacterialRoomEnvironment() {
        List<DataBacterialRoomEnvironment> list = new ArrayList<>();
        DataBacterialRoomEnvironmentMock mock = new DataBacterialRoomEnvironmentMock();

        for (int i = 0; i < count; i++) {
            list.add(mock.createData());
        }

        Assert.assertTrue(dataBacterialRoomEnvironmentService.saveBatch(list));
    }

    @Test
    @Order(1)
    public void mockDataBacterialRoom() {
        List<DataBacterialRoom> list = new ArrayList<>();
        DataBacterialRoomMock mock = new DataBacterialRoomMock();

        for (int i = 0; i < count; i++) {
            list.add(mock.createData());
        }

        Assert.assertTrue(dataBacterialRoomService.saveBatch(list));
    }

    @Test
    public void mockDataFarmingMaterial() {
        List<DataFarmingMaterial> list = new ArrayList<>();
        DataFarmingMaterialMock mock = new DataFarmingMaterialMock();

        for (int i = 0; i < count; i++) {
            list.add(mock.createData());
        }

        Assert.assertTrue(dataFarmingMaterialService.saveBatch(list));
    }

    @Test
    public void mockDataFarmingStatisticsMock() {
        List<DataFarmingStatistics> list = new ArrayList<>();
        DataFarmingStatisticsMock mock = new DataFarmingStatisticsMock();

        for (int i = 0; i < count; i++) {
            list.add(mock.createData());
        }

        Assert.assertTrue(dataFarmingStatisticsService.saveBatch(list));
    }

    @Test
    public void mockDataInternetOfThingsDevices() {
        List<DataInternetOfThingsDevices> list = new ArrayList<>();
        DataInternetOfThingsDevicesMock mock = new DataInternetOfThingsDevicesMock();

        for (int i = 0; i < count; i++) {
            list.add(mock.createData());
        }

        Assert.assertTrue(dataInternetOfThingsDevicesService.saveBatch(list));
    }

    @Test
    public void mockDataPark() {
        List<DataPark> list = new ArrayList<>();
        DataParkMock mock = new DataParkMock();

        for (int i = 0; i < count; i++) {
            list.add(mock.createData());
        }

        Assert.assertTrue(dataParkService.saveBatch(list));
    }

    @Test
    public void mockDataPolice() {
        List<DataPolice> list = new ArrayList<>();
        DataPoliceMock mock = new DataPoliceMock();

        for (int i = 0; i < count; i++) {
            list.add(mock.createData());
        }

        Assert.assertTrue(dataPoliceService.saveBatch(list));
    }

    @Test
    public void mockDataProductComplain() {
        List<DataProductComplain> list = new ArrayList<>();
        DataProductComplainMock mock = new DataProductComplainMock();
        DataProductComplain data;

        for (int i = 0; i < count; i++) {
            data = mock.createData();
            data.setProductId(getProductId());
            list.add(data);
        }

        Assert.assertTrue(dataProductComplainService.saveBatch(list));
    }

    @Test
    public void mockDataProduct() {
        List<DataProduct> list = new ArrayList<>();
        DataProductMock mock = new DataProductMock();

        for (int i = 0; i < count; i++) {
            list.add(mock.createData());
        }

        Assert.assertTrue(dataProductService.saveBatch(list));
    }

    @Test
    public void mockDataProductSale() {
        List<DataProductSale> list = new ArrayList<>();
        DataProductSaleMock mock = new DataProductSaleMock();
        DataProductSale data;

        for (int i = 0; i < count; i++) {
            data = mock.createData();
            data.setProductId(getProductId());
            list.add(data);
        }

        Assert.assertTrue(dataProductSaleService.saveBatch(list));
    }

    @Test
    public void mockDataProductTraceScan() {
        List<DataProductTraceScan> list = new ArrayList<>();
        DataProductTraceScanMock mock = new DataProductTraceScanMock();
        DataProductTraceScan data;

        for (int i = 0; i < count; i++) {
            data = mock.createData();
            data.setProductId(getProductId());
            list.add(data);
        }

        Assert.assertTrue(dataProductTraceScanService.saveBatch(list));
    }

    @Test
    public void mockDataStrains() {
        List<DataStrains> list = new ArrayList<>();
        DataStrainsMock mock = new DataStrainsMock();
        DataStrains data;

        for (int i = 0; i < count; i++) {
            data = mock.createData();
            data.setBacterialRoomId(getBacterialRoomId());
            list.add(data);
        }

        Assert.assertTrue(dataStrainsService.saveBatch(list));
    }

    private String getBacterialRoomId() {
        if (roomList == null) {
            roomList = dataBacterialRoomService.list();
        }
        return roomList.get(randomNumber(roomList.size())).getId();
    }

    private String getProductId() {
        if (productList == null) {
            productList = dataProductService.list();
        }
        return productList.get(randomNumber(productList.size())).getId();
    }
}
