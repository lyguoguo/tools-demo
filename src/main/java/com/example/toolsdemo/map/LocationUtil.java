package com.example.toolsdemo.map;

import ch.hsr.geohash.GeoHash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.example.toolsdemo.map
 * @date:2019/4/29
 **/
public class LocationUtil {
    /**
     * 圆周率
     */
    private final static double PI = CoordinateConverter.PI;
    /**
     * 地球的半径
     */
    public final static double R  = CoordinateConverter.AXIS;

    /**
     * 获取geohash值
     *
     * @param latitude
     * @param longitude
     * @param numberOfCharacters 需要精确到第几位 1~12
     * @return
     */
    public static GeoHash getGeoHash(double latitude, double longitude, int numberOfCharacters) {
        if (latitude < -90 || latitude > 90 || longitude > 180 || longitude < -180) {
            latitude = 0;
            longitude = 0;
        }
        return GeoHash.withCharacterPrecision(latitude, longitude, numberOfCharacters);
    }

    /**
     * 坐标之间的距离
     *
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return 单位米
     */
    public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
        lat1 = Math.toRadians(lat1);
        lng1 = Math.toRadians(lng1);
        lat2 = Math.toRadians(lat2);
        lng2 = Math.toRadians(lng2);
        double d1 = Math.abs(lat1 - lat2);
        double d2 = Math.abs(lng1 - lng2);
        double p = Math.pow(Math.sin(d1 / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(d2 / 2), 2);
        double dis = R * 2 * Math.asin(Math.sqrt(p));
        return dis;
    }

    /**
     * 坐标半径raidus米范围的角点坐标
     *
     * @param lat
     * @param lon
     * @param raidus 单位 米
     * @return {minLat:xx,minLng:xx,maxLat:xx,maxLng:xx}
     */
    public static Map<String, Double> getAround(double lat, double lon, int raidus) {

        Double latitude = lat;
        Double longitude = lon;

        Double degree = (24901 * 1609) / 360.0;
        double raidusMile = raidus;

        Double dpmLat = 1 / degree;
        Double radiusLat = dpmLat * raidusMile;
        Double minLat = latitude - radiusLat;
        Double maxLat = latitude + radiusLat;

        Double mpdLng = degree * Math.cos(latitude * (PI / 180));
        Double dpmLng = 1 / mpdLng;
        Double radiusLng = dpmLng * raidusMile;
        Double minLng = longitude - radiusLng;
        Double maxLng = longitude + radiusLng;
        Map<String, Double> map = new HashMap<String, Double>();
        map.put("minLat", minLat);
        map.put("minLng", minLng);
        map.put("maxLat", maxLat);
        map.put("maxLng", maxLng);
        return map;
    }

}
