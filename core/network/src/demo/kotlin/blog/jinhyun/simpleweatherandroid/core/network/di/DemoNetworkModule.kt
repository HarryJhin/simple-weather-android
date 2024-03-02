package blog.jinhyun.simpleweatherandroid.core.network.di

import blog.jinhyun.simpleweatherandroid.core.network.client.ApiClient
import blog.jinhyun.simpleweatherandroid.core.network.client.DemoApiClient
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DemoNetworkModule {

    @Binds
    fun bindsApiClient(impl: DemoApiClient): ApiClient
}