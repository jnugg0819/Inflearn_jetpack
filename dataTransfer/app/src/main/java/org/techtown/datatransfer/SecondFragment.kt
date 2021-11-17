package org.techtown.datatransfer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_first.button
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment(R.layout.fragment_second) {

//    val mainViewModel by activityViewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("requestkey"){ resultKey, bundle ->
            var data = bundle.getString("data", "")

            Toast.makeText(requireContext(),data , Toast.LENGTH_SHORT).show()
        }

        button2.setOnClickListener {
            setFragmentResult("requestkey", bundleOf("data" to "hello"))
            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }
    }
}