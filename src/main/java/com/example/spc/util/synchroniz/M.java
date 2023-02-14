package com.example.spc.util.synchroniz;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class M {

    public static void pp(){
        System.out.println("pppp");
    }

    public static void main(String[] args) throws InterruptedException {

//        //ReentrantLock线程锁
//        ReentrantLock1 counter = new ReentrantLock1();
//        Runnable runnable = () -> {
//            for (int i = 0; i < 10000; i++) {
//                counter.increment();
//            }
//        };
//        Thread t1 = new Thread(runnable);
//        Thread t2 = new Thread(runnable);
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//        System.out.println(counter.getCount()); // 20000



//        //ThreadPoolExecutor创建线程池
//        ExecutorService executor = Executors.newFixedThreadPool(10);
//        for (int i = 0; i < 100; i++) {
//            executor.execute(new Runnable() {
//                @Override
//                public void run() {
//                    pp();
//                    System.out.println("Before Java8, too much code for too little to do");
//                }
//            });
//        }
//        executor.shutdown();




//       // 线程通信
//        Message message = new Message();
//        Runnable producer = () -> {
//            for (int i = 0; i < 10; i++) {
//                message.write("Hello, World!");
//            }
//        };
//        Runnable consumer = () -> {
//            for (int i = 0; i < 10; i++) {
//                System.out.println(message.read());
//            }
//        };
//        Thread t1 = new Thread(producer);
//        Thread t2 = new Thread(consumer);
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();

        //CountDownLatch实现线程等待
        CountDownLatch latch = new CountDownLatch(2);
        Runnable runnable = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName() + " finished.");
            latch.countDown();
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        latch.await(); // 等待两个线程完成
        System.out.println("All threads finished.");

    }
}
