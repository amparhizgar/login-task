package ir.amirhparhizgar.logintask.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.amirhparhizgar.logintask.data.local.Repository
import ir.amirhparhizgar.logintask.data.local.RepositoryImpl
import ir.amirhparhizgar.logintask.data.remote.RetrofitHelper
import ir.amirhparhizgar.logintask.data.remote.SMSApi
import javax.inject.Singleton

/**
 * Created by AmirHossein Parhizgar on 12/6/2022.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    companion object {
        @Provides
        @Singleton
        fun provideRepository(): Repository = RepositoryImpl()

        @Provides
        @Singleton
        fun provideSMSApi(): SMSApi = RetrofitHelper.getInstance().create(SMSApi::class.java)
    }
}