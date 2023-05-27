package com.github.hwj;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author hewenji
 * @Date 2023/5/26 9:48
 */
public class CuratorTest {

    private CuratorFramework client;

    // @Before
    @Test
    public void testConnect() throws Exception {
        // 创建。 第一种方式
        /**
         * Create a new client
         *
         * @param connectString       list of servers to connect to // 连接字符串， zk server的地址和端口， 多个用逗号隔开
         * @param sessionTimeoutMs    session timeout  // 会话超时时间。 单位ms
         * @param connectionTimeoutMs connection timeout  // 连接超时时间， 单位ms
         * @param retryPolicy         retry policy to use  // 尝试策略， 看源码
         * @return client
         */
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(3 * 1000, 10); // 有间隔时间的重试次数
        CuratorFramework client1 = CuratorFrameworkFactory.newClient("192.168.0.111:2181", retryPolicy);
        client1.start();
        // List<String> children = client1.getChildren().forPath("/");
        // System.out.println(children);


        // 创建。 第二种方式
        client = CuratorFrameworkFactory.builder()
            .connectString("192.168.0.111:2181")
            .sessionTimeoutMs(60 * 1000)
            .connectionTimeoutMs(15 * 1000)
            .retryPolicy(retryPolicy)
            .namespace("hwj") // 名称空间， 这个是根目录， 默认加/hwj前缀
            .build();
        client.start();
    }

    @After
    public void tearClose() throws Exception {
        if (client != null) {
            client.close();
        }
    }

    /**
     * 创建节点，四种， 持久， 临时， 顺序， 不顺序
     * 1. 基本创建
     * 2. 创建节点， 带有数据
     * 3. 设置节点的类型
     * 4. 创建多级节点
     */
    @Test
    public void testCreate() throws Exception {

        // 1. 基本创建
        // 如果创建节点，没有指定数据，则默认将当前客户端的ip作为数据存储
        // String path = client.create().forPath("/app1");
        // System.out.println(path);

        // 2. 创建节点， 带有数据
        // String path = client.create().forPath("/app2", "haaha".getBytes());
        // System.out.println(path);


        // 3. 设置节点类型
        // 默认类型：持久化
        // String path = client.create().withMode(CreateMode.EPHEMERAL).forPath("/app3");  // 设置临时的，客户端会话结束就没了
        // System.out.println(path);

        // 4. 创建多级节点
        String path = client.create().creatingParentsIfNeeded().forPath("/app4/a1");
        System.out.println(path);
    }


    /**
     * 查询节点
     * 1. 查询数据 get
     * 2. 查询子节点 ls
     * 3. 查询子节点的状态信息 ls -s
     */
    @Test
    public void testQuery() throws Exception {
        // 1. 查询数据 get
        byte[] bytes = client.getData().forPath("/app1");
        System.out.println(new String(bytes));

        // 2. 查询子节点 ls
        List<String> list = client.getChildren().forPath("/app4");
        System.out.println(list);

        // 3. 查询子节点的状态信息 ls -s
        // 创建新的空的Stat对象
        Stat stat = new Stat();
        client.getData().storingStatIn(stat).forPath("/app1");
        System.out.println(stat);
    }

    /**
     * 修改数据
     * 1. 修改数据
     * 2. 根据版本去修改
     * @throws Exception
     */
    @Test
    public void testSet() throws Exception {
        // 1. 修改数据
        client.setData().forPath("/app1", "123".getBytes());

        // 2. 根据版本去修改
        Stat stat = new Stat();
        client.getData().storingStatIn(stat).forPath("/app1");
        int version = stat.getVersion();
        client.setData().withVersion(version).forPath("/app1", "it".getBytes()); // 如果版本不匹配会抛异常
    }


    /**
     * 删除节点
     * 1. 删除单个节点
     * 2. 删除带了子节点的节点
     * 3. 必须成功的删除 (保证删除) 主要防止网络问题
     * 4. 回调
     */
    @Test
    public void testDelete() throws Exception {
        // 1. 删除单个节点
        // client.delete().forPath("/app1");

        // 2. 删除带了子节点的节点
        // client.delete().deletingChildrenIfNeeded().forPath("/app4");

        // 3. 必须成功的删除 (保证删除) 主要防止网络问题, 本质就是重试
        // client.delete().guaranteed().forPath("/app2");

        // 4. 回调
        client.delete().guaranteed().inBackground(new BackgroundCallback() {
            @Override
            public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
                System.out.println("我被删除了~");
                System.out.println(event);
            }
        }).forPath("/app1");
    }

    @Test
    public void testWatch() {
        
    }
}
