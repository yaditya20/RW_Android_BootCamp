package com.adityayadav.moviemaniac.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adityayadav.moviemaniac.R

class MovieListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var movieListPoster = itemView.findViewById<ImageView>(R.id.movie_image)
    var movieListName = itemView.findViewById<TextView>(R.id.movie_name)
}