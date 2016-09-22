package com.nanoutech.test.zookeeper;

import com.nanoutech.base.Config;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

/**
 * Created by YZhi on 2016/4/22.
 */
public class BaseTest {
    @Test
    public void testZk() {
        ZkClient zkClient = new ZkClient(Config.zookeeperURL);

        String path = "/test";

        zkClient.subscribeDataChanges(path, new IZkDataListener() {
            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {
                System.out.println("datachage:" + dataPath);
            }


            public void handleDataDeleted(String path) throws Exception {
                System.out.println("delete:" + path);
            }
        });


        byte[] data = null;

        //data = zkClient.readData(path);
        data = zkClient.readData(path, true);
        Stat stat = new Stat();
        data = zkClient.readData(path, stat);


        zkClient.writeData(path, data);
        zkClient.writeData(path, data, 1);

        data = zkClient.readData(path);
        data = zkClient.readData(path, true);
        data = zkClient.readData(path, stat);

        path = "/test/01/persistent";
        zkClient.createPersistent(path);
        zkClient.createPersistent(path, true);
        zkClient.createPersistent(path, data);
        zkClient.createPersistentSequential(path, data);
        zkClient.createEphemeral(path, data);
        zkClient.createEphemeralSequential(path, data);

        zkClient.create(path, data, CreateMode.EPHEMERAL);

        zkClient.delete(path);

        zkClient.deleteRecursive(path);
        zkClient.exists(path);
    }
}