package com.stone.common;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class Result<T> implements Serializable {

    private Integer code; //编码：1成功，0和其它数字为失败

    private String msg; //错误信息

    private T data; //数据

    private Map map = new HashMap(); //动态数据

    //通过该方法生成一个成功的Result对象
    public static <T> Result<T> success(T object) {
        Result<T> res = new Result<T>(); //new一个新的Result对象
        res.data = object;
        res.code = 1;
        return res;
    }


    public static <T> Result<T> error(String msg) {
        Result res = new Result();
        res.msg = msg;
        res.code = 0;
        return res;
    }

    public Result<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }


}

