package lesson6.lesson8;

import java.util.concurrent.*;

public class ThreadVsThreadPool {
//    为什么需要线程池呢？
//    想象这么一个场景：
//    在学校附近新开了一家快递店，老板很精明，想到一个与众不同的办法来经营。店里没有雇人，而是每次有业务来
//    了，就现场找一名同学过来把快递送了，然后解雇同学。这个类比我们平时来一个任务，起一个线程进行处理的模
//    式。
//    很快老板发现问题来了，每次招聘 + 解雇同学的成本还是非常高的。老板还是很善于变通的，知道了为什么大家都要
//    雇人了，所以指定了一个指标，公司业务人员会扩张到 3 个人，但还是随着业务逐步雇人。于是再有业务来了，老板
//    就看，如果现在公司还没 3 个人，就雇一个人去送快递，否则只是把业务放到一个本本上，等着 3 个快递人员空闲
//    的时候去处理。这个就是我们要带出的线程池的模式

    public static void main(String[] args) {
        //1.没使用线程,送快递
        //我自己送快速递
        System.out.println("送快递到北京");//模拟送快递,有可能送快递是比较耗时的
        System.out.println("送快递到上海");
        System.out.println("处理自己的业务");

        //2.使用手动创建线程的方式,送快递
        //雇用了两个人,让他们送快递
        //同时,我也在干自己的事
        new Thread(() -> {
            System.out.println("送快递到北京");
        }).start();
        new Thread(() -> {
            System.out.println("送快递到上海");
        }).start();
        System.out.println("处理自己的业务");

        //3.使用JDK的线程池来送快递
        //创建线程池对象:开了一家快递公司,专门处理送快递的任务
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                4,//核心线程数:快递公司的正式员工---线程
                10,//最大线程数:总员工数(正式工 + 临时工)---线程
                //临时工 + 空闲时间: 正式员工数量不够处理任务时,招聘临时工.临时工超过空闲时间,就解雇
                60,//空闲时间数
                TimeUnit.SECONDS,//时间单位
                new ArrayBlockingQueue<>(1000),//阻塞队列:快递公司的仓库,保存快递包裹---保存线程的容器
                new ThreadFactory() {//匿名内部类
                    @Override
                    public Thread newThread(Runnable r) {//线程的工厂类:快递公司的招聘标准---创建线程的方式
                        return new Thread(r);
                    }
                },
                //拒绝策略:接收到新的快递单,但此时快递超出仓库的容量
                //下面是四种默认的拒绝方式:
//                new ThreadPoolExecutor.AbortPolicy()//抛异常的方式
//                new ThreadPoolExecutor.CallerRunsPolicy()//谁把包裹交给我的,让他自己去送
//                new ThreadPoolExecutor.DiscardOldestPolicy()//把仓库中最旧的包裹丢掉
                new ThreadPoolExecutor.DiscardPolicy()//把仓库中最新的包裹丢掉
        );
        pool.execute(() -> {//创建了一个送快递的任务,把快递包裹交给快递公司
            System.out.println("送快递到北京");
        });
        pool.execute(() -> {
            System.out.println("送快递到上海");
        });
        System.out.println("处理自己的业务");

        //单线程池：只有1个正式工，没有临时工，仓库是无边界的
        ExecutorService pool2 = Executors.newSingleThreadExecutor();
        //固定大小的线程池：只有给定数量的正式工，没有临时工，仓库是无边界的
        ExecutorService pool3 = Executors.newFixedThreadPool(4);
        //缓存的线程池：只有临时工，没有正式工，临时工数量不限，空闲时间60秒
        ExecutorService pool4 = Executors.newCachedThreadPool();
        //计划任务线程池：给定数量的正式工，没有临时工。使用自己的创建线程的方式（定时任务线程）
        ExecutorService pool5 = Executors.newScheduledThreadPool(4);
    }
}
