package org.techtown.hilteexample.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_second.*
import org.techtown.hilteexample.R
import org.techtown.hilteexample.ui.data.MyRepository


class SecondFragment : Fragment(R.layout.fragment_second) {

    val repository = MyRepository()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment2_to_mainFragment)
        }

        Log.d("SecondFragment", "${repository.hashCode()}")
    }
}