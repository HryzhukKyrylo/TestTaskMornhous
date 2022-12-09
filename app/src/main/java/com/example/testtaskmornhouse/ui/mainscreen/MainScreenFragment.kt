package com.example.testtaskmornhouse.ui.mainscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
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
                Toast.makeText(requireContext(), data.text, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initClickListeners() {
        binding.btnGetFact.setOnClickListener {
            val data = binding.etInputNumber.text.toString()

            viewModel.requireNumberInfo(data)
//            val action =
//                MainScreenFragmentDirections.actionMainScreenFragmentToDetailScreenFragment()
//            findNavController().navigate(action)
        }

        binding.btnRandomNumber.setOnClickListener {
            //todo implement
        }
    }

}