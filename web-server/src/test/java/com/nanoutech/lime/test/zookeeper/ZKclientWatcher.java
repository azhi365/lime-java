package com.nanoutech.lime.test.zookeeper;

import com.nanoutech.lime.base.Config;
import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.IZkStateListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.Watcher;

import java.util.List;

public class ZKclientWatcher {
 
    private static ZkClient zkClient;
 
    private static int count = 0;
 
    /**
     * 测试监控path下的数据变化情况
     */
    private static class WatcherThread extends Thread {
        @Override
        public void run() {
            //监控path下的数据的变化
            zkClient.subscribeDataChanges("/root", new IZkDataListener() {
                @Override
                public void handleDataChange(String path, Object data) throws Exception {
                    System.out.println("handleDataChange===========>path:" + path + " data: " + data);
                    count++;
                }
 
                @Override
                public void handleDataDeleted(String path) throws Exception {
                    System.out.println("handleDataDeleted=========>path:" + path);
                }
            });
 
            //监控path下的节点的变化
            zkClient.subscribeChildChanges("/root", new IZkChildListener() {
                @Override
                public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
                    // TODO 节点变化处理逻辑
                }
            });
 
            //监控连接状态的变化
            zkClient.subscribeStateChanges(new IZkStateListener() {
                @Override
                public void handleStateChanged(Watcher.Event.KeeperState state) throws Exception {
                    // TODO 监控zookeeper连接状态变化逻辑
                }
 
                @Override
                public void handleNewSession() throws Exception {
                    // TODO  监控zookeeper Session过期并创建新Session时的逻辑
                }
            });
 
            //取消所有的订阅[unsubscribeChildChanges/unsubscribeDataChanges/unsubscribeStateChanges]
//            zkClient.unsubscribeAll();
        }
    }
 
    public static void main(String[] args) throws InterruptedException {
        zkClient = new ZkClient(Config.zookeeperURL, 2000);
        new WatcherThread().start();
 
        while (count < 10) {
            System.out.println("count : " + count);
            Thread.sleep(1000);
        }
    }
 
}