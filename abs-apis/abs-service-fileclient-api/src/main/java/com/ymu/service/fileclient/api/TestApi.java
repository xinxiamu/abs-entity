package com.ymu.service.fileclient.api;

import com.ymu.service.fileclient.vo.req.VTestReq;
import com.ymu.service.fileclient.vo.resp.VTestResp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 功能简述:<br>
 *  测试demo
 *
 * @author zmt
 * @create 2018-03-07 下午2:47
 * @updateTime
 * @since 1.0.0
 */
@RequestMapping("/test")
public interface TestApi {

    @PostMapping
    VTestResp test(@RequestBody VTestReq vTestReq);

    @GetMapping("/test2")
    String test2(String name);
}
