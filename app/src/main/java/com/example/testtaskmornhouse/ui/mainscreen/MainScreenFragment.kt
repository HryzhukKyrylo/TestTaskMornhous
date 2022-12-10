package com.example.testtaskmornhouse.ui.mainscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskmornhouse.R
import com.example.testtaskmornhouse.databinding.FragmentMainScreenBinding
import com.example.testtaskmornhouse.domain.model.NumberModel
import com.example.testtaskmornhouse.ui.mainscreen.adapter.MainAdapter
import com.example.testtaskmornhouse.ui.mainscreen.adapter.MainItemDecoration
import com.example.testtaskmornhouse.utils.dp
import com.example.testtaskmornhouse.utils.isNetworkAvailable
import com.example.testtaskmornhouse.utils.toastShort
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
        recycler.addItemDecoration(
            MainItemDecoration(
                verticalSpace = (8.dp).toInt(),
                horizontalSpace = (8.dp).toInt()
            )
        )
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

        viewModel.emptyNumberMessage.observe(viewLifecycleOwner) {
            showEmptyNumberErrorMessage()
        }
    }

    private fun showEmptyNumberErrorMessage() {
        binding.etInputNumber.error = getString(R.string.main_screen_error_message)
        requireContext().toastShort(getString(R.string.main_screen_number_is_empty))
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
            if (requireContext().isNetworkAvailable()) {
                val data = binding.etInputNumber.text.toString()
                viewModel.requireNumberInfo(data)
            } else {
                requireContext().toastShort(getString(R.string.main_screen_no_internet_connection))
            }
        }

        binding.btnRandomNumber.setOnClickListener {
            if (requireContext().isNetworkAvailable()) {
                viewModel.requireRandomNumber()
            } else {
                requireContext().toastShort(getString(R.string.main_screen_no_internet_connection))
            }
        }
    }
}