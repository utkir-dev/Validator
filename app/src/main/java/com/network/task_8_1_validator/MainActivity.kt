package com.network.task_8_1_validator

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.network.myvalidator.Validation
import com.network.task_8_1_validator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        val countryList = arrayOf(
            "Australia",
            "Uzbekistan",
            "Italy",
            "Russia",
            "Spain",
            "UAE",
            "Qatar",
            "Kazakhstan",
            "United States",
            "China",
        )
        val arrayAdapter =
            ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, countryList)
        b.spinner.setAdapter(arrayAdapter)
        b.btnClear.setOnClickListener {
            Validation.clear()
        }
        b.btnSubmit.setOnClickListener {
            Validation.run {
                addText(b.userId)
                addText(b.password)
                addText(b.passwordReenter)
                addText(b.passwordReenter)
                addText(b.etFirstName)
                addText(b.etLastName)
                addText(b.etEmail)
                addSpinner(b.spinner)
                addText(b.etIp)
                addText(b.etPhone)
                addText(b.etZip)
                addText(b.etYear)

                if (check()) {
                    // Success
                } else {
                    // Failed
                }
            }
        }
    }
}