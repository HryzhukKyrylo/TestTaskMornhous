package com.example.testtaskmornhouse.ui.mainscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.testtaskmornhouse.databinding.FragmentMainScreenBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainScreenFragment : Fragment() {
    private lateinit var binding: FragmentMainScreenBinding
    private val viewModel by viewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainScreenBinding.inflate(inflater, container, false)

        initClickListeners()
        initObserver()
        return binding.root
    }

    private fun initObserver() {
        viewModel.infoOfNumber.observe(viewLifecycleOwner) {
            it?.let { data ->
                val action =
                    MainScreenFragmentDirections.actionMainScreenFragmentToDetailScreenFragment(data)
                findNavController().navigate(action)
            }
        }
    }

    private fun initClickListeners() {
        binding.btnGetFact.setOnClickListener {
            val data = binding.etInputNumber.text.toString()
            viewModel.requireNumberInfo(data)
        }

        binding.btnRandomNumber.setOnClickListener {
            //todo implement
        }
    }

}