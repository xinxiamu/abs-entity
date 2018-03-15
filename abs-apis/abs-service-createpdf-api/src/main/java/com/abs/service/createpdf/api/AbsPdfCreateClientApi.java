package com.abs.service.createpdf.api;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 功能简述:<br>
 *     html转换为pdf接口。
 *
 * @author zmt
 * @create 2018-03-05 下午4:27
 * @updateTime
 * @since 1.0.0
 */
@RequestMapping("/")
public interface AbsPdfCreateClientApi {

    //付款确认书-给项目公司(pdf2-1.html)
    void createPaymentConfirmationPdf_1();

    //付款确认书-给碧桂园地产(pdf2-2.html)
    void createPaymentConfirmationPdf_2();

    //付款确认书-给碧桂园控股(pdf2-3.html)
    void createPaymentConfirmationPdf_3();


    
}
