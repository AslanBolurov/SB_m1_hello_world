package com.skillbox.aslanbolurov.task1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.annotation.StringRes
import com.skillbox.aslanbolurov.task1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    var counter=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvInfo.text=binding.tvInfo.context.getText(R.string.allPlacesAreFree)
        binding.tvCounter.text="0"
        binding.btnPlus.setOnClickListener{
            counter++
            if (counter>50){
                counter=50
                binding.btnReset.visibility=View.VISIBLE
                binding.tvInfo.setTextColor(Color.parseColor("#E12619"))
                binding.tvInfo.setText(R.string.tooManyPassengers)

            }else if (counter in 1..49){
                binding.tvInfo.setTextColor(Color.parseColor("#2483CF"))
                var remainderPlaces=50-counter
                binding.tvInfo.setText("Places left: $remainderPlaces")
            }
            binding.tvCounter.text=counter.toString()
        }
        binding.btnMinus.setOnClickListener{
            counter--
            if (counter<0||counter==0){
                counter=0
                binding.tvInfo.setTextColor(Color.parseColor("#4F880D"))
                binding.tvInfo.setText(R.string.allPlacesAreFree)

            }else if (counter in 1..49){
                binding.tvInfo.setTextColor(Color.parseColor("#2483CF"))
                var remainderPlaces=50-counter
                binding.tvInfo.setText("Places left: $remainderPlaces")
            }
            binding.tvCounter.text=counter.toString()
        }
        binding.btnReset.setOnClickListener {
            counter=0
            binding.tvCounter.text=counter.toString()
            binding.tvInfo.setTextColor(Color.parseColor("#4F880D"))
            binding.tvInfo.setText(R.string.allPlacesAreFree)
            binding.btnReset.visibility= View.INVISIBLE
        }



    }
}