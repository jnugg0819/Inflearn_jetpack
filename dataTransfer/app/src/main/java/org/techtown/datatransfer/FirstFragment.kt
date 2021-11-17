package org.techtown.datatransfer

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import androidx.fragment.app.*
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment(R.layout.fragment_first) {

    val getContent = registerForActivityResult(ActivityResultContracts.GetContent()
    )
    {
        imageView.setImageURI(it)
    }

    val getStartActivityForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ activityResult ->
        activityResult.data?.let { intent ->
            intent.extras?.let { bundle ->
                Toast.makeText(requireContext(), "result : ${bundle.getString("data","world")}" , Toast.LENGTH_LONG).show()
            }
        }
    }

    /*
    * 그냥 viewModels를 사용하면 Fragment에 LifeCycle에맞는 ViewModel이 생성되기때문에
    * activityViewModels를 사용해주세요.
    * */
//    val mainViewModel by activityViewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {
            Intent(requireContext(), ResultActivity::class.java).apply {
                getStartActivityForResult.launch(this)
            }
        }
    }
}