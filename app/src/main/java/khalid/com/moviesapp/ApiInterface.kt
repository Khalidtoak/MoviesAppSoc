package khalid.com.moviesapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by ${KhalidToak} on 3/17/2019.
 */
interface ApiInterface{
    @GET("popular")
    fun getPopularMovies(@Query("api_key") apiKey :String,
                         @Query("language") language : String,
                         @Query("page") page : Int) : Call<PopularMovies>
    //https://api.themoviedb.org/3/movie/popular?api_key=b90d08104f6ddf9bb30c704bccac4f6a&language=en-US&page=2
}