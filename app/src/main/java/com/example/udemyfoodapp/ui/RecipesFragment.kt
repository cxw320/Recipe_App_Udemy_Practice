package com.example.udemyfoodapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.udemyfoodapp.MainViewModel
import com.example.udemyfoodapp.R
import com.example.udemyfoodapp.adapters.RecipesAdapter
import kotlinx.android.synthetic.main.fragment_recipes.view.*


class RecipesFragment : Fragment() {

    private lateinit var mainViewModel: MainViewModel
    private val mAdapter by lazy { RecipesAdapter() }
    private lateinit var mView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        mView = inflater.inflate(R.layout.fragment_recipes, container, false)

        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        setupRecyclerView()

        return mView
    }

    private fun requestApiData(){
        mainViewModel.getRecipes(queries: Map<String,String>)

    }

    private fun setupRecyclerView(){
        mView.recyclerview.adapter = mAdapter
        mView.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        showShimmerEffect()
    }

    private fun showShimmerEffect(){
        mView.recyclerview.showShimmer()

    }

    private fun hideShimmerEffect(){
        mView.recyclerview.hideShimmer()
    }
}