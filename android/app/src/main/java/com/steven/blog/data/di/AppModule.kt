package com.steven.blog.data.di

import com.steven.blog.data.api.ApiClient
import com.steven.blog.data.api.BlogApi
import com.steven.blog.data.repo.BlogRepository
import com.steven.blog.data.repo.EssayRepository
import com.steven.blog.data.repo.FileRepository
import com.steven.blog.data.repo.HotRepository
import com.steven.blog.data.repo.MessageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * 依赖注入：Repository 均为进程级单例，包装 ApiClient 的 Retrofit 实例。
 * ViewModel 通过 @HiltViewModel + @Inject 构造函数直接获取。
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideBlogApi(): BlogApi = ApiClient.api

    @Provides
    @Singleton
    fun provideBlogRepository(api: BlogApi): BlogRepository = BlogRepository(api)

    @Provides
    @Singleton
    fun provideEssayRepository(api: BlogApi): EssayRepository = EssayRepository(api)

    @Provides
    @Singleton
    fun provideMessageRepository(api: BlogApi): MessageRepository = MessageRepository(api)

    @Provides
    @Singleton
    fun provideFileRepository(): FileRepository = FileRepository()

    @Provides
    @Singleton
    fun provideHotRepository(api: BlogApi): HotRepository = HotRepository(api)
}
