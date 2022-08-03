package com.wangsong.nacos;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.listener.EventListener;
import com.alibaba.nacos.api.naming.pojo.Instance;

import java.util.List;

public interface NacosService {


    /**
     * 用于服务启动的时候从 Nacos 获取配置。
     */
    public String getConfig(String dataId, String group, long timeoutMs) throws NacosException;


//    请求参数
//    参数名	参数类型	描述
//    dataId	string	配置 ID，采用类似 package.class（如com.taobao.tc.refund.log.level）的命名规则保证全局唯一性，class 部分建议是配置的业务含义。全部字符小写。只允许英文字符和 4 种特殊字符（"."、":"、"-"、"_"），不超过 256 字节。
//    group	string	配置分组，建议填写产品名:模块名（Nacos:Test）保证唯一性，只允许英文字符和4种特殊字符（"."、":"、"-"、"_"），不超过128字节。
//    timeout	long	读取配置超时时间，单位 ms，推荐值 3000。
//    返回值
//    参数类型	描述
//    string	配置值
//    请求示例
//try {
//        String serverAddr = "{serverAddr}";
//        String dataId = "{dataId}";
//        String group = "{group}";
//        Properties properties = new Properties();
//        properties.put("serverAddr", serverAddr);
//        ConfigService configService = NacosFactory.createConfigService(properties);
//        String content = configService.getConfig(dataId, group, 5000);
//        System.out.println(content);
//    } catch (NacosException e) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//    }






    /**
     *    监听配置
     *    如果希望 Nacos 推送配置变更，可以使用 Nacos 动态监听配置接口来实现。
     */
    public void addListener(String dataId, String group) throws NacosException;
//    请求参数
//            参数名
//    参数类型
//            描述
//    dataId
//            string
//    配置 ID，采用类似 package.class（如com.taobao.tc.refund.log.level）的命名规则保证全局唯一性，class 部分建议是配置的业务含义。 全部字符小写。只允许英文字符和 4 种特殊字符（"."、":"、"-"、"_"）。不超过 256 字节。
//    group
//            string
//    配置分组，建议填写产品名：模块名（如 Nacos:Test）保证唯一性。 只允许英文字符和4种特殊字符（"."、":"、"-"、"_"），不超过128字节。
//    listener
//            Listener
//    监听器，配置变更进入监听器的回调函数。
//    返回值
//    参数类型	描述
//    string	配置值，初始化或者配置变更的时候通过回调函数返回该值。
//    请求示例
//    String serverAddr = "{serverAddr}";
//    String dataId = "{dataId}";
//    String group = "{group}";
//    Properties properties = new Properties();
//properties.put("serverAddr", serverAddr);
//    ConfigService configService = NacosFactory.createConfigService(properties);
//    String content = configService.getConfig(dataId, group, 5000);
//System.out.println(content);
//configService.addListener(dataId, group, new Listener() {
//        @Override
//        public void receiveConfigInfo(String configInfo) {
//            System.out.println("recieve1:" + configInfo);
//        }
//        @Override
//        public Executor getExecutor() {
//            return null;
//        }
//    });

// 测试让主线程不退出，因为订阅配置是守护线程，主线程退出守护线程就会退出。 正式代码中无需下面代码
//while (true) {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }







    /**
     *删除监听
     *取消监听配置，取消监听后配置不会再推送。
     */
    public void removeListener(String dataId, String group) throws NacosException ;
//    请求参数
//    参数名	参数类型	描述
//    dataId	string	配置 ID，采用类似 package.class（如com.taobao.tc.refund.log.level）的命名规则保证全局唯一性，class 部分建议是配置的业务含义。全部字符小写。只允许英文字符和 4 种特殊字符（"."、":"、"-"、"_"），不超过 256 字节。
//    group	string	配置分组
//    listener	ConfigChangeListenerAdapter	监听器，配置变更进入监听器的回调函数。
//    使用示例
//    String serverAddr = "{serverAddr}";
//    String dataId = "{dataId}";
//    String group = "{group}";
//    Properties properties = new Properties();
//properties.put("serverAddr", serverAddr);
//    ConfigService configService = NacosFactory.createConfigService(properties);
//configService.removeListener(dataId, group, yourListener);




    /**
     * 发布配置
     * 用于通过程序自动发布 Nacos 配置，以便通过自动化手段降低运维成本。
     * 注意：创建和修改配置时使用的同一个发布接口，当配置不存在时会创建配置，当配置已存在时会更新配置。
     */
    public boolean publishConfig(String dataId, String group, String content) throws NacosException;

    /**
     * 发布配置
     * 用于通过程序自动发布 Nacos 配置，以便通过自动化手段降低运维成本。
     * 注意：创建和修改配置时使用的同一个发布接口，当配置不存在时会创建配置，当配置已存在时会更新配置。
     * @Since 1.4.1
     */
    public boolean publishConfig(String dataId, String group, String content, String type) throws NacosException;

//    请求参数
//    参数名	参数类型	描述
//    dataId	string	配置 ID，采用类似 package.class（如 com.taobao.tc.refund.log.level）的命名规则保证全局唯一性。建议根据配置的业务含义来定义 class 部分。全部字符均为小写。只允许英文字符和 4 种特殊字符（“.”、“:”、“-”、“_”），不超过 256 字节。
//    group	string	配置分组，建议填写产品名:模块名（如 Nacos:Test）来保证唯一性。只允许英文字符和 4 种特殊字符（“.”、“:”、“-”、“_”），不超过 128 字节。
//    content	string	配置内容，不超过 100
//    K 字节。
//    type	string	@Since 1.4.1. 配置类型，见 com.alibaba.nacos.api.config.ConfigType，默认为TEXT
//            返回参数
//    参数类型	描述
//    boolean	是否发布成功
//    请求示例
//try {
//        // 初始化配置服务，控制台通过示例代码自动获取下面参数
//        String serverAddr = "{serverAddr}";
//        String dataId = "{dataId}";
//        String group = "{group}";
//        Properties properties = new Properties();
//        properties.put("serverAddr", serverAddr);
//        ConfigService configService = NacosFactory.createConfigService(properties);
//        boolean isPublishOk = configService.publishConfig(dataId, group, "content");
//        System.out.println(isPublishOk);
//    } catch (NacosException e) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//    }
//    异常说明
//    读取配置超时或网络异常，抛出 NacosException 异常。




    /**
     *    删除配置
     *     用于通过程序自动删除 Nacos 配置，以便通过自动化手段降低运维成本。
     *     注意： 当配置已存在时会删除该配置，当配置不存在时会直接返回成功消息。
     */
    public boolean removeConfig(String dataId, String group) throws NacosException;

//    请求参数
//    参数名	参数类型	描述
//    dataId	string	配置 ID
//    group	string	配置分组
//            返回参数
//    参数类型	描述
//    boolean	是否删除成功
//    请求示例
//try {
//        // 初始化配置服务，控制台通过示例代码自动获取下面参数
//        String serverAddr = "{serverAddr}";
//        String dataId = "{dataId}";
//        String group = "{group}";
//        Properties properties = new Properties();
//        properties.put("serverAddr", serverAddr);
//
//        ConfigService configService = NacosFactory.createConfigService(properties);
//        boolean isRemoveOk = configService.removeConfig(dataId, group);
//        System.out.println(isRemoveOk);
//    } catch (NacosException e) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//    }
//    异常说明
//    读取配置超时或网络异常，抛出 NacosException 异常。


    /**
     *
     *    服务发现SDK
     *     注册实例
     *     描述注册一个实例到服务。
     */
    void registerInstance(String serviceName, String ip, int port) throws NacosException;

    /**
     *    服务发现SDK
     *     注册实例
     *     描述注册一个实例到服务。
     */
    void registerInstance(String serviceName, String ip, int port, String clusterName) throws NacosException;

    /**
     *    服务发现SDK
     *     注册实例
     *     描述注册一个实例到服务。
     */
    void registerInstance(String serviceName, Instance instance) throws NacosException;

//    请求参数
//    名称	类型	描述
//    serviceName	字符串	服务名
//    ip	字符串	服务实例IP
//    port	int	服务实例port
//    clusterName	字符串	集群名
//    instance	参见代码注释	实例属性
//            返回参数
//    无
//
//            请求示例
//    NamingService naming = NamingFactory.createNamingService(System.getProperty("serveAddr"));
//naming.registerInstance("nacos.test.3", "11.11.11.11", 8888, "TEST1");
//
//    Instance instance = new Instance();
//instance.setIp("55.55.55.55");
//instance.setPort(9999);
//instance.setHealthy(false);
//instance.setWeight(2.0);
//    Map<String, String> instanceMeta = new HashMap<>();
//instanceMeta.put("site", "et2");
//instance.setMetadata(instanceMeta);
//
//    Service service = new Service("nacos.test.4");
//service.setApp("nacos-naming");
//service.sethealthCheckMode("server");
//service.setEnableHealthCheck(true);
//service.setProtectThreshold(0.8F);
//service.setGroup("CNCF");
//    Map<String, String> serviceMeta = new HashMap<>();
//serviceMeta.put("symmetricCall", "true");
//service.setMetadata(serviceMeta);
//instance.setService(service);
//
//    Cluster cluster = new Cluster();
//cluster.setName("TEST5");
//    AbstractHealthChecker.Http healthChecker = new AbstractHealthChecker.Http();
//healthChecker.setExpectedResponseCode(400);
//healthChecker.setCurlHost("USer-Agent|Nacos");
//healthChecker.setCurlPath("/xxx.html");
//cluster.setHealthChecker(healthChecker);
//    Map<String, String> clusterMeta = new HashMap<>();
//clusterMeta.put("xxx", "yyyy");
//cluster.setMetadata(clusterMeta);
//
//instance.setCluster(cluster);
//
//naming.registerInstance("nacos.test.4", instance);


    /**
     *  注销实例
     *     删除服务下的一个实例。
     */
    void deregisterInstance(String serviceName, String ip, int port) throws NacosException;
    /**
     *  注销实例
     *     删除服务下的一个实例。
     */
    void deregisterInstance(String serviceName, String ip, int port, String clusterName) throws NacosException;
//    请求参数
//    名称	类型	描述
//    serviceName	字符串	服务名
//    ip	字符串	服务实例IP
//    port	int	服务实例port
//    clusterName	字符串	集群名
//            返回参数
//    无
//
//            请求示例
//    NamingService naming = NamingFactory.createNamingService(System.getProperty("serveAddr"));
//naming.deregisterInstance("nacos.test.3", "11.11.11.11", 8888, "DEFAULT");

    /**
     *     获取全部实例
     *     获取服务下的所有实例。
     */
    List<Instance> getAllInstances(String serviceName) throws NacosException;

    /**
     *     获取全部实例
     *     获取服务下的所有实例。
     */
    List<Instance> getAllInstances(String serviceName, List<String> clusters) throws NacosException;

//    请求参数
//    名称	类型	描述
//    serviceName	字符串	服务名
//    clusters	List	集群列表
//            返回参数
//    List 实例列表。
//
//    请求示例
//    NamingService naming = NamingFactory.createNamingService(System.getProperty("serveAddr"));
//System.out.println(naming.getAllInstances("nacos.test.3"));

    /**
     *     获取健康或不健康实例列表
     *     根据条件获取过滤后的实例列表。
     */
    List<Instance> selectInstances(String serviceName, boolean healthy) throws NacosException;

    /**
     *     获取健康或不健康实例列表
     *     根据条件获取过滤后的实例列表。
     */
    List<Instance> selectInstances(String serviceName, List<String> clusters, boolean healthy) throws NacosException;
//    请求参数
//    名称	类型	描述
//    serviceName	字符串	服务名
//    clusters	List	集群列表
//    healthy	boolean	是否健康
//    返回参数
//    List 实例列表。
//
//    请求示例
//    NamingService naming = NamingFactory.createNamingService(System.getProperty("serveAddr"));
//System.out.println(naming.selectInstances("nacos.test.3", true));
//
//    Description=nacos
//            After=network.target
//            [Service]
//    Type=simple
//            User=root
//    ExecStart=/bin/bash /root/nacos/nacos/bin/startup.sh -m standalone
//    Restart=on-failure
//            PrivateTmp=true
//            [Install]
//    WantedBy=multi-user.target
    /**
     *     获取一个健康实例
     *     根据负载均衡算法随机获取一个健康实例。
     */
    Instance selectOneHealthyInstance(String serviceName) throws NacosException;

    /**
     *     获取一个健康实例
     *     根据负载均衡算法随机获取一个健康实例。
     */
    Instance selectOneHealthyInstance(String serviceName, List<String> clusters) throws NacosException;

//
//    请求参数
//    名称	类型	描述
//    serviceName	字符串	服务名
//    clusters	List	集群列表
//            返回参数
//    Instance 实例。
//
//    请求示例
//    NamingService naming = NamingFactory.createNamingService(System.getProperty("serveAddr"));
//System.out.println(naming.selectOneHealthyInstance("nacos.test.3"));

    /**
     *     监听服务
     *     监听服务下的实例列表变化。
     */
    void subscribe(String serviceName, EventListener listener) throws NacosException;

    /**
     *     监听服务
     *     监听服务下的实例列表变化。
     */
    void subscribe(String serviceName, java.util.List<String> clusters, EventListener listener) throws NacosException;

//
//    请求参数
//    名称	类型	描述
//    serviceName	字符串	服务名
//    clusters	List	集群列表
//    listener	EventListener	回调listener
//            返回参数
//    无
//
//            请求示例
//    NamingService naming = NamingFactory.createNamingService(System.getProperty("serveAddr"));
//naming.subscribe("nacos.test.3", event -> {
//        if (event instanceof NamingEvent) {
//            System.out.println(((NamingEvent) event).getServceName());
//            System.out.println(((NamingEvent) event).getInstances());
//        }
//    });




    /**
     *取消监听服务
     *取消监听服务下的实例列表变化。
     */
    void unsubscribe(String serviceName, EventListener listener) throws NacosException;

    /**
     *取消监听服务
     *取消监听服务下的实例列表变化。
     */
    void unsubscribe(String serviceName, List<String> clusters, EventListener listener) throws NacosException;

//
//    请求参数
//    名称	类型	描述
//    serviceName	字符串	服务名
//    clusters	List	集群列表
//    listener	EventListener	回调listener
//            返回参数
//    无
//
//            请求示例
//
//    NamingService naming = NamingFactory.createNamingService(System.getProperty("serveAddr"));
//naming.unsubscribe("nacos.test.3", event -> {});
}
