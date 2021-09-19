package com.anurag.threeDSecure.serviceLocator

import com.anurag.threeDSecure.callback.I3DSecureRequestCallback
import com.anurag.threeDSecure.coroutine.ThreeDSecureScope
import com.anurag.threeDSecure.request.I3DSecureRequest
import com.anurag.threeDSecure.service.I3DSecureService

interface I3DSecureServiceLocator<T : I3DSecureRequest<out I3DSecureRequestCallback>> {
    fun getService(scope: ThreeDSecureScope, request: T): I3DSecureService<T>
}