package com.innstack.lime.test.zookeeper;

import com.innstack.lime.base.Config;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

public class ZKClientChanger {
 
    private static ZkClient zkClient;
 
    /***
     * 测试修改path数据
     */
    private static class ChangerThread extends Thread {
 
        @Override
        public void run() {
            if(!zkClient.exists("/root")) {
                //1、创建root节点 2、初始化节点数据 3、节点为永久性创建
                zkClient.create("/root", "root".getBytes(), CreateMode.PERSISTENT);
            }
 
            for(int i = 0; i < 50; i++) {
                zkClient.writeData("/root", "root" + String.valueOf(i));
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
 
    }
 
    public static void main(String[] args) {
 
        //对zookeeper封装的client，zookeeper发布订阅是一次的性的，监控一次后会断开连接;
        //client超时过期时货自动创建zookeeper连接
        zkClient = new ZkClient(Config.zookeeperURL, 1000);
 
        new ChangerThread().start();
    }
 
}