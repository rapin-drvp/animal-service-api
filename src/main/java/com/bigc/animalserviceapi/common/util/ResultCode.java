package com.bigc.animalserviceapi.common.util;

public class ResultCode {
    public static final Status SUCCESS = new Status("0","Success");
    public static final Status FAIL = new Status("-1", "Fail");
    public static final Status INVALID_PARAM = new Status("1001","Invalid Param");
    public static final Status DATA_NOT_FOUND = new Status("1002","Data Not Found");
    public static final Status SYSTEM_ERROR = new Status("5001","System Error");
}
