package com.semauluc.sayacprojesi

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.android.synthetic.main.activity_main.textView

class MainActivity : AppCompatActivity() {
    lateinit var textView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        object : CountDownTimer(15000, 1000) {
            override fun onFinish() {
                textView.text = "YOU WIN"
            }

            override fun onTick(millisUntilFinished: Long) {
                textView.text = "Kalan: ${millisUntilFinished / 1000}"
            }

        }.start()
    }
}
