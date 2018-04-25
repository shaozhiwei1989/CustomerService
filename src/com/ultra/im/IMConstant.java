package com.ultra.im;

import io.rong.RongCloud;

public class IMConstant {
    //公司测试
    public static final String RONG_YUN_APP_KEY = "8brlm7urp1750";
    public static final String RONG_YUN_APP_SECRET = "mzaB8UtQxWnC";
    //北分生产
    //    public static final String RONG_YUN_APP_KEY = "c9kqb3rkqoywj";
    //    public static final String RONG_YUN_APP_SECRET = "RWI8Z6FEcFr7PP";
    //北分测试
    //    public static final String RONG_YUN_APP_KEY = "bmdehs6derq5s";
    //    public static final String RONG_YUN_APP_SECRET = "Eet34DRbQ9aiT";
    public static final String INTER_500_ERROR = "接口后台出错！";
    public static final String INTER_200_SUCCESS = "success";
    public static final RongCloud RONG_CLOUD = RongCloud.getInstance(RONG_YUN_APP_KEY, RONG_YUN_APP_SECRET);
}