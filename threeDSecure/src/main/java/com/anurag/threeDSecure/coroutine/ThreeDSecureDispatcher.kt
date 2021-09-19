package com.anurag.threeDSecure.coroutine

import kotlinx.coroutines.*
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicInteger
import kotlin.coroutines.CoroutineContext

class ThreeDSecureDispatcher private constructor() : ExecutorCoroutineDispatcher() {

    companion object {
        private val singletonDispatcher = ThreeDSecureDispatcher()
        fun getSingletonDispatcher() = singletonDispatcher
        fun getNewDispatcher() = ThreeDSecureDispatcher()
    }

    private val threadId = AtomicInteger()
    override val executor: Executor
        get() = Executors.newFixedThreadPool(1) {
            Thread(it, "CommonPool-worker-${threadId.incrementAndGet()}").apply { isDaemon = true }
        }

    override fun close() {
        (executor as ExecutorService).apply {
            shutdown()
        }
    }

    override fun dispatch(context: CoroutineContext, block: Runnable) {
        executor.execute(block)
    }
}