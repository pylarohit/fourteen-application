package com.rohit.fourteenapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rohit.fourteenapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding : ActivityMainBinding?= null
    var activityInterface : ChangeButtonText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.redButton?.setOnClickListener {
            activityInterface?.fragmentRedColor()
        }

        binding?.blueButton?.setOnClickListener {
            activityInterface?.fragmentBlueColor()
        }

        binding?.greenButton?.setOnClickListener {
            activityInterface?.fragmentGreenColor()
        }
        binding?.ActivityPassBtn?.setOnClickListener {
            val et_data = binding?.actUsername?.text?.trim().toString()
            activityInterface?.fragmentEditText(et_data)
            if (binding?.actUsername?.text?.trim().isNullOrEmpty()) {
                binding?.actUsername?.error = "enter username"
            } else {
                val et_data = binding?.actUsername?.text?.trim().toString()
                activityInterface?.fragmentEditText(et_data)
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun changeButtonText(text:String) {
        binding?.actUsername?.setText(text)
    }

    fun incrementData() {

        val counter_data = binding?.actCounter?.text?.trim().toString()
        val int_data = counter_data.toInt()
        val inc_data = int_data + 1
        binding?.actCounter?.setText("${inc_data}")
    }

    fun decrementData() {
        val counter_data = binding?.actCounter?.text?.trim().toString()
        val int_data = counter_data.toInt()
        if (int_data == 0 ) {
            binding?.actCounter?.setText("0")
        }else{
            val dec_data = int_data - 1
            binding?.actCounter?.setText(dec_data.toString())
        }
    }

    fun resetData() {
        binding?.actCounter?.setText("0")
    }
}