package com.ali.cq.testCompletable.service.imp;

import com.ali.cq.testCompletable.service.ICompletableService;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
public class CompletableServiceImpl implements ICompletableService {

    @Override
    public void testCompletableMethod() throws Exception {
        //1
        //这是测试测试
        System.out.println(123123213);
        CompletableFuture.runAsync(() -> {
        });
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "-女神：我开始化妆了，好了我叫你。");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "好了";
        }).whenComplete((returnStr, exception) -> {
            if (exception == null) {
                System.out.println(Thread.currentThread().getName() + " " + returnStr);
            } else {
                System.out.println(Thread.currentThread().getName() + " 女神放你鸽子了。");
                exception.printStackTrace();
            }
        }).exceptionally((e)->{
            e.printStackTrace();
            return null;
        });

        System.out.println(Thread.currentThread().getName() + "-等女神化妆的时候可以干点自己的事情。");
        stringCompletableFuture.get();
    }

}
