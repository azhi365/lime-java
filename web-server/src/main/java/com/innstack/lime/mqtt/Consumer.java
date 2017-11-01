package com.innstack.lime.mqtt;

/**
 * Created by YZhi on 2017/11/1.
 */
public class Consumer {
    public static void main(String[] args) throws Exception {
        SimpleMqtt simpleMqtt = new SimpleMqtt() {
            @Override
            public void messageArrived(String topic, String message) {
                System.out.println(topic);
                System.out.println(message);
            }
        };
        simpleMqtt.setHost("tcp://192.168.1.250:1883");
        simpleMqtt.setClientId("client");
        simpleMqtt.connect();
        simpleMqtt.subscribe("topic1", 2);
        simpleMqtt.subscribe("topic2", 1);
    }
}
