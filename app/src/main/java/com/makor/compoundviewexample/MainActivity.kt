package com.makor.compoundviewexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        consent1.setOnCheckedChangeListener { _, _ -> validateConsents() }
        consent2.setOnCheckedChangeListener { _, _ -> validateConsents() }
    }

    private fun validateConsents() {
        confirmButton.isEnabled = consent1.isChecked && consent2.isChecked
    }
}
