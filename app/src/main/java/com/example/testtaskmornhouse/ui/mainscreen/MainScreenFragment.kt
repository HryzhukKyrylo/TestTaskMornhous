package com.example.testtaskmornhouse.ui.mainscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskmornhouse.databinding.FragmentMainScreenBinding
import com.example.testtaskmornhouse.domain.model.NumberModel
import com.example.testtaskmornhouse.ui.mainscreen.adapter.MainAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainScreenFragment : Fragment() {
    private lateinit var binding: FragmentMainScreenBinding
    private val viewModel by viewModel<MainViewModel>()
    private lateinit var recycler: RecyclerView
    private val adapter: MainAdapter = MainAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainScreenBinding.inflate(inflater, container, false)

        initClickListeners()
        initRecycler()
        initObserver()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        getListHistory()
    }

    private fun getListHistory() {
        viewModel.getListHistory()
    }

    private fun initRecycler() {
        recycler = binding.rvHistoryList
        recycler.adapter = adapter
    }

    private fun initObserver() {
        viewModel.infoOfNumber.observe(viewLifecycleOwner) {
            it?.let { data ->
                val action =
                    MainScreenFragmentDirections.actionMainScreenFragmentToDetailScreenFragment(data)
                findNavController().navigate(action)
            }
        }

        viewModel.listHistory.observe(viewLifecycleOwner) { list ->
            showListHistory(list)
        }
    }

    private fun showListHistory(list: List<NumberModel>?) {
        if (list.isNullOrEmpty()) {
            showNoDataMessage()
        } else {
            hideNoDataMessage()
            adapter.submitList(list)
        }
    }

    private fun hideNoDataMessage() {
        binding.tvNoDataHistory.isVisible = false
        binding.rvHistoryList.isVisible = true
    }

    private fun showNoDataMessage() {
        binding.tvNoDataHistory.isVisible = true
        binding.rvHistoryList.isVisible = false
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