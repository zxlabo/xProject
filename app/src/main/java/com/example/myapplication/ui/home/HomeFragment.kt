package com.example.myapplication.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.permission.tools.XActivityResult
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.tv)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        Log.d("xone", "HomeFragment1: -------- onCreateView")
        return root
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        tv2.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_settingsFragment))

        var i = 100
        tv2.setOnClickListener {
            XActivityResult.create()
                .start(requireContext(), MainActivity::class.java, i++)
//                .onActivityResultCallback { i, i2, intent ->
//                    Log.d("xone", "HomeFragment1: -------- ok--$i")
//                }
        }
    }
}