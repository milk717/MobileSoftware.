package com.example.myapplication

import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioGroup:RadioGroup = findViewById(R.id.radioGroup)
        radioGroup.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                var sb = StringBuilder()
                var radioButton:RadioButton = findViewById(checkedId)
                sb.append(radioButton.text)
                sb.append("를 선택했군요.")
                showToast(sb.toString())
            }
        })

        var id:Int =radioGroup.checkedRadioButtonId
        when(id){
            R.id.red->showToast("Red 가 기본 선택")
            R.id.blue->showToast("blue 가 기본 선택")
            R.id.green->showToast("green 가 기본 선택")
        }
    }
    fun showToast(msg:String){
        Toast.makeText(applicationContext,msg,Toast.LENGTH_SHORT).show()
    }
}