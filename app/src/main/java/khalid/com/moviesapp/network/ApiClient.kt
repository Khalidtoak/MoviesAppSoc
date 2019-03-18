package khalid.com.moviesapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by ${KhalidToak} on 3/17/2019.
 * Api client used to initialize retrofit and create the api interface
 */
class ApiClient{
    companion object {
        //base url is the base url of our api url that doesn't change
        private const val baseUrl = "https://api.themoviedb.org/3/movie/"
        fun getRetrofit (): Retrofit {
            //initialize retrofit with the base url and gson conveters
            return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}