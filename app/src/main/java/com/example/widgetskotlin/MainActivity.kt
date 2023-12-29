package com.example.widgetskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
// creating objects to interact with the ui
    private lateinit var radioGroup: RadioGroup
    private  lateinit var radioButton: RadioButton
    private lateinit var seekBar: SeekBar
    private lateinit var textViewProgress: TextView
    private lateinit var toggleButton: ToggleButton
    private lateinit var toggleView: TextView
    private lateinit var checkBoxkotlin: CheckBox
    private lateinit var checkboxJava: CheckBox
    private lateinit var checkBoxDart: CheckBox
    private lateinit var checkBoxResult: TextView
    private lateinit var shoButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//finding views by id radio buttons =======================================
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
//seek bar======================
        seekBar = findViewById(R.id.seekBar)
        textViewProgress = findViewById(R.id.texts)

        seekBar.setOnSeekBarChangeListener(object: OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                Toast.makeText(this@MainActivity, "on progress change", Toast.LENGTH_SHORT).show()
                textViewProgress.text = "Rate =" + seekBar.progress.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                Toast.makeText(this@MainActivity, "on start tracking touch", Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                Toast.makeText(this@MainActivity, "on stop tracking touch", Toast.LENGTH_SHORT).show()
            }

        })

//        toggle buttons ======================

        toggleButton = findViewById(R.id.toggleButton)
        toggleView = findViewById(R.id.textView3)
        
        toggleButton.setOnCheckedChangeListener { compoundButton, isChecked ->
                if (isChecked){
                    toggleView.visibility = View.VISIBLE
                }else{
                    toggleView.visibility = View.INVISIBLE
                }
        }

//        checkbox==============
        checkBoxkotlin = findViewById(R.id.checkboxKotlin)
        checkboxJava = findViewById(R.id.checkBoxjava)
        checkBoxDart = findViewById(R.id.checkBoxDart)
        checkBoxResult = findViewById(R.id.textView4)
        shoButton = findViewById(R.id.checkBoxbutton)

        shoButton.setOnClickListener {
            val sb = StringBuilder()
            sb.append(checkBoxkotlin.text.toString()+"status is: " + checkBoxkotlin.isChecked + "\n")
            sb.append(checkboxJava.text.toString()+ "status is: " + checkboxJava.isChecked + "\n")
            sb.append(checkBoxDart.text.toString()+ "status is: "+ checkBoxDart.isChecked+ "\n")

            checkBoxResult.text = sb.toString()
        }






    }
}