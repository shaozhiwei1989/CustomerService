package io.rong.util;

public enum HostType {
    //API("http://api.cn.ronghub.com"), SMS("http://api.sms.ronghub.com"); //公有云
    //    API("http://132.90.154.196:8081"), SMS("http://api.sms.ronghub.com"); //私有云
    API("http://120.92.9.229:81"), SMS("http://api.sms.ronghub.com"); //私有云
    private String type;

    private HostType(String type) {
        this.type = type;
    }

    public static HostType getType(String state) {
        for (HostType deviceType : HostType.values()) {
            if (deviceType.type.equalsIgnoreCase(state)) {
                return deviceType;
            }
        }
        throw new RuntimeException(state + " is not a valid Host Type!");
    }

    public String getStrType() {
        return type;
    }
}