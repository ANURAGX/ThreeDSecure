package com.anurag.threeDSecure.service.jwt

import com.anurag.threeDSecure.coroutine.ThreeDSecureScope
import com.anurag.threeDSecure.request.jwt.GenerateJwtRequest
import com.anurag.threeDSecure.service.I3DSecureService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class GenerateJwtService(private val threeDSecureScope: ThreeDSecureScope) :
    I3DSecureService<GenerateJwtRequest> {

    override suspend fun executeRequest(request: GenerateJwtRequest) {
        val nonce = request.nonce

        //Todo do API call to get nonce.

        //After Api call return callback on main thread.
        threeDSecureScope.launch(Dispatchers.Main) {
            val apiCallFailed = true
            if (apiCallFailed) {
                request.callbackNotifier.onGenerateJwtFailed()
            } else {
                request.callbackNotifier.onGenerateJwtSuccess()
            }
        }

    }
}