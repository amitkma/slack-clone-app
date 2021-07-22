package com.github.amitkma.slacksampleapp

import android.app.Application
import com.github.amitkma.slacksampleapp.data.UserRepository
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.ui.sample.data.user.SampleUser

class SlackSampleApp: Application() {

    val userRepository = UserRepository(this)
    val chatInitializer = ChatInitializer(this)

    override fun onCreate() {
        super.onCreate()
        chatInitializer.init(getApiKey())
        instance = this
    }

    private fun getApiKey(): String {
        val user = userRepository.getUser()
        return if (user != SampleUser.None) {
            user.apiKey
        } else {
            AppConfig.apiKey
        }
    }

    companion object {
        lateinit var instance: SlackSampleApp
            private set
    }
}