package com.example.geeks_mvvm.utel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.geeks_mvvm.R
import com.example.geeks_mvvm.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import com.example.geeks_mvvm.databinding.FragmentRelisRomBinding

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding : FragmentMainBinding
    private val viewModel: LoveViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnGetLove.setOnClickListener {
                viewModel.getLiveLoveData(etFirstName.text.toString(), etSecondName.text.toString())
                    .observe(viewLifecycleOwner, Observer {
                        tvResult.text = it.toString()
                        App.appDatabase.getDao().insert(it)
                    })
            }
            btnGetRoom.setOnClickListener {
                findNavController().navigate(R.id.relisRomFragment)
            }
        }
    }
}