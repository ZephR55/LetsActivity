package com.bekiraydemir.letsactivity.ui.home.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bekiraydemir.letsactivity.databinding.RecyclerRowBinding
import com.bekiraydemir.letsactivity.model.Movies
import com.bekiraydemir.letsactivity.ui.home.HomeFragmentDirections

class MovieAdapter(
    val movieList: ArrayList<Movies>,
    private val onClickMovie: (position: Int) -> Unit
) : RecyclerView.Adapter<MovieHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.size

    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.binding.movie.setImageResource(movieList[position].image)
        holder.binding.movieName.text = movieList[position].moviename
        holder.binding.movieLayout.setOnClickListener {
            onClickMovie(position)
           // Log.e("TAG", position.toString())
        }


    }
}

class MovieHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {


}