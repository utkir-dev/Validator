package com.network.myvalidator

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.network.myvalidator.Validation.passwords

class EditTextCustom(context: Context, attributeSet: AttributeSet?) :
    AppCompatEditText(context, attributeSet), ValidationImpl {

    // private var text: EditText
    private var pattern: String = ""
    private var errorInfo: String = ""

    @SuppressLint("CustomViewStyleable")
    private var typedArray: TypedArray =
        context.obtainStyledAttributes(attributeSet, R.styleable.MyEditText)
    private val type = typedArray.getInt(R.styleable.MyEditText_TypeCustom, 0)


    private fun initTypes() {
        when (type) {
            0 -> {
                // userId
                pattern = if (pattern != "") pattern else "[a-zA-Z0-9_-]+"
                errorInfo = if (errorInfo != "") errorInfo else "UserID error"
            }
            1 -> {
                // text name
                pattern = if (pattern != "") pattern else "[a-zA-Zа-яА-Я\\s]+"
                errorInfo = if (errorInfo != "") errorInfo else "Eror"

            }
            2 -> {
                //password 1
                pattern =
                    if (pattern != "") pattern else "[a-zA-Z0-9?.*\\[\\]()!@#$%&]+"
                errorInfo = if (errorInfo != "") errorInfo else "Password error"
                passwords[1] = this
            }
            3 -> {
                //password 2
                pattern =
                    if (pattern != "") pattern else "[a-zA-Z0-9?.*\\[\\]()!@#$%&]+"
                passwords[2] = this
                errorInfo = "Re-enter password"
            }
            4 -> {
                // email
                pattern =
                    if (pattern != "") pattern else "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@" +
                            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                            "(" +
                            "\\." +
                            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                            ")+"
                errorInfo = if (errorInfo != "") errorInfo else "Email error"
            }
            5 -> {
                // ip address
                pattern =
                    if (pattern != "") pattern else "[0-9]{1,4}\\.[0-9]{1,4}\\.[0-9]{1,4}\\.[0-9]{1,4}"
                errorInfo = if (errorInfo != "") errorInfo else "IP address error"
            }
            6 -> {
                // phone
                pattern = if (pattern != "") pattern else "(^\\+\\d+)?[0-9\\s()-]*"
                errorInfo = if (errorInfo != "") errorInfo else "Phone error"
            }
            7 -> {
                // zip code
                pattern = if (pattern != "") pattern else "\\d{6}"
                errorInfo = if (errorInfo != "") errorInfo else "Zip code error"
            }
            8 -> {
                // year
                pattern = if (pattern != "") pattern else "(19|20)[0-9]{2}"
                errorInfo = if (errorInfo != "") errorInfo else "Year error"
            }

            else -> errorInfo = if (errorInfo != "") errorInfo else "Eror"
        }
    }

    private fun errorDrawable(msg: String) {
        setCompoundDrawablesWithIntrinsicBounds(
            0,
            0,
            R.drawable.ic_info,
            0
        )
        error = errorInfo
    }

    override fun clear() {
        text?.clear()
        setCompoundDrawablesWithIntrinsicBounds(
            0,
            0,
            0,
            0
        )
    }

    override fun check(): Boolean {
        var isTrue = false
        if (text?.isEmpty() == true) {
            errorDrawable("line is empty!")
        } else {
            if (!isTrue()) {
                errorDrawable(errorInfo)
            } else {
                isTrue = true
                setTrue()
            }
            val pass1 = passwords[1]?.text?.toString() ?: ""
            val pass2 = passwords[2]?.text?.toString() ?: ""
            if (pass1 != "" && pass2 != "" && pass1 != pass2) {
                isTrue = false
                errorDrawable("Passwords not matched")
            }
        }
        return isTrue
    }

    private fun setTrue() {
        setCompoundDrawablesWithIntrinsicBounds(
            0,
            0,
            0,
            0
        )
        setCompoundDrawablesWithIntrinsicBounds(
            0,
            0,
            R.drawable.ic_checked,
            0
        )
    }

    private fun isTrue() =
        text?.toString()?.matches(pattern.toRegex()) ?: false

    override fun setPattern(reg: String?) {
        reg?.let {
            pattern = reg
        }
        initTypes()
    }

    override fun setErrorInfo(errorInfo: String?) {
        errorInfo?.let {
            this.errorInfo = errorInfo
        }
        initTypes()
    }
}