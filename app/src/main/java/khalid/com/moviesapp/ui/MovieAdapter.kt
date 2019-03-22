package khalid.com.moviesapp.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import khalid.com.moviesapp.PopularMovies
import khalid.com.moviesapp.R
import kotlinx.android.synthetic.main.recycler_view_item.view.*

/**
 * Created by ${KhalidToak} on 3/18/2019.
 */
class MovieAdapter(private val context: Context,
                   private val popularMovies: PopularMovies
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view_item,
            parent, false))
    }

    override fun getItemCount(): Int {
       return popularMovies.results.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val result = popularMovies.results[position]
       holder.itemView.title_text.text = result.title
        Glide.with(context).asBitmap().load("https://image.tmdb.org/t/p/w500${result.posterPath}")
            .into(holder.itemView.display_movie)
    }
    inner class MovieViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val result = popularMovies.results[adapterPosition]
            val intent = Intent(context, MovieDetailActivity::class.java).apply {
                putExtra("Title", result.title)
                putExtra("Description", result.overview)
                putExtra("imageUrl", "https://image.tmdb.org/t/p/w500${result.posterPath}")
            }
            context.startActivity(intent)
        }

    }
}
