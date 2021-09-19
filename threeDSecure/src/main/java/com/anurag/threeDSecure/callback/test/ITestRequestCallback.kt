package com.anurag.threeDSecure.callback.test

import com.anurag.threeDSecure.callback.I3DSecureRequestCallback

interface ITestRequestCallback : I3DSecureRequestCallback {
    fun onDelayComplete(time : Long)
}