package com.example.sampaktemperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cBar = findViewById<SeekBar>(R.id.cBar)
        val fBar = findViewById<SeekBar>(R.id.fBar)
        val cText = findViewById<TextView>(R.id.c_number)
        val fText = findViewById<TextView>(R.id.f_number)
        val interestingText = findViewById<TextView>(R.id.message)

        cBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                var cTemp = 0
                var fTemp = 0
                cTemp = cBar.progress
                fTemp = ((cTemp*9)/5)+32
                cText.text = cTemp.toString()

                if(cTemp == 0){
                    fTemp = 32
                }
                fBar.progress = fTemp
                fText.text = fTemp.toString()

                if(cTemp > 20){
                    interestingText.text = "I wish it were colder"
                }else{
                    interestingText.text = "I wish it were warmer"
                }
            }
        })
        fBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                var cTemp = 0
                var fTemp = 0
                fTemp = fBar.progress
                if(fTemp<32){
                    fTemp = 32
                    fBar.progress = 32
                }
                cTemp = ((fTemp-32)*5)/9
                cText.text = cTemp.toString()
                cBar.progress = cTemp

                fText.text = fTemp.toString()

                if(cTemp > 20){
                    interestingText.text = "I wish it were colder"
                }else{
                    interestingText.text = "I wish it were warmer"
                }
            }
        })
    }
}