package com.ymu.service.fileclient.controller;

import com.abs.infrastructure.base.BaseController;
import com.abs.infrastructure.spring.mvc.sensitive.SensitiveFormat;
import com.ymu.service.fileclient.api.TestApi;
import com.ymu.service.fileclient.vo.req.VTestReq;
import com.ymu.service.fileclient.vo.resp.VTestResp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能简述:<br>
 *
 * @author zmt
 * @create 2018-03-07 下午2:49
 * @updateTime
 * @since 1.0.0
 */
@RestController
public class TestController extends BaseController implements TestApi {

    private static final Logger logger = LogManager.getLogger(TestController.class);

    @Override
    public VTestResp test(@RequestBody VTestReq vTestReq) {
        VTestResp testResp = new VTestResp();
        testResp.setName("张木天");
        testResp.add(new Link("baidu.com").withRel("baidu"));
        return testResp;
    }

    @Override
    public String test2(@SensitiveFormat String name) {
        return name;
    }
}
