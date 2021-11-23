package org.techtown.hilteexample.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*
import org.techtown.hilteexample.R
import org.techtown.hilteexample.data.MyRepository
import org.techtown.hilteexample.di.qualifier.ActivityHash
import org.techtown.hilteexample.di.qualifier.AppHash
import org.techtown.hilteexample.ui.second.SecondActivity
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val activityViewModel by viewModels<MainViewModel>()
    private val viewModel by viewModels<MainViewModel>()
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

        button_activity.setOnClickListener {
            val intent = Intent(requireContext(), SecondActivity::class.java)
            startActivity(intent)
        }

        button_fragment.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_secondFragment2)
        }

        Log.d("MainFragment", "${repository.hashCode()}")
        Log.d("MainFragment", "appHash: $applicationHash")
        Log.d("MainFragment", "activityHash: $activityHash")
        Log.d("MainFragment", "viewModel: ${viewModel.getRepositoryHash()}")
        Log.d("MainFragment", "activityViewModel: ${activityViewModel.getRepositoryHash()}")
    }
}