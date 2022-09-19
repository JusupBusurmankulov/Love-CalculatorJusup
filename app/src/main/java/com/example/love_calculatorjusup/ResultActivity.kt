package com.example.love_calculatorjusup

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Binder
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.love_calculatorjusup.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initCliker()
        binding.tvPercentage.text = intent.getStringExtra("key2")+"%"
        binding.tvSname.text = intent.getStringExtra("key1")
        binding.tvFname.text = intent.getStringExtra("key")


    }

    private fun initCliker() {
        binding.btnRestart.setOnClickListener {
            var intent:Intent =  Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}