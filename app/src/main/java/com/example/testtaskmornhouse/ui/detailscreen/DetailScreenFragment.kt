package com.example.testtaskmornhouse.ui.detailscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.testtaskmornhouse.R
import com.example.testtaskmornhouse.databinding.FragmentDetailScreenBinding
import com.example.testtaskmornhouse.domain.model.NumberModel

class DetailScreenFragment : Fragment() {
    private lateinit var binding: FragmentDetailScreenBinding
    private val args by navArgs<DetailScreenFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailScreenBinding.inflate(inflater, container, false)

        if (args.numberModel != null) {
            showData(args.numberModel!!)
        } else {
            Toast.makeText(
                requireContext(),
                getString(R.string.detail_screen_incorrect_data),
                Toast.LENGTH_SHORT
            ).show()
            findNavController().navigateUp()
        }
        return binding.root
    }

    private fun showData(numberModel: NumberModel) {
        binding.tvNumber.text = numberModel.number
        binding.tvInfoNumber.text = numberModel.text
    }

}