package com.example.testtaskmornhouse.ui.mainscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.testtaskmornhouse.databinding.FragmentMainScreenBinding

class MainScreenFragment : Fragment() {
    private lateinit var binding: FragmentMainScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMainScreenBinding.inflate(inflater, container, false)

        initClickListeners()
        //todo
        return binding.root
    }

    private fun initClickListeners() {
        binding.btnGetFact.setOnClickListener {
            val action =
                MainScreenFragmentDirections.actionMainScreenFragmentToDetailScreenFragment()
            findNavController().navigate(action)
        }
    }

}