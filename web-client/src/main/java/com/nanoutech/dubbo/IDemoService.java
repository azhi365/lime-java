package com.nanoutech.dubbo;

public interface IDemoService {

    void sayHello();

    String returnHello();

    Msg returnMsgInfo(Msg info);

}