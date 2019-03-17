package khalid.com.moviesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apiInterface = ApiClient.getRetrofit().create(ApiInterface::class.java)
        var popularMovies = apiInterface.getPopularMovies("b90d08104f6ddf9bb30c704bccac4f6a",
            "en-US", 1)
        popularMovies.enqueue(object : Callback<PopularMovies>{
            override fun onFailure(call: Call<PopularMovies>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Unable to connect "
                        + t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<PopularMovies>, response: Response<PopularMovies>) {
                display_movies.text = response.body().toString()
            }

        })
    }
}
