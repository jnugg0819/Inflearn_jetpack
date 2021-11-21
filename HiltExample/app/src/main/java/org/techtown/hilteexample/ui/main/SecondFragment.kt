package org.techtown.hilteexample.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_second.*
import org.techtown.hilteexample.R
import org.techtown.hilteexample.data.MyRepository
import org.techtown.hilteexample.di.qualifier.ActivityHash
import org.techtown.hilteexample.di.qualifier.AppHash
import javax.inject.Inject

@AndroidEntryPoint
class SecondFragment : Fragment(R.layout.fragment_second) {

    @Inject
    lateinit var repository: MyRepository

    @AppHash
    @Inject
    lateinit var applicationHash: String

    @ActivityHash
    @Inject
    lateinit var activityHash: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment2_to_mainFragment)
        }

        Log.d("SecondFragment", "${repository.hashCode()}")
        Log.d("SecondFragment", "appHash: $applicationHash")
        Log.d("SecondFragment", "activityHash: $activityHash")
    }
}