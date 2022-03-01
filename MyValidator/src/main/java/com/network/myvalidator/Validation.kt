package com.network.myvalidator

object Validation {
    private val TAG = "Validation"

    fun addSpinner(spinner: SpinnerCustom, errorInfo: String? = null) {
        addToList(spinner, errorInfo = errorInfo)
    }

    fun addText(text: EditTextCustom, pattern: String? = null, errorInfo: String? = "Error") {
        addToList(text, pattern, errorInfo)
    }

    fun clear() {
        list.forEach {
            it.clear()
        }
        list.clear()
        passwords.clear()
    }

    fun check(): Boolean {
        var b = true
        list.forEach {
            val check = it.check()
            if (!check) {
                b = false
            }
        }
        return b
    }

    private fun addToList(
        view: ValidationImpl,
        pattern: String? = null,
        errorInfo: String? = null
    ) {
        view.setPattern(pattern)
        view.setErrorInfo(errorInfo)
        list.add(view)
    }

    var list = HashSet<ValidationImpl>()
    val passwords = HashMap<Int, EditTextCustom>()
}