package com.adityayadav.moviemaniac.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adityayadav.moviemaniac.model.MovieDAO
import com.adityayadav.moviemaniac.R
import com.adityayadav.moviemaniac.viewholder.MovieListViewHolder

class MovieListAdapter(private val movieLists: ArrayList<MovieDAO>, private val clickListener: MovieListClickListener) :RecyclerView.Adapter<MovieListViewHolder>() {
    interface MovieListClickListener {
        fun listItemClicked(movieList: MovieDAO)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_list_view_holder, parent, false)
        return  MovieListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieLists.size
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.movieListPoster.setImageResource(movieLists[position].poster)
        holder.movieListName.text = movieLists[position].title
        holder.itemView.setOnClickListener {
            clickListener.listItemClicked(movieLists[position])
        }
    }
}