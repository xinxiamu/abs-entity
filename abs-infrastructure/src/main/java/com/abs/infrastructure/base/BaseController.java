package com.abs.infrastructure.base;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.MappedSuperclass;

public abstract class BaseController {

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
    }

    @ModelAttribute
    public void setReqAndRes() {
    }

}
