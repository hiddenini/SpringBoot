package com.xz.loader;

import java.util.concurrent.CompletableFuture;

/**
 * 非阻塞只是一种编程的模型,编程的模式,并不代表线程模型或者并发模型
 *
 *  CompletableFuture 属于异步操作，如果强制等待结束的话，又回到了阻塞编程的方式
 */
public class ChainDataLoader extends DataLoader {
    protected void doLoad() {
        CompletableFuture.runAsync(super::loadConfigurations)
                .thenRun(super::loadUsers)
                .thenRun(super::loadOrders)
                // 完成时回调
                .whenComplete((result, throwable) -> {
                    System.out.println("[线程 : " + Thread.currentThread().getName() + "] 加载完成");

                }).join();//等待完成
    }

    public static void main(String[] args) {
        new ChainDataLoader().load();
    }
}
