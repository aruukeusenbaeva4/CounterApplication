package com.example.counterapplication

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.annotation.AttrRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.counterapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var counter=0
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        var counterPref =CounterPref(context = this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.tvText.text= counterPref.getCount().toString()

        binding.btnIncrement.setOnClickListener {
            counter++
            binding.tvText.text = counter.toString()
            counterPref.saveCount(counter)

        }
    }
}