package com.example.ticketing.dto;

public class AppInfo {
    private String appName;
    private String version;
    private String status;

    public AppInfo(String appName, String version, String status) {
        this.appName = appName;
        this.version = version;
        this.status = status;
    }

    public String getAppName() {
        return appName;
    }

    public String getStatus() {
        return status;
    }

    public String getVersion() {
        return version;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
