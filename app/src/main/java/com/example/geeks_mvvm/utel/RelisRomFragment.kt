package com.example.geeks_mvvm.utel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.geeks_mvvm.databinding.FragmentRelisRomBinding

class RelisRomFragment : Fragment() {

    private lateinit var binding: FragmentRelisRomBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRelisRomBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = App.appDatabase.getDao().getAll()

        list.forEach {
            binding.tvListRoom.text =
                list.joinToString(separator = "", prefix = "", postfix = "")
        }
    }
}