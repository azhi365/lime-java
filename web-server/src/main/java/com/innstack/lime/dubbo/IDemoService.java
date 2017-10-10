package com.innstack.lime.dubbo;
public interface IDemoService {
	
    void sayHello();
    
    String returnHello();
    
    Msg returnMsgInfo(Msg msg);
    
}