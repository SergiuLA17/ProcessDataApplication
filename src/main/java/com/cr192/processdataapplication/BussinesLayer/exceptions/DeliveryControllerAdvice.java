package com.cr192.processdataapplication.BussinesLayer.exceptions;

import org.apache.poi.EmptyFileException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DeliveryControllerAdvice {
    @ExceptionHandler(EmptyFileException.class)
    public String print(EmptyFileException nullPointerException) {
        return "redirect:/upload";
    }
}
