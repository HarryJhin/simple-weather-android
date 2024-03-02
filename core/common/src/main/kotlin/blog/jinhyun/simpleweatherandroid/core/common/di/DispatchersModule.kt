package blog.jinhyun.simpleweatherandroid.core.common.di

import blog.jinhyun.simpleweatherandroid.core.common.dispatcher.Dispatcher
import blog.jinhyun.simpleweatherandroid.core.common.dispatcher.DispatcherType.DEFAULT
import blog.jinhyun.simpleweatherandroid.core.common.dispatcher.DispatcherType.IO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {

    @Provides
    @Dispatcher(IO)
    fun providesIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Dispatcher(DEFAULT)
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
}