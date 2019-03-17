package khalid.com.moviesapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by ${KhalidToak} on 3/17/2019.
 */
class ApiClient{
    companion object {
        private  val baseUrl = "https://api.themoviedb.org/3/movie/"
        fun getRetrofit (): Retrofit {
            return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}