package com.innstack.lime.mqtt;

import com.alibaba.fastjson.JSON;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.HashMap;

/**
 * Created by YZhi on 2017/11/1.
 */
public class Producer {
    public static void main(String[] args)  {

        for (int i = 0; i < 10000; i++) {
            try {
                SimpleMqtt simpleMqtt = new SimpleMqtt() {
                };
                simpleMqtt.setHost("tcp://192.168.1.250:1883");
                simpleMqtt.setClientId("client" + i);
                simpleMqtt.connect();
                int finalI = i;
                simpleMqtt.publish("topic1", JSON.toJSONString(new HashMap(){{
                    put("key","topic1  key" + finalI);
                    put("value","topic1  value" + finalI);
                }}));
                simpleMqtt.publish("topic2", JSON.toJSONString(new HashMap(){{
                    put("key","topic2  key" + finalI);
                    put("value","topic2  value" + finalI);;
                }}));
            } catch (MqttException e) {
                e.printStackTrace();
            }
        }
    }
}
