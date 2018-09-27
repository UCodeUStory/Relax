package com.ustory.relax_business_component.plugin;

/**
 * Created by qiyue on 2018/2/1.
 */

public class Plugin {
    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Plugin(String fileName, String pluginName) {
        FileName = fileName;
        this.key = pluginName;
    }

    private String FileName;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    private int version;

    private String path;

    private String key;
}
