package com.adityayadav.moviemaniac.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adityayadav.moviemaniac.R
import com.adityayadav.moviemaniac.model.MovieDAO
import com.adityayadav.moviemaniac.repository.MovieRepository
import kotlinx.android.synthetic.main.fragment_movie_detail.view.*
import kotlinx.android.synthetic.main.fragment_movie_detail.view.movie_name

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MovieDetailFragment : Fragment() {

    private lateinit var movie: MovieDAO

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movieList = MovieRepository.movieList
        arguments?.let {
            val args =
                MovieDetailFragmentArgs.fromBundle(
                    it
                )
            movie = movieList.filter { movie -> movie.id == args.listId }[0]
        }

        activity?.let {
            view.movie_name.text = movie.title
            view.movie_poster.setImageResource(movie.poster)
            view.movie_director.text = getString(R.string.movie_director, movie.director)
            view.movie_release_date.text = getString(R.string.movie_release_date, movie.releaseDate)
            view.movie_summary.text = movie.summary
            view.movie_rating.text = getString(R.string.movie_rating, movie.ratings.toString())
        }

//        view.findViewById<Button>(R.id.button_second).setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }
    }

    companion object {
        private const val ARG_LIST = "list"
        fun newInstance(movieList: MovieDAO): MovieDetailFragment {
            val bundle = Bundle()
            bundle.putParcelable(ARG_LIST, movieList)
            val fragment =
                MovieDetailFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}