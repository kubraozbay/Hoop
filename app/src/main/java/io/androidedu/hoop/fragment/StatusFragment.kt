package io.androidedu.hoop.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.androidedu.hoop.R

class StatusFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_status, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = StatusFragment()
    }
}
