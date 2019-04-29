package com.example.toolsdemo.map;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.example.toolsdemo.map
 * @date:2019/4/29
 **/
public class Gps {
    private double wgLat;
    private double wgLon;

    public Gps(double wgLon, double wgLat) {
        this.wgLon = wgLon;
        this.wgLat = wgLat;
    }

    public double getWgLat() {
        return wgLat;
    }

    public void setWgLat(double wgLat) {
        this.wgLat = wgLat;
    }

    public double getWgLon() {
        return wgLon;
    }

    public void setWgLon(double wgLon) {
        this.wgLon = wgLon;
    }

    @Override
    public String toString() {
        return wgLat + "," + wgLon;
    }

}
