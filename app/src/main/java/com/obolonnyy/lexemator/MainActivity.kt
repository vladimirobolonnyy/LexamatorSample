package com.obolonnyy.lexemator

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.text1).apply { text = LL.screen1_text1 }
        findViewById<TextView>(R.id.text2).apply { text = LL.screen1_text2 }
        findViewById<TextView>(R.id.text3).apply { text = LL.screen1_text3 }
        findViewById<TextView>(R.id.text4).apply { text = LL.screen1_text4 }
    }
}