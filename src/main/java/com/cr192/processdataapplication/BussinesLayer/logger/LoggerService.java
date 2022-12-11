package com.cr192.processdataapplication.BussinesLayer.logger;

import com.cr192.processdataapplication.controller.DeliveryController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggerService implements iLoggerService {
    private final Logger logger = LoggerFactory.getLogger(DeliveryController.class);

    @Override
    public void info(String text) {
        logger.info(text);
    }

    @Override
    public void error(String text) {
        logger.error(text);
    }

    @Override
    public void warn(String text) {
        logger.warn(text);
    }

    public void requestProcessedSuccessfully() {
        logger.info("Request was successfully processed\n");
    }

    public void showInfoAboutRequest(Object obj) {
        logger.info("New request. " + obj);
    }

}