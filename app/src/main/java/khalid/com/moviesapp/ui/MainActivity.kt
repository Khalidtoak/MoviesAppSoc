package khalid.com.moviesapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import khalid.com.moviesapp.ApiClient
import khalid.com.moviesapp.ApiInterface
import khalid.com.moviesapp.PopularMovies
import khalid.com.moviesapp.R
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //hides refresh button while data is loading
        refresh_button.visibility = View.INVISIBLE
        display_movies.layoutManager = GridLayoutManager(this@MainActivity, 2)
        //use the api cliient to get the api interface
        val apiInterface = ApiClient.getRetrofit().create(ApiInterface::class.java)
        //call the get popular movies function
        val popularMovies = apiInterface.getPopularMovies("b90d08104f6ddf9bb30c704bccac4f6a",
            "en-US", 1)
        //handle response and failure of the call
        fetchMovies(popularMovies)
        refresh_button.setOnClickListener {
            refresh_button.visibility = View.INVISIBLE
            content_loading.visibility =View.VISIBLE
            fetchMovies(popularMovies)
        }
    }

    private fun fetchMovies(popularMovies: Call<PopularMovies>) {
        popularMovies.clone().enqueue(object : Callback<PopularMovies> {
            override fun onFailure(call: Call<PopularMovies>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity, "Unable to connect "
                            + t.message, Toast.LENGTH_SHORT
                ).show()
                hideProgressBar()
                //show refresh button
                refresh_button.visibility = View.VISIBLE
            }

            override fun onResponse(call: Call<PopularMovies>, response: Response<PopularMovies>) {
                display_movies.adapter = MovieAdapter(this@MainActivity, response.body()!!)
                hideProgressBar()
            }

        })
    }

    private fun hideProgressBar() {
        content_loading.visibility = View.INVISIBLE
    }
}
