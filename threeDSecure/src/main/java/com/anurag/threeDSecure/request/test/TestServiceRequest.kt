package com.anurag.threeDSecure.request.test

import com.anurag.threeDSecure.callback.test.ITestRequestCallback
import com.anurag.threeDSecure.request.I3DSecureRequest

class TestServiceRequest(
    val delay: Long,
    override val callbackNotifier: ITestRequestCallback
) : I3DSecureRequest<ITestRequestCallback> {
}