package com.adityayadav.moviemaniac.fragment

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adityayadav.moviemaniac.adapter.MovieListAdapter
import com.adityayadav.moviemaniac.R
import com.adityayadav.moviemaniac.model.MovieDAO
import com.adityayadav.moviemaniac.repository.MovieRepository

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MovieListFragment : Fragment(), MovieListAdapter.MovieListClickListener {

    private lateinit var movieListRecyclerView: RecyclerView
    //private var movieRepository: MovieRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movieList = MovieRepository.movieList
        movieListRecyclerView = view.findViewById(R.id.movie_list_recyclerview)
        movieListRecyclerView.layoutManager = if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
        } else {
            GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
        }

        movieListRecyclerView.adapter = MovieListAdapter(movieList, this)
    }

    companion object {
        fun newIntance(): MovieListFragment {
            return MovieListFragment()
        }
    }

    override fun listItemClicked(movieList: MovieDAO) {
        showMovieListItems(movieList)
    }

    private fun showMovieListItems(movie: MovieDAO) {
        view?.let {
            val action =
                MovieListFragmentDirections.actionFirstFragmentToSecondFragment(
                    movie.id
                )
            it.findNavController().navigate(action)
        }
    }
}