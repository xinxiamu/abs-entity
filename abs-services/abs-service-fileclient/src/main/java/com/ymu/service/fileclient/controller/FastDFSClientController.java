package com.ymu.service.fileclient.controller;

import com.abs.infrastructure.base.BaseController;
import com.abs.infrastructure.spring.mvc.sensitive.SensitiveFormat;
import com.ymu.service.fileclient.api.FastDFSClientApi;
import com.ymu.service.fileclient.vo.req.VTestReq;
import com.ymu.service.fileclient.vo.resp.VTestResp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.hateoas.Link;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FastDFSClientController extends BaseController implements FastDFSClientApi {

}
