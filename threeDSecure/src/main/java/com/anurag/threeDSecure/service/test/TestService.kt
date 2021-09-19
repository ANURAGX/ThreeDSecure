package com.anurag.threeDSecure.service.test

import com.anurag.threeDSecure.coroutine.ThreeDSecureScope
import com.anurag.threeDSecure.request.test.TestServiceRequest
import com.anurag.threeDSecure.service.I3DSecureService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TestService(private val scope: ThreeDSecureScope) : I3DSecureService<TestServiceRequest> {

    override suspend fun executeRequest(request: TestServiceRequest) {
        runBlocking {
            delay(request.delay)
        }
        scope.launch(Dispatchers.Main) {
            request.callbackNotifier.onDelayComplete(request.delay)
        }
    }
}