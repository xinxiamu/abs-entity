package com.ymu.service.fileclient.controller;

import com.abs.infrastructure.base.BaseController;
import com.ymu.service.fileclient.api.FastDFSClientApi;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FastDFSClientController extends BaseController implements FastDFSClientApi {

    private static final Logger LOGGER = LogManager.getLogger(FastDFSClientController.class);


}
