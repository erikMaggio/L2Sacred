package com.example.l2sacred.ui.home.presenter

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.l2sacred.R
import com.example.l2sacred.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val homeFragment = HomeFragment.newInstance()
    private val itemsFragment = ItemsFragment.newInstance()
    private val skillsFragment = SkillsFragment.newInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if (savedInstanceState == null) {
            showFragment(homeFragment, HomeFragment::class.java.toString())
        }
        navigationFragment()

    }

    private fun navigationFragment() {
        binding.ivHomeFragment.setOnClickListener {
            showFragment(homeFragment, HomeFragment::class.java.toString())
        }

        binding.ivItemsFragment.setOnClickListener {
            showFragment(itemsFragment, ItemsFragment::class.java.toString())
        }

        binding.ivSkillsFragment.setOnClickListener {
            showFragment(skillsFragment, SkillsFragment::class.java.toString())
        }
    }

    private fun showFragment(fragment: Fragment, tag: String) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        supportFragmentManager.fragments.forEach {
            if (it.isVisible) {
                fragmentTransaction.hide(it)
            }
        }

        if (fragment.isAdded) {
            fragmentTransaction.show(fragment)
        } else {
            fragmentTransaction.add(binding.flFragment.id, fragment, tag)
        }
        fragmentTransaction.commit()
    }
}
