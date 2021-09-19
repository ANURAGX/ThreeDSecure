package com.anurag.threeDSecure.serviceLocator

import com.anurag.threeDSecure.ThreeDSecureException
import com.anurag.threeDSecure.callback.I3DSecureRequestCallback
import com.anurag.threeDSecure.coroutine.ThreeDSecureScope
import com.anurag.threeDSecure.request.I3DSecureRequest
import com.anurag.threeDSecure.request.jwt.GenerateJwtRequest
import com.anurag.threeDSecure.request.test.TestServiceRequest
import com.anurag.threeDSecure.service.I3DSecureService
import com.anurag.threeDSecure.service.jwt.GenerateJwtService
import com.anurag.threeDSecure.service.test.TestService

class ThreeDSecureServiceLocator private constructor() : I3DSecureServiceLocator<I3DSecureRequest<out I3DSecureRequestCallback>> {

    companion object {
        fun getServiceLocator(): I3DSecureServiceLocator<I3DSecureRequest<out I3DSecureRequestCallback>> = ThreeDSecureServiceLocator()
    }

    override fun getService(scope: ThreeDSecureScope, request: I3DSecureRequest<out I3DSecureRequestCallback>): I3DSecureService<I3DSecureRequest<out I3DSecureRequestCallback>> {
        when (request) {
            is GenerateJwtRequest -> return GenerateJwtService(scope) as I3DSecureService<I3DSecureRequest<out I3DSecureRequestCallback>>
            is TestServiceRequest -> return TestService(scope) as I3DSecureService<I3DSecureRequest<out I3DSecureRequestCallback>>
        }
        throw ThreeDSecureException("No service found for the requested request ${request.javaClass.name}")
    }
}