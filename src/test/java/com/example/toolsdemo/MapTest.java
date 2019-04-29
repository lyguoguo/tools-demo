package com.example.toolsdemo;

import com.alibaba.fastjson.JSON;
import com.example.toolsdemo.map.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.example.toolsdemo
 * @date:2019/4/29
 **/
@Slf4j
public class MapTest extends ToolsDemoApplicationTests{

    @Test
    public void s842J02(){
        //117.20296517261839,31.841652709281103
        //39.4502236600,102.3888644800
        //31.6997411300,117.1275504500
        //30.2325704900,120.2040342200
        //116.481499,39.990475|116.481499,39.990375
        //39.1632171277,116.9764091450
        double longitude = 116.9764091450;
        double latitude = 39.1632171277;

        //39.4511100000,102.3908770000
        //30.2301589500,120.2085984900
        //116.487585177952,39.991754014757;116.487585177952,39.991653917101
        //39.1641410477,116.9824218750
        //116.982440321181,39.164154188369
        double aftLon = 116.982440321181;
        double aftLat = 39.164154188369;

        Gps gps = PositionUtil.gps84_To_Gcj02(longitude,latitude);
        Assert.assertNotNull(gps);

        System.out.println("转换前经纬度：{"+ latitude+","+longitude+"}");
        System.out.println("转换后经纬度："+ JSON.toJSON(gps));

        double distince = LocationUtil.getDistance(aftLat,aftLon,gps.getWgLat(),gps.getWgLon());
        System.out.println("偏移距离："+distince+"米");
    }
}
