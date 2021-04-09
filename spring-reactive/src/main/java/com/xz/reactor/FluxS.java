package com.xz.reactor;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * Flux 示例
 */
public class FluxS {
    public static void main(String[] args) throws InterruptedException {
        println("运行");
        //发布数据A->B->c->D
        Flux.just("A", "B", "C")
                //如果单独开线程那么有可能不执行,因为主线程已经结束掉了
                //.publishOn(Schedulers.elastic())
                .map(value -> "+" + value)//转换
                .subscribe(FluxS::println
                        , FluxS::println,
                        () -> {
                            println("完成操作!");
                        },
                        //背压操作
                        subscription -> {
                            //请求的元素的数量
                            //subscription.request(Integer.MAX_VALUE);
                            //取消上游传输数据到下游
                            subscription.cancel();
                        });//消费
        //Thread.sleep(1000);

    }

    private static void println(Object object) {
        String threadName = Thread.currentThread().getName();
        System.out.println("[线程:" + threadName + "]" + object);
    }
}
