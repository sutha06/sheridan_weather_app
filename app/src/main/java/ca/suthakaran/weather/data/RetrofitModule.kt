package ca.suthakaran.weather.data

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory






@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    private const val API_KEY = "7a5c54cc510975778d1e6e164fbcfa47"
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    fun provideRetrofit(moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    fun provideWeatherApi(retrofit: Retrofit): ReposApi {
        return retrofit.create(ReposApi::class.java)
    }
}
