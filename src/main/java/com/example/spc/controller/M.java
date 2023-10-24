//package com.example.spc.controller;
//
//
//import cn.hutool.http.HttpUtil;
//
//public class M {
//    /**
//     * 从高德地图地铁线路同步全国地铁站数据（非必要不调用）
//     * 数据来源：http://map.amap.com/subway/index.html?&4401
//     */
////    @GetMapping("/subwayParser")
//    public void subwayParser() {
//        String[] links = {
//                "https://map.amap.com/service/subway?_1684218661470&srhdata=1100_drw_beijing.json",
//                "https://map.amap.com/service/subway?_1684218693712&srhdata=3100_drw_shanghai.json",
//                "https://map.amap.com/service/subway?_1684218708196&srhdata=4401_drw_guangzhou.json",
//                "https://map.amap.com/service/subway?_1684218719262&srhdata=4403_drw_shenzhen.json",
//                "https://map.amap.com/service/subway?_1684218731379&srhdata=4201_drw_wuhan.json",
//                "https://map.amap.com/service/subway?_1684218743629&srhdata=1200_drw_tianjin.json",
//                "https://map.amap.com/service/subway?_1684218759393&srhdata=3201_drw_nanjing.json",
//                "https://map.amap.com/service/subway?_1684218773376&srhdata=8100_drw_xianggang.json",
//                "https://map.amap.com/service/subway?_1684218803777&srhdata=5000_drw_chongqing.json",
//                "https://map.amap.com/service/subway?_1684217707451&srhdata=3301_drw_hangzhou.json",
//                "https://map.amap.com/service/subway?_1684218833591&srhdata=2101_drw_shenyang.json",
//                "https://map.amap.com/service/subway?_1684218852774&srhdata=2102_drw_dalian.json",
//                "https://map.amap.com/service/subway?_1684218869557&srhdata=5101_drw_chengdu.json",
//                "https://map.amap.com/service/subway?_1684218886740&srhdata=2201_drw_changchun.json",
//                "https://map.amap.com/service/subway?_1684218905074&srhdata=3205_drw_suzhou.json",
//                "https://map.amap.com/service/subway?_1684218920973&srhdata=4406_drw_foshan.json",
//                "https://map.amap.com/service/subway?_1684218936956&srhdata=5301_drw_kunming.json",
//                "https://map.amap.com/service/subway?_1684218956105&srhdata=6101_drw_xian.json",
//                "https://map.amap.com/service/subway?_1684218976721&srhdata=4101_drw_zhengzhou.json",
//                "https://map.amap.com/service/subway?_1684219002370&srhdata=4301_drw_changsha.json",
//                "https://map.amap.com/service/subway?_1684219044819&srhdata=3302_drw_ningbo.json",
//                "https://map.amap.com/service/subway?_1684219064385&srhdata=3202_drw_wuxi.json",
//                "https://map.amap.com/service/subway?_1684219087401&srhdata=3702_drw_qingdao.json",
//                "https://map.amap.com/service/subway?_1684219109584&srhdata=3601_drw_nanchang.json",
//                "https://map.amap.com/service/subway?_1684219127182&srhdata=3501_drw_fuzhou.json",
//                "https://map.amap.com/service/subway?_1684219147299&srhdata=4419_drw_dongguan.json",
//                "https://map.amap.com/service/subway?_1684219174915&srhdata=4501_drw_nanning.json",
//                "https://map.amap.com/service/subway?_1684219192214&srhdata=3401_drw_hefei.json",
//                "https://map.amap.com/service/subway?_1684219209797&srhdata=5201_drw_guiyang.json",
//                "https://map.amap.com/service/subway?_1684219228846&srhdata=3502_drw_xiamen.json",
//                "https://map.amap.com/service/subway?_1684219243963&srhdata=2301_drw_haerbin.json",
//                "https://map.amap.com/service/subway?_1684219261162&srhdata=1301_drw_shijiazhuang.json",
//                "https://map.amap.com/service/subway?_1684219275594&srhdata=6501_drw_wulumuqi.json",
//                "https://map.amap.com/service/subway?_1684219292478&srhdata=3303_drw_wenzhou.json",
//                "https://map.amap.com/service/subway?_1684219308833&srhdata=3701_drw_jinan.json",
//                "https://map.amap.com/service/subway?_1684219330534&srhdata=6201_drw_lanzhou.json",
//                "https://map.amap.com/service/subway?_1684219353633&srhdata=3204_drw_changzhou.json",
//                "https://map.amap.com/service/subway?_1684219370051&srhdata=3203_drw_xuzhou.json",
//                "https://map.amap.com/service/subway?_1684219391167&srhdata=1401_drw_taiyuan.json",
//                "https://map.amap.com/service/subway?_1684219404866&srhdata=1501_drw_huhehaote.json",
//                "https://map.amap.com/service/subway?_1684219420149&srhdata=4103_drw_luoyang.json"
//        };
//
//        // 输出数组中的链接
//        for (String link : links) {
//            String subwayData = HttpUtil.get(link, 10000);
////            log.info("抓取到的地铁站数据：data = {}", subwayData);
//
//            JSONObject jsonObject = new JSONObject(subwayData);
//
//            List<AppSubwayData> appSubwayDataList = new ArrayList<>();
//
//            // 获取城市名称
//            String city = jsonObject.getString("s");
//            log.info("城市: " + city);
//
//            // 获取线路信息
//            JSONArray lineArray = jsonObject.getJSONArray("l");
//            for (int i = 0; i < lineArray.length(); i++) {
//                JSONObject lineObject = lineArray.getJSONObject(i);
//
//                // 获取线路名称
//                String lineName = lineObject.getString("ln");
//                log.info("线路名称: " + lineName);
//                String lineIdentifier = lineObject.getString("ls");
//                log.info("线路标识: " + lineIdentifier);
//
//                JSONArray stationArray = lineObject.getJSONArray("st");
//                for (int j = 0; j < stationArray.length(); j++) {
//                    JSONObject stationObject = stationArray.getJSONObject(j);
//
//                    AppSubwayData appSubwayData = new AppSubwayData();
//                    // 按照"地铁"分隔字符串
//                    String[] subwayArray = city.split("地铁");
//                    appSubwayData.setName(subwayArray[0].trim());
//                    appSubwayData.setCityName(city);
//                    appSubwayData.setLineName(lineName);
//                    appSubwayData.setLineIdentifier(lineIdentifier);
//                    // 获取站点名称
//                    String stationName = stationObject.getString("n");
//                    log.info("站名: " + stationName);
//                    appSubwayData.setStation(stationName);
//
//                    // 获取经纬度
//                    String coordinates = stationObject.getString("sl");
//                    String[] latLng = coordinates.split(",");
//                    double latitude = Double.parseDouble(latLng[0]);
//                    double longitude = Double.parseDouble(latLng[1]);
//                    log.info("经度: " + latitude);
//                    appSubwayData.setLatitude(BigDecimal.valueOf(latitude));
//                    log.info("纬度: " + longitude);
//                    appSubwayData.setLongitude(BigDecimal.valueOf(longitude));
//                    appSubwayDataList.add(appSubwayData);
//                }
//            }
//            if (CollectionUtil.isNotEmpty(appSubwayDataList)) {
//                boolean saveBatch = this.appSubwayDataService.saveBatch(appSubwayDataList);
//                if (saveBatch) {
//                    log.info("成功保存{}的地铁站数据{}条...", city, appSubwayDataList.size());
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
