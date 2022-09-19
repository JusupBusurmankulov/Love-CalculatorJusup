package com.example.love_calculatorjusup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.love_calculatorjusup.Retrofit.App
import com.example.love_calculatorjusup.Retrofit.LoveModel
import com.example.love_calculatorjusup.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var fname:String = "null"
    var sname:String = "null"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnCalculate.setOnClickListener {
                fname = binding.etFname.text.toString()
                sname = binding.etSname.text.toString()

                App.api.getCalculateLove(etFname.text.toString(), etSname.text.toString())
                    .enqueue(object : Callback<LoveModel> {
                        override fun onResponse(
                            call: Call<LoveModel>,
                            response: Response<LoveModel>
                        ) {
                            if (response.isSuccessful){
                                Log.e("jusup", "onResponse: ${response.body()?.result}", )
                                val model = response.body()
                                val intent: Intent = Intent(this@MainActivity,ResultActivity::class.java)
                                intent.putExtra("key", fname)
                                intent.putExtra("key1", sname)
                                intent.putExtra("key2", model?.percentage.toString())
                                startActivity(intent)
                            }

                        }
                        override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                            Log.e("jusup", "onFailure: ${t.message}", )
                        }

                    })

            }
        }
    }


}