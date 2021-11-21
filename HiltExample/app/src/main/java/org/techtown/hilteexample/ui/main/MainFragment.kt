package org.techtown.hilteexample.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_main.*
import org.techtown.hilteexample.R
import org.techtown.hilteexample.ui.data.MyRepository
import org.techtown.hilteexample.ui.second.SecondActivity

class MainFragment : Fragment(R.layout.fragment_main) {

    val repository = MyRepository()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_activity.setOnClickListener {
            val intent = Intent(requireContext(), SecondActivity::class.java)
            startActivity(intent)
        }

        button_fragment.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_secondFragment2)
        }

        Log.d("MainFragment", "${repository.hashCode()}")
    }
}