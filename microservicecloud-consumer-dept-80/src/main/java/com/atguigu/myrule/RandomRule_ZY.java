package com.atguigu.myrule;

import java.util.List;
import java.util.Random;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

/*
 * 自定义随机算法负载均衡
 * 问题:依旧使用轮询策略,但是加上新需求,每个服务器要求被调用5次。也即以前是每台机器一次,现在是每台机器5次。
 */
public class RandomRule_ZY extends AbstractLoadBalancerRule {
//    Random rand; 这些用不上了
//    public RandomRule_ZY() {
//        rand = new Random();
//    }

	/**
	 * total=0 当total=5的时候,我们的currentIndex指针才能往下走
	 * index = 0,当前对外提供服务的服务器索引
	 * 注意currentIndex这个值不能大于服务列表的总数
	 */
	private int total = 0;//总共被调用的次数,目前要求每台被调用5次
	private int currentIndex = 0;//当前提供服务的机器号
    /**
     * Randomly choose from all living servers
     */
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

//            int index = rand.nextInt(serverCount);
//            server = upList.get(index);
            if (total < 5)  {
            	server = upList.get(currentIndex);
            	total++;
            } else {
            	total = 0;
            	currentIndex++;
            	if (currentIndex >= upList.size()) {
            		currentIndex = 0;
            	}
            }
            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		// TODO Auto-generated method stub
		
	}
}