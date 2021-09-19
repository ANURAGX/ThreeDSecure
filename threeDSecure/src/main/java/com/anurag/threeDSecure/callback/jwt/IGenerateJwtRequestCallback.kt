package com.anurag.threeDSecure.callback.jwt

import com.anurag.threeDSecure.callback.I3DSecureRequestCallback

interface IGenerateJwtRequestCallback : I3DSecureRequestCallback {
    fun onGenerateJwtSuccess()
    fun onGenerateJwtFailed()
}