package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.permission.tools.XActivityResult
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        Log.d("xone", "HomeFragment2: -------- onCreateView")
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tv.setOnClickListener {
//            val collection: NavController = Navigation.findNavController(it)
//            collection.navigate(R.id.action_homeFragment_to_detailFragment)

            XActivityResult.create()
                .start(requireContext(), MainActivity3::class.java, 200)
//                .onActivityResultCallback { i, i2, intent ->
//                    Log.d("xone", "HomeFragment2: -------- ok--$i")
//                    activity?.setResult(100)
//                    activity?.finish()
//                }

        }
        tv2.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_settingsFragment))
    }
}