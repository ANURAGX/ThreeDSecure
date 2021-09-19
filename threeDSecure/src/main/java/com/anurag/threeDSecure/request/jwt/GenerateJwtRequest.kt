package com.anurag.threeDSecure.request.jwt

import com.anurag.threeDSecure.callback.jwt.IGenerateJwtRequestCallback
import com.anurag.threeDSecure.request.I3DSecureRequest

class GenerateJwtRequest(
    val nonce: String,
    override val callbackNotifier: IGenerateJwtRequestCallback
) :
    I3DSecureRequest<IGenerateJwtRequestCallback> {
}