package blog.jinhyun.simpleweatherandroid.core.common.dispatcher

import javax.inject.Qualifier

@Qualifier
annotation class Dispatcher(val dispatcherType: DispatcherType)