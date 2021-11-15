package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fragment_container:FrameLayout = findViewById(R.id.fragment_container)
        var buttonA: Button = findViewById(R.id.buttonA)
        var buttonB: Button = findViewById(R.id.buttonB)
        val fragmentA = FragmentA()
        val fragmentB = FragmentB()

        if(fragment_container != null){     //아무것도 없다면
            if(savedInstanceState != null)  //이게 null 이 아니면 프래그먼트를 갖고 있었음
                return
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragmentA)
                .addToBackStack(null)
                .commit()
        }

        buttonA.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragmentA)
                .addToBackStack(null)
                .commit()
        }
        buttonB.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragmentB)
                .addToBackStack(null)
                .commit()
        }
    }

}

