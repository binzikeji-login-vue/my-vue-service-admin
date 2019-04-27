package com.binzikeji.my.vue.service.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description
 * @Author Bin
 * @Date 2019/4/10 18:14
 **/
@Data
public class BaseRestult implements Serializable {

    private static final String RESTULT_OK = "ok";
    private static final String RESTULT_NOT_OK = "not_ok";
    private static final String SUCCESS = "操作成功";

    private String result;
    private Object data;
    private String success;
    private Cursor cursor;
    private List<Error> errors;

    public static BaseRestult ok(){
        return createResult(RESTULT_OK, null, SUCCESS, null, null);
    }

    public static BaseRestult ok(String muccess){
        return createResult(RESTULT_OK, null, muccess, null, null);
    }

    public static BaseRestult ok(Object data){
        return createResult(RESTULT_OK, data, SUCCESS, null, null);
    }

    public static BaseRestult ok(Object data, Cursor cursor){
        return createResult(RESTULT_OK, data, SUCCESS, cursor, null);
    }

    public static BaseRestult notOk(List<Error> errors){
        return createResult(RESTULT_NOT_OK, null, "", null, errors);
    }

    /**
     *
     * @param result
     * @param data
     * @param success
     * @param cursor
     * @param errors
     * @return
     */
    private static BaseRestult createResult(String result, Object data, String success, Cursor cursor, List<Error> errors){
        BaseRestult baseRestult = new BaseRestult();
        baseRestult.setResult(result);
        baseRestult.setData(data);
        baseRestult.setSuccess(success);
        baseRestult.setCursor(cursor);
        baseRestult.setErrors(errors);
        return baseRestult;
    }

    @Data
    public static class Cursor{

        private int total;
        private int offset;
        private int limit;
    }

    @Data
    @AllArgsConstructor
    public static class Error{

        private String field;
        private String message;
    }
}
