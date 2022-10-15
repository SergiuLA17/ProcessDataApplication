package com.cr192.processdataapplication.BussinesLayer.logger;

public interface iLoggerService {
    void info(String text);

    void error(String text);

    void warn(String text);

    void requestProcessedSuccessfully();

    void showInfoAboutRequest(Object obj);
}
