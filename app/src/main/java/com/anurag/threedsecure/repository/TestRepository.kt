package com.anurag.threedsecure.repository

import android.util.Log
import com.anurag.threeDSecure.callback.test.ITestRequestCallback

class TestRepository : ITestRequestCallback {
    override fun onDelayComplete(time: Long) {
        Log.d("TestRepository", "Delay Callback after $time")
    }
}