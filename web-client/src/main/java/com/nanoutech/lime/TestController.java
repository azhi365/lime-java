package com.nanoutech.lime;

import com.nanoutech.lime.dubbo.IDemoService;
import com.nanoutech.lime.dubbo.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping("/test")
public class TestController {

    @Resource
    private IDemoService demoService;

    @ResponseBody
    @RequestMapping(value = "/json")
    Object index(HttpServletRequest request, Model view) {
        System.out.println("LOG.............");
        return "";
    }

    @ResponseBody
    @RequestMapping(value = "/dubbo")
    Object testDubbo(HttpServletRequest request, Model view) {
        System.out.println("LOG.............");
        if (demoService != null) {
            Msg msg = new Msg();
            msg.setId(1);
            msg.setName("fsdf");
            msg.setMsgs(new ArrayList<String>());
            return demoService.returnMsgInfo(msg).getMsgs().get(0);
        }
        return "";
    }

    public IDemoService getDemoService() {
        return demoService;
    }

    public void setDemoService(IDemoService demoService) {
        this.demoService = demoService;
    }
}