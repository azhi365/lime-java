package com.innstack.point;

import org.drools.core.io.impl.ClassPathResource;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created by YZhi on 2014/7/9.
 */
public class UserService {
    public static void main(String[] args) {

        final User user = new User();
        user.setUserName("hello kity");
        user.setBackMondy(100d);
        user.setBuyMoney(500d);
        user.setBackNums(1);
        user.setBuyNums(5);
        user.setBillThisMonth(5);
        user.setBirthDay(false);
        user.setPoint(0L);


        execute(user);


        System.out.println("执行完毕BillThisMonth：" + user.getBillThisMonth());
        System.out.println("执行完毕BuyMoney：" + user.getBuyMoney());
        System.out.println("执行完毕BuyNums：" + user.getBuyNums());
        System.out.println("执行完毕规则引擎决定发送积分：" + user.getPoint());
    }

    private static void execute(User user) {

        System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm:ss");

        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kfs = kieServices.newKieFileSystem();
        kfs.write(new ClassPathResource("com/innstack/point/addpoint.drl"));
        kfs.write(new ClassPathResource("com/innstack/point/subpoint.drl"));
        KieBuilder kieBuilder = kieServices.newKieBuilder(kfs).buildAll();
        Results results = kieBuilder.getResults();
        if (results.hasMessages(Message.Level.ERROR)) {
            System.out.println(results.getMessages());
            throw new IllegalStateException("### errors ###");
        }
        KieContainer kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
        KieSession session = kieContainer.newKieSession();

        session.insert(user);

        session.fireAllRules();
        session.dispose();
    }


}
