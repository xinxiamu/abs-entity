package com.ymu.service.fileclient.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FastDFSClientServiceTest {

    @Autowired
    private IFastDFSClientService fastDFSClientService;

    @Test
    public void uploadFileTest() {
        File file = new File("/home/mutian/Pictures/aa.png");
        String a = fastDFSClientService.uploadFile(file,"aa");
        System.out.println("===a:" + a);
    }
}

