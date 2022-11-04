package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.activityBtn.setOnClickListener {
            replaceFragment(Fragment1())
        }
    }

    fun replaceFragment(fragment: Fragment) {
        binding.activityBtn.visibility = View.GONE
        Toast.makeText(this,"moving to fragment1",Toast.LENGTH_SHORT).show()
        supportFragmentManager.beginTransaction().replace(R.id.lContainer,fragment).commit()
    }


}