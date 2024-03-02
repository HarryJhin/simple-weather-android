/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package blog.jinhyun.simpleweatherandroid.core.testing.di

import blog.jinhyun.simpleweatherandroid.core.common.di.DispatchersModule
import blog.jinhyun.simpleweatherandroid.core.common.dispatcher.Dispatcher
import blog.jinhyun.simpleweatherandroid.core.common.dispatcher.DispatcherType.DEFAULT
import blog.jinhyun.simpleweatherandroid.core.common.dispatcher.DispatcherType.IO
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.test.TestDispatcher

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DispatchersModule::class],
)
internal object TestDispatchersModule {

    @Provides
    @Dispatcher(IO)
    fun providesIODispatcher(
        testDispatcher: TestDispatcher
    ): CoroutineDispatcher = testDispatcher

    @Provides
    @Dispatcher(DEFAULT)
    fun providesDefaultDispatcher(
        testDispatcher: TestDispatcher,
    ): CoroutineDispatcher = testDispatcher
}