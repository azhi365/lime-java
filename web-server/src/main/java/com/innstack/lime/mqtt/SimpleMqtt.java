package com.innstack.lime.mqtt;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 * Created by yhy on 17-7-10.
 */
public abstract class SimpleMqtt {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMqtt.class);

    //断开之后重连的次数
    private int reconnectTime = 10;
    private int reconnectTimeout = 10;

    private String host = null;
    private int timeout = 0;
    private String userName = null;
    private String passWord = null;

    private int keepalive = 0;
    //判断是否开启 tls
    private boolean tlsSwitch = false;

    //给服务器签发证书的 ca 的证书
    private String caCrt;

    //客户端唯一标识
    private String clientId;

    //mqtt 客户端 配置项
    private MqttConnectOptions options = new MqttConnectOptions();
    //mqtt 客户端
    private MqttClient client = null;


    /**
     * 链接到 mqtt 代理
     */
    public void connect() {
        //==================设置客户端参数=====================
        options.setCleanSession(true);
        //--------------设置认证信息------------------
        if (!StringUtils.isEmpty(userName)) {
            if (StringUtils.isEmpty(passWord)) {
                throw new RuntimeException("密码为空");
            }
            options.setUserName(userName);
            options.setPassword(passWord.toCharArray());
        }
        //-----------是否开启 tls --------------------
        if (tlsSwitch) {
            LOGGER.debug("开启了 tls 认证");
            SSLSocketFactory socketFactory = null;
            try {
                socketFactory = getSslSocketFactory();
            } catch (Exception e) {
                LOGGER.error("tls 配置有问题, {}", e.toString(), e);
            }
            options.setSocketFactory(socketFactory);
        } else {
            LOGGER.debug("没有开启 tls 认证");
        }

        //----------设置超时时间 ----------------------
        if (timeout != 0) {
            options.setConnectionTimeout(timeout);
        }
        //----------设置会话心跳时间--------------------
        if (keepalive != 0) {
            options.setKeepAliveInterval(keepalive);
        }
        try {
            if (StringUtils.isEmpty(host) || StringUtils.isEmpty(clientId)) {
                throw new RuntimeException("host 或者 clientId 为空");
            }
            client = new MqttClient(host, clientId, new MemoryPersistence());
            //----------设置回调--------------------------
            client.setCallback(new PushCallback());
            //==================链接=============================
            client.connect(options);
            LOGGER.debug("============init {} mqtt server==============", clientId);
        } catch (MqttException e) {
            LOGGER.error("init mqtt server failed: {}", e.toString(), e);
        }
    }


    /**
     * 断开 mqtt 链接
     */
    public void destory() {
        try {
            if (client != null) {
                client.disconnect();
                client.close();
            }
        } catch (MqttException e) {
            LOGGER.error("主动关闭链接出错:{}", e.toString(), e);
        }
        LOGGER.debug("============uninit {} mqtt server============", clientId);
    }

    /**
     * 实现类必须要实现的消息到来的回调
     *
     * @param topic   主题
     * @param message 消息
     */
    public void messageArrived(String topic, String message) {

    }

    /**
     * 断开之后重连
     */
    public void connectionLost() {
        // 连接丢失后，一般在这里面进行重连
        boolean ok = false;

        for (int i = 0; i < reconnectTime; ++i) {
            try {
                client.connect(options);
                ok = true;
                break;
            } catch (MqttException e) {
                LOGGER.error("{} 断开链接,重连失败:{}", clientId, e.toString(), e);
            }
            try {
                Thread.sleep(reconnectTimeout * 1000);
            } catch (InterruptedException e) {
                LOGGER.error(e.toString(), e);
            }
        }

        if (ok) {
            LOGGER.error("{} 断开链接,重连成功恢复", clientId);
        } else {
            LOGGER.error("{} 断开链接,重连多次失败,退出进程", clientId);
            System.exit(-1);
        }
    }

    /**
     * 下发成功的回调,默认不做任何处理
     *
     * @param topic   主题
     * @param message 消息
     */
    public void deliveryComplete(String[] topic, String message) {

    }

    /**
     * 订阅
     *
     * @param topicFilter 订阅的主题过滤
     * @param qos         级别
     * @throws MqttException 失败
     */
    public void subscribe(String topicFilter, int qos) throws MqttException {
        if (null == client) {
            throw new RuntimeException("没有链接,请先 connect");
        }
        client.subscribe(topicFilter, qos);
    }

    public void subscribe(String[] topicFilters, int[] qos) throws MqttException {
        if (null == client) {
            throw new RuntimeException("没有链接,请先 connect");
        }
        client.subscribe(topicFilters, qos);
    }

    public void publish(String topic, String message) throws MqttException {
        if (null == client) {
            throw new RuntimeException("没有链接,请先 connect");
        }
        client.publish(topic, message.getBytes(), 0, false);
    }

    public void publish(String topic, byte[] payload, int qos, boolean retained) throws MqttException {
        if (null == client) {
            throw new RuntimeException("没有链接,请先 connect");
        }
        client.publish(topic, payload, qos, retained);
    }


    /**
     * 获取 tls socket
     *
     * @return tls socket
     * @throws IOException 打开文件失败
     */
    protected SSLSocketFactory getSslSocketFactory() throws CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        String caCrtFile = null;
        if (!StringUtils.isEmpty(caCrt)) {
            caCrtFile = caCrt;
        }
        return SSLUtil.getSocketFactory(caCrtFile);
    }

    public int getReconnectTime() {
        return reconnectTime;
    }

    public void setReconnectTime(int reconnectTime) {
        this.reconnectTime = reconnectTime;
    }

    public int getReconnectTimeout() {
        return reconnectTimeout;
    }

    public void setReconnectTimeout(int reconnectTimeout) {
        this.reconnectTimeout = reconnectTimeout;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getKeepalive() {
        return keepalive;
    }

    public void setKeepalive(int keepalive) {
        this.keepalive = keepalive;
    }

    public boolean isTlsSwitch() {
        return tlsSwitch;
    }

    public void setTlsSwitch(boolean tlsSwitch) {
        this.tlsSwitch = tlsSwitch;
    }

    public String getCaCrt() {
        return caCrt;
    }

    public void setCaCrt(String caCrt) {
        this.caCrt = caCrt;
    }


    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    ///////////////////////////////////////////回调///////////////////////////////////////////

    /**
     * 处理 mqtt 消息的回调
     */
    class PushCallback implements MqttCallback {

        //链接断开的回调
        public void connectionLost(Throwable cause) {
            LOGGER.error("{} 连接断开,进行重连, tid:{}, 异常原因:{}", clientId, Thread.currentThread().getId(), cause.getMessage());
            SimpleMqtt.this.connectionLost();
        }

        /**
         * 监听的主题获取到数据
         *
         * @param topic       主题
         * @param mqttMessage 消息
         * @throws Exception 异常
         */
        @Override
        public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
            // subscribe后得到的消息会执行到这里面
            String msg = new String(mqttMessage.getPayload());
            LOGGER.trace("接收到数据,主题:{},消息:{}", topic, msg);
            SimpleMqtt.this.messageArrived(topic, msg);
        }

        @Override
        // 当下发成功被调用。
        public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
            try {
                if (null != iMqttDeliveryToken.getTopics()) {
                    LOGGER.trace("下发数据到,主题:{},消息:{}", iMqttDeliveryToken.getTopics(), iMqttDeliveryToken.getMessage().toString());
                    SimpleMqtt.this.deliveryComplete(iMqttDeliveryToken.getTopics(), iMqttDeliveryToken.getMessage().toString());
                } else {
                    LOGGER.error("下发数据,出现错误.主题为空:iMqttDeliveryToken.getTopics()==null");
                }
            } catch (MqttException e) {
                LOGGER.error("下发数据到,主题:{},出现错误:{}", iMqttDeliveryToken.getTopics(), e.toString(), e);
            }
        }
    }


}





