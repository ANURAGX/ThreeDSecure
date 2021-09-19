package com.anurag.threeDSecure.request

import com.anurag.threeDSecure.callback.I3DSecureRequestCallback

interface I3DSecureRequest<T : I3DSecureRequestCallback> {
    val callbackNotifier: T
}