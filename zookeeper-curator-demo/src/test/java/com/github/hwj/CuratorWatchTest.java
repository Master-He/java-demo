package com.github.hwj;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author hewenji
 * @Date 2023/5/26 11:38
 */
public class CuratorWatchTest {
    private CuratorFramework client;

    @Before
    public void testConnect() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(3 * 1000, 10); // 有间隔时间的重试次数
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
     * 给NodeCache指定的一个节点注册监听器
     */
    @Test
    public void testNodeCache() throws Exception {
        // 1. 创建一个nodeCache对象
        NodeCache nodeCache = new NodeCache(client, "/app1", false);

        // 2. 注册监听
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("节点变化了");
                // 获取修改节点后的数据
                byte[] data = nodeCache.getCurrentData().getData();
                System.out.println(new String(data));
            }
        });

        // 3. 开始监听, 如果buildInitial设置为true， 则开始监听时，加载节点的缓存数据
        nodeCache.start(true);

        // 测试用
        while (true) {

        }
    }

    /**
     * PathChildrenCache 监听某个节点的所有子节点们
     */
    @Test
    public void testPathChildrenCache() throws Exception {
        // 1.创建监听对象
        PathChildrenCache pathChildrenCache = new PathChildrenCache(client, "/app2", true);

        // 2.绑定监听器
        pathChildrenCache.getListenable().addListener(new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent event) throws Exception {
                System.out.println("子节点变化了~");
                System.out.println(event);

                // 监听子节点的数据变更， 并且拿到变更后的数据
                PathChildrenCacheEvent.Type type = event.getType();
                if (type.equals(PathChildrenCacheEvent.Type.CHILD_UPDATED)) {
                    System.out.println("数据变了");
                    byte[] data = event.getData().getData();// 两层data
                    System.out.println(new String(data));
                }
            }
        });

        // 3. 开启
        pathChildrenCache.start();

        // 测试用
        while (true) {

        }
    }

    /**
     * 演示 TreeNodeCache: 监听某个节点自己和所有子节点们
     * @throws Exception
     */
    @Test
    public void testTreeCache() throws Exception {
        // 1. 创建监控对象
        TreeCache treeCache = new TreeCache(client, "/app2");
        // 2. 绑定监听器
        treeCache.getListenable().addListener(new TreeCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent event) throws Exception {
                System.out.println("节点变化了");
                System.out.println(event);
            }
        });
        // 3. 开启
        treeCache.start();

        // 测试用
        while (true) {

        }
    }
}
