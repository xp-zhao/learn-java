package com.example.liteflow;

import com.yomahub.liteflow.thread.ExecutorBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TODO
 *
 * @author xp-zhao
 * @date 2022/7/15
 */
@SuppressWarnings("AlibabaThreadPoolCreation")
public class CustomThreadBuilder implements ExecutorBuilder {
    @Override
    public ExecutorService buildExecutor() {
        return Executors.newFixedThreadPool(10);
    }
}
