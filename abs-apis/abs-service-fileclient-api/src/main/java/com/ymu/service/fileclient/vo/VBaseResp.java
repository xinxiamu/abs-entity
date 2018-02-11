package com.ymu.service.fileclient.vo;

import com.alibaba.fastjson.JSON;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;

public abstract class VBaseResp extends ResourceSupport implements Serializable, Cloneable {

    @Override
    public String toString() {
        return "请求响应vo：" + JSON.toJSONString(this);
    }
}
