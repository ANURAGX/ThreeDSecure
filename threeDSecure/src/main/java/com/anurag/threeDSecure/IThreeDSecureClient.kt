package com.anurag.threeDSecure

import com.anurag.threeDSecure.callback.I3DSecureRequestCallback
import com.anurag.threeDSecure.request.I3DSecureRequest

interface IThreeDSecureClient {
    fun executeRequest(threeDSecureRequest: I3DSecureRequest<out I3DSecureRequestCallback>)
}