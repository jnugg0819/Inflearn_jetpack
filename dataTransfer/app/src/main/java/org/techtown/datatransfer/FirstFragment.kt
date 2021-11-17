package org.techtown.datatransfer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.*
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment(R.layout.fragment_first) {

    /*
    * 그냥 viewModels를 사용하면 Fragment에 LifeCycle에맞는 ViewModel이 생성되기때문에
    * activityViewModels를 사용해주세요.
    * */
//    val mainViewModel by activityViewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("requestkey"){ resultKey, bundle ->
            var data = bundle.getString("data", "")

            Toast.makeText(requireContext(),data , Toast.LENGTH_SHORT).show()
        }

        button.setOnClickListener {

            setFragmentResult("requestkey", bundleOf("data" to "hello"))
//            mainViewModel.data = "Hello"
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }
}