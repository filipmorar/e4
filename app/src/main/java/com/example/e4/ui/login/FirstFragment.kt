package com.example.e4.ui.login

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.e4.R
import com.example.e4.databinding.FirstFragmentBinding
import com.example.e4.networking.ApiProvider
import com.example.e4.utils.TagAdapter
import com.example.e4.utils.viewModelFactory
import com.example.e4.workers.FirstScreenWorker

class FirstFragment : Fragment() {

    companion object {
        fun newInstance() = FirstFragment()
    }

    private lateinit var viewModel: FirstViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProviders.of(this, viewModelFactory { FirstViewModel(FirstScreenWorker(ApiProvider.provideGetTasksApi())) })
            .get(FirstViewModel::class.java)
        val binding = DataBindingUtil.inflate<FirstFragmentBinding>(inflater, R.layout.first_fragment, container, false)
        binding.firstViewModel = viewModel

        val tagAdapter = TagAdapter(object : TagAdapter.ClickListener{
            override fun onClick(tag: String) {
                viewModel.onClick(tag)
            }
        })

        binding.tagRecyclerView.adapter = tagAdapter

        viewModel.apply{
            tagsArray.observe(viewLifecycleOwner, Observer{
                tagAdapter.submitList(it!!)
            })
            navigationCommand.observe(viewLifecycleOwner, Observer {
                findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
            })
        }
        return binding.root
    }

}
