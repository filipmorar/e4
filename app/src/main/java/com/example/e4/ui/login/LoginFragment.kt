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
import com.example.e4.databinding.LoginFragmentBinding
import com.example.e4.networking.ApiProvider
import com.example.e4.utils.viewModelFactory
import com.example.e4.workers.LoginWorker
import com.google.android.material.snackbar.Snackbar

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProviders.of(this, viewModelFactory { LoginViewModel(LoginWorker(ApiProvider.provideLoginApi())) })
            .get(LoginViewModel::class.java)
        val binding = DataBindingUtil.inflate<LoginFragmentBinding>(inflater, R.layout.login_fragment, container, false)
        binding.loginViewModel = viewModel
        viewModel.apply{
            loginMessage.observe(viewLifecycleOwner, Observer {
                Snackbar.make(binding.root, it, Snackbar.LENGTH_SHORT).show()
            })
            navigationCommand.observe(viewLifecycleOwner, Observer {
                findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
            })
        }
        return binding.root
    }

}
