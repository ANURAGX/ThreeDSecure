package com.anurag.threedsecure.repository

import android.util.Log
import com.anurag.threeDSecure.callback.jwt.IGenerateJwtRequestCallback

class GenerateJwtRepository : IGenerateJwtRequestCallback {
    override fun onGenerateJwtSuccess() {
        Log.d("GenerateJwtRepository", "Success")
    }

    override fun onGenerateJwtFailed() {
        Log.d("GenerateJwtRepository", "Failed")
    }
}