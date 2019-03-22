package khalid.com.moviesapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import khalid.com.moviesapp.R
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        title_movie.text = intent.getStringExtra("Title")
        description_movie.text = intent.getStringExtra("Description")
        Glide.with(this@MovieDetailActivity).asBitmap().load(intent.getStringExtra("imageUrl"))
            .into(movie_image)
    }
}
