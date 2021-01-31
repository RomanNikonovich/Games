package com.example.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.R
import com.example.presentation.databinding.FragmentGamesBinding


class FragmentGames : Fragment() {
    private lateinit var viewModelFragmentGames: ViewModelFragmentGames
    lateinit var binding: FragmentGamesBinding
    private lateinit var recyclerView: RecyclerView

    companion object {
        fun getInstance(fragmentManager: FragmentManager): FragmentGames {
            val fragmentGames: FragmentGames? =
                fragmentManager.findFragmentByTag(FragmentGames::class.simpleName) as? FragmentGames

            return fragmentGames ?: FragmentGames()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModelFragmentGames =
            ViewModelProviders.of(this).get(ViewModelFragmentGames::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_games, container, false)
        binding.viewModel = viewModelFragmentGames
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.rvJokes
        recyclerView.adapter = viewModelFragmentGames.adaptRV
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                view.context,
                DividerItemDecoration.VERTICAL
            )
        )
        viewModelFragmentGames.getGames()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModelFragmentGames.onDestroy()
    }

}