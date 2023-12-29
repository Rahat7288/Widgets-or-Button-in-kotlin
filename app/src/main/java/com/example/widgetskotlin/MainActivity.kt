package com.example.widgetskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var radioGroup: RadioGroup
    private  lateinit var radioButton: RadioButton
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroup = findViewById(R.id.radioGroup)
        radioGroup.setOnCheckedChangeListener { radioGroup, id ->
            radioButton = findViewById(id)
            when(radioButton.id){
                R.id.yesButton ->{
                    Toast.makeText(this@MainActivity, "Yes button clicked", Toast.LENGTH_SHORT).show()
                }
                R.id.noButton ->{
                    Toast.makeText(this@MainActivity, "No button clicked", Toast.LENGTH_SHORT).show()
                }
                R.id.maybeButton ->{
                    Toast.makeText(this@MainActivity, "Maybe button clicked", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}