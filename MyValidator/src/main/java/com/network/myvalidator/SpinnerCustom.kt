package com.network.myvalidator

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.*

class SpinnerCustom(context: Context, attributeSet: AttributeSet?) :
    RelativeLayout(context, attributeSet), ValidationImpl {

    private var TAG = "SpinnerCustom"
    private var errorInfo = ""
    private var textError: TextView
    private var spinner: Spinner
    private var isSelect = false
    private var isInit = false
    var position = 0

    init {
        inflate(context, R.layout.layout_spinner, this)
        spinner = findViewById(R.id.spinner_1)
        textError = findViewById(R.id.tv_error)
        textError.setOnClickListener {
            spinner.performClick()

        }
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                position = p2
                if (!isInit) {
                    isInit = true
                    clear()
                } else {
                    isSelect = true
                    textError.visibility = View.GONE
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                isSelect = false
            }
        }
    }

    private fun errorDrawable(msg: String) {
        textError.setCompoundDrawablesWithIntrinsicBounds(
            0,
            0,
            R.drawable.ic_info,
            0
        )
        textError.error = msg
    }

    override fun clear() {
         isSelect=false
        textError.visibility = View.VISIBLE
        textError.text = "<Please select one>"
        textError.setTextColor(resources.getColor(android.R.color.darker_gray, null))

        textError.setCompoundDrawablesWithIntrinsicBounds(
            0,
            0,
            0,
            0
        )
    }

    override fun check(): Boolean {
        if (!isSelect) {
            errorDrawable("Not selected!")
            textError.visibility = View.VISIBLE
            textError.text = "<Please select one>"
            textError.setTextColor(resources.getColor(R.color.red, null))
        } else {
            spinner.setSelection(position)
            textError.setTextColor(resources.getColor(android.R.color.darker_gray, null))
            textError.visibility = View.GONE

        }
        return isSelect
    }

    fun setAdapter(adapter: SpinnerAdapter) {
        spinner.adapter = adapter

    }
    override fun setPattern(reg: String?) {

    }

    override fun setErrorInfo(errorInfo: String?) {
        errorInfo?.let { this.errorInfo = it }
    }
}