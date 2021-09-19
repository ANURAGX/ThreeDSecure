package com.anurag.threeDSecure

import android.os.Looper
import com.anurag.threeDSecure.callback.I3DSecureRequestCallback
import com.anurag.threeDSecure.coroutine.ThreeDSecureDispatcher
import com.anurag.threeDSecure.coroutine.ThreeDSecureScope
import com.anurag.threeDSecure.request.I3DSecureRequest
import com.anurag.threeDSecure.serviceLocator.ThreeDSecureServiceLocator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.io.Closeable

class ThreeDSecureClient private constructor() : IThreeDSecureClient, Closeable {

    companion object {
        fun getClient(): IThreeDSecureClient = ThreeDSecureClient()
    }

    //Scope
    private val scope = ThreeDSecureScope(SupervisorJob() + Dispatchers.Main.immediate)
    private val dispatcher = ThreeDSecureDispatcher.getNewDispatcher()

    /**
     * Service locator
     */
    private val serviceLocator = ThreeDSecureServiceLocator.getServiceLocator()


    override fun executeRequest(threeDSecureRequest: I3DSecureRequest<out I3DSecureRequestCallback>) {
        assert(Looper.getMainLooper().isCurrentThread) {
            "Can't execute request on other tha main thread."
        }
        scope.launch(dispatcher) {
            val service = serviceLocator.getService(scope, threeDSecureRequest)
            service.executeRequest(threeDSecureRequest)
        }
    }

    override fun close() {
        scope.coroutineContext.cancel()
    }
}