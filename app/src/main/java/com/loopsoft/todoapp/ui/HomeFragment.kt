package com.loopsoft.todoapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.loopsoft.todoapp.R
import com.loopsoft.todoapp.databinding.FragmentHomeBinding
import com.loopsoft.todoapp.ui.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? =null
    private val binding get() = _binding!!

    private val viewModel by viewModels<HomeViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container, false)


        viewModel.todoList.observe(viewLifecycleOwner){
            println(it)
        }

        binding.fargmentHomeFab.setOnClickListener{
            viewModel.insertTodo()
        }


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding
    }
}