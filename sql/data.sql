-- data-service
drop table data_park;
create table data_park
(
    id                   char(19) comment '编号',
    factory_area         int          null comment '工厂面积',
    mushroom_houses      int          null comment '菇房数量',
    cultivated_varieties int          null comment '栽培品种数量',
    url                  varchar(255) null comment '首页直播地址'
) comment '园区数据表';

drop table data_internet_of_things_devices;
create table data_internet_of_things_devices
(
    id          char(19) comment '编号',
    `status`    varchar(64)  null comment '设备状态',
    type        varchar(64)  null comment '设备类型 (环境监测设备、远程监控设备、食用菌生产设备、溯源设备)',
    price       int          null comment '设备价格',
    config_time datetime     null comment '配置时间',
    url         varchar(255) null comment '直播视频链接'
) comment '物联网设备数据表';

drop table data_product;
create table data_product
(
    id     char(19) comment '编号',
    `name` varchar(64) null comment '产品名称',
    price  int         null comment '产品售价'
) comment '产品表';

drop table data_product_trace_scan;
create table data_product_trace_scan
(
    id         char(19) comment '编号',
    `time`     datetime null comment '时间',
    product_id int      null comment '产品编号'
) comment '产品溯源扫码数据表';

drop table data_product_sale;
create table data_product_sale
(
    id         char(19) comment '编号',
    `time`     datetime null comment '售出时间',
    product_id int      null comment '产品编号'
) comment '产品销售表';

drop table data_product_complain;
create table data_product_complain
(
    id         char(19) comment '编号',
    `time`     datetime     null comment '投诉时间',
    content    varchar(255) null comment '投诉内容',
    product_id int          null comment '投诉产品编号'
) comment '产品投诉表';


drop table data_farming_material;
create table data_farming_material
(
    id     char(19) comment '编号',
    type   varchar(64) null comment '类型 (原材料购买, 原材料消耗, 能源消耗, 药品消耗)',
    price  int         null comment '价格',
    `time` datetime    null comment '时间'
) comment '农事材料表';

drop table data_farming_statistics;
create table data_farming_statistics
(
    id      char(19) comment '编号',
    type    varchar(64) null comment '农事类型 (采摘, 病虫害防治, 菌包上下架)',
    `count` int         null comment '次数',
    `time`  datetime    null comment '时间'
) comment '农事统计表';

drop table data_strains;
create table data_strains
(
    id                char(19) comment '编号',
    type              varchar(64) null comment '农事类型 (平菇、香菇、茶树菇、木耳、金针菇、杏鲍菇)',
    `number`          int         null comment '种植数量 (亩)',
    output            int         null comment '产量 (kg)',
    bacterial_room_id int         null comment '菌房编号'
) comment '菌株表';

drop table data_bacterial_room;
create table data_bacterial_room
(
    id       char(19) comment '编号',
    `name`   varchar(64) null comment '菌房名称',
    location varchar(64) null comment '菌房位置'
) comment '菌房表';

drop table data_bacterial_room_environment;
create table data_bacterial_room_environment
(
    id              char(19) comment '编号',
    temperature     int      null comment '空气温度 (摄氏度)',
    humidity        int      null comment '空气湿度 (%)',
    illumination    int      null comment '光照 (lux)',
    `time`          datetime null comment '时间',
    carbon_dioxide  int      null comment '二氧化碳浓度 (ppm)',
    carbon_monoxide int      null comment '一氧化碳浓度 (ppm)'
) comment '菌房表';

drop table data_bacterial_room_device;
create table data_bacterial_room_device
(
    id                char(19) comment '编号',
    bacterial_room_id int         null comment '菌房编号',
    `type`            varchar(64) null comment '设备类型'
) comment '菌房设备表';

drop table data_bacterial_bag;
create table data_bacterial_bag
(
    id                char(19) comment '编号',
    bacterial_room_id int         null comment '菌房编号',
    `type`            varchar(64) null comment '菌包品种 (平菇、香菇、茶树菇、木耳、金针菇、杏鲍菇)'
) comment '菌包表';

drop table data_bacterial_bag_environment;
create table data_bacterial_bag_environment
(
    id          char(19) comment '编号',
    temperature int      null comment '空气温度 (摄氏度)',
    humidity    int      null comment '空气湿度 (%)',
    ph          int      null comment 'PH值',
    `time`      datetime null comment '时间'
) comment '菌包表';

drop table data_police;
create table data_police
(
    id     char(19) comment '编号',
    `type` varchar(64) null comment '报警类型 (环境报警, 生产报警, 设备报警, 农资农事报警, 监控报警)',
    `time` datetime    null comment '时间'
) comment '报警表';
