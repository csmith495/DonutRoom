package com.example.donutroomassignment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.donutroomassignment.databinding.DonutFragmentBinding

class DonutFragment : Fragment() {

    private var _binding : DonutFragmentBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DonutFragmentBinding.inflate(inflater, container, false)
        val view = binding!!.root
        val application = requireNotNull(this.activity).application
        val dao = DonutDatabase.getInstance(application).donutDao
        val viewModelFactory = DonutViewModelFactory(dao)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(DonutViewModel::class.java)
        binding!!.viewModel = viewModel
        binding!!.lifecycleOwner = viewLifecycleOwner

        return view
    }

}