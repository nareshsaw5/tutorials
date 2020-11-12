package com.dodo.learning.designpattern.builder;

public class Mobile {

    private int ram, storage, battery, camera;
    private String processor;
    private double screenSize;

    public Mobile(MobileBuilder builder) {
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.battery = builder.battery;
        this.camera = builder.camera;
        this.processor = builder.processor;
        this.screenSize = builder.screenSize;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public int getBattery() {
        return battery;
    }

    public int getCamera() {
        return camera;
    }

    public String getProcessor() {
        return processor;
    }

    public double getScreenSize() {
        return screenSize;
    }

    @Override public String toString() {
        return "Mobile{" + "ram=" + ram + ", storage=" + storage + ", battery=" + battery + ", camera=" + camera + ", processor='" + processor + '\'' + ", screenSize=" + screenSize + '}';
    }
}
