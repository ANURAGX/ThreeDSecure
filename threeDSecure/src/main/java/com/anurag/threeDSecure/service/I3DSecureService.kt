package com.anurag.threeDSecure.service

import com.anurag.threeDSecure.callback.I3DSecureRequestCallback
import com.anurag.threeDSecure.request.I3DSecureRequest

interface I3DSecureService<T : I3DSecureRequest<out I3DSecureRequestCallback>> {
    suspend fun executeRequest(request: T)
}