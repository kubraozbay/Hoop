package io.androidedu.hoop.Activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import io.androidedu.hoop.Fragment.CallsFragment
import io.androidedu.hoop.R
import kotlinx.android.synthetic.main.activity_main.*

import io.androidedu.hoop.Fragment.CameraFragment
import io.androidedu.hoop.Fragment.ChatsFragment
import io.androidedu.hoop.Fragment.StatusFragment


class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCall.setOnClickListener(this)
        btnStatus.setOnClickListener(this)
        btnCamera.setOnClickListener(this)
        btnChats.setOnClickListener(this)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fl_container, CameraFragment.newInstance(), "rageComicDetails")
            .commit()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnCall -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fl_container, CallsFragment.newInstance(), "rageComicDetails")
                    .addToBackStack(null)
                    .commit()
            }
            R.id.btnStatus -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fl_container, StatusFragment.newInstance(), "rageComicDetails")
                    .addToBackStack(null)
                    .commit()
            }
            R.id.btnCamera -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fl_container, CameraFragment.newInstance(), "rageComicDetails")
                    .addToBackStack(null)
                    .commit()

            }
            R.id.btnChats -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fl_container, ChatsFragment.newInstance(), "rageComicDetails")
                    .addToBackStack(null)
                    .commit()

            }
        }
    }
}

