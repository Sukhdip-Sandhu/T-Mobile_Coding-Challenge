package com.example.tmobilecodingchallenge.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmobilecodingchallenge.adapters.HomePageFeedAdapter
import com.example.tmobilecodingchallenge.databinding.FragmentHomeBinding
import com.example.tmobilecodingchallenge.models.Cards
import dagger.hilt.android.AndroidEntryPoint

private lateinit var homePageFeedAdapter: HomePageFeedAdapter

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setupRecyclerView()

        homeViewModel.viewState.observe(viewLifecycleOwner) { state ->
            when(state){
                is HomeViewModel.ViewState.Success -> {
                    binding.progressBar.visibility = View.INVISIBLE
                    setCardsList(state.homePageFeed.page.cards)
                }
                is HomeViewModel.ViewState.Error -> {
                    binding.progressBar.visibility = View.INVISIBLE
                }
                HomeViewModel.ViewState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        }

        return binding.root
    }

    private fun setupRecyclerView() {
        homePageFeedAdapter = HomePageFeedAdapter()
        binding.recyclerView.apply {
            adapter = homePageFeedAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun setCardsList(cards: List<Cards>) {
        homePageFeedAdapter.setCardsList(cards)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}