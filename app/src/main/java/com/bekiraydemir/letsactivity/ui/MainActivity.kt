package com.bekiraydemir.letsactivity.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bekiraydemir.letsactivity.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)




    }
    /*
    fun BookDetailsFragment(view: View){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val bookFragment = BookDetailsFragment()
        fragmentTransaction.replace(R.id.HomeFragment)

    }
    */

}