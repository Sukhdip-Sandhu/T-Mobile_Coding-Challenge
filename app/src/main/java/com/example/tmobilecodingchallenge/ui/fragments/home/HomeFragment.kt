package com.example.tmobilecodingchallenge.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tmobilecodingchallenge.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

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

        homeViewModel.viewState.observe(viewLifecycleOwner) { state ->
            when(state){
                is HomeViewModel.ViewState.Success -> {
                    binding.progressBar.visibility = View.INVISIBLE
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}