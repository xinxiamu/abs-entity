package com.ymu.service.fileclient.vo;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class VBaseReq implements Serializable, Cloneable {

    @Override
    public String toString() {
        return "请求参数vo：" + JSON.toJSONString(this);
    }
}
