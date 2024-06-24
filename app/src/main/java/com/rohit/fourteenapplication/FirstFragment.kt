package com.rohit.fourteenapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.rohit.fourteenapplication.databinding.ActivityMainBinding
import com.rohit.fourteenapplication.databinding.FragmentFirstBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment(), ChangeButtonText {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var binding : FragmentFirstBinding? = null
    var mainActivity : MainActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
        mainActivity?.activityInterface = this
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_first, container, false)
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(binding?.fragmentUsername?.text?.trim().isNullOrEmpty()){
            binding?.fragmentUsername?.error = "Enter username"
        }else {
            val frag_username_data = binding?.fragmentUsername?.text?.trim().toString()
            mainActivity?.changeButtonText(frag_username_data)
        }
    }
    // increment button
    binding?.fragmentIncBtn?.setOnClickListener{
        mainActivity?.incrementData()
    }
    // decrement button
    binding?.fragmentDecBtn?.setOnClickListener {
        mainActivity?.decrementData()
    }
    binding?.fragmentResetBtn?.setOnClickListener {
        mainActivity?.resetData()
    }

}

companion object {
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    @JvmStatic
    fun newInstance(param1: String, param2: String) =
        FirstFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
}

override fun fragmentEditText(et_data: String) {
    binding?.fragmentUsername?.setText(et_data)
}

override fun fragmentRedColor() {
    binding?.llFragment?.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.Red))
}

override fun fragmentBlueColor() {
    binding?.llFragment?.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.Blue))
}

override fun fragmentGreenColor() {
    binding?.llFragment?.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.Green))
}


}