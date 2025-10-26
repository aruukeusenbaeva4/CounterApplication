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

    private var counter = 0
    private lateinit var binding: ActivityMainBinding
    private lateinit var pref: CounterPref

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
        pref = CounterPref(context = this)
        counter = pref.getCount()
        binding.tvText.text = counter.toString()
        binding.btnIncrement.setOnClickListener {
            if (binding.btnIncrement.text == "+") {
                counter++
                if (counter >= 10) {
                    binding.btnIncrement.text = "-"
                }
            } else {
                counter--
                if (counter <= 0) {
                    binding.btnIncrement.text = "+"
                }
            }

            binding.tvText.text = counter.toString()
            pref.saveCount(counter)
        }
    }
}