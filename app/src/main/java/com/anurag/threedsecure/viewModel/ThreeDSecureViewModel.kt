package com.anurag.threedsecure.viewModel

import androidx.lifecycle.ViewModel
import com.anurag.threeDSecure.ThreeDSecureClient
import com.anurag.threeDSecure.request.jwt.GenerateJwtRequest
import com.anurag.threeDSecure.request.test.TestServiceRequest
import com.anurag.threedsecure.repository.GenerateJwtRepository
import com.anurag.threedsecure.repository.TestRepository

class ThreeDSecureViewModel : ViewModel() {

    //3d secure code.
    private val threeDSecureClient = ThreeDSecureClient.getClient()
    private val repo = GenerateJwtRepository()

    fun launch() {
        val generateJwtRequest = GenerateJwtRequest("", repo)
        threeDSecureClient.executeRequest(generateJwtRequest)
    }

    private val testRepository = TestRepository()
    fun test() {
        for (i in 0..10) {
            val testRequest = TestServiceRequest((i * 1000).toLong(), testRepository)
            threeDSecureClient.executeRequest(testRequest)
        }
    }
}