package io.androidedu.hoop.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.androidedu.hoop.R

class CallsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calls, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            CallsFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}