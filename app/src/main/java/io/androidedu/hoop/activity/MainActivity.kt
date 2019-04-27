package io.androidedu.hoop.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.androidedu.hoop.R
import io.androidedu.hoop.adapter.ViewPagerAdapter
import io.androidedu.hoop.fragment.CallsFragment
import io.androidedu.hoop.fragment.CameraFragment
import io.androidedu.hoop.fragment.ChatsFragment
import io.androidedu.hoop.fragment.StatusFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewPager()
    }

    private fun setupViewPager() {

        val adapter = ViewPagerAdapter(supportFragmentManager)

        val cameraFragment: CameraFragment = CameraFragment.newInstance()
        val chatsFragment: ChatsFragment = ChatsFragment.newInstance()
        val statusFragment: StatusFragment = StatusFragment.newInstance()
        val callsFragment: CallsFragment = CallsFragment.newInstance()

        adapter.addFragment(cameraFragment, "")
        adapter.addFragment(chatsFragment, "CHATS")
        adapter.addFragment(statusFragment, "STATUS")
        adapter.addFragment(callsFragment, "CALLS")

        vpMain!!.adapter = adapter

        tabLayout.setupWithViewPager(vpMain)

        tabLayout.getTabAt(0)!!.setIcon(R.drawable.camera)

    }
}


