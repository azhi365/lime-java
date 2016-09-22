package com.nanoutech.dubbo;

public interface IDemoService {
	
    public void sayHello();
    
    public String returnHello();
    
    public Msg returnMsgInfo(Msg info);
    
}