package com.makor.compoundviewexample

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.consents_view.view.*

class ConsentsView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    var onCheckedChangeListener: OnConsentsCheckedChangeListener? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.consents_view, this, true)

        consent1.setOnCheckedChangeListener { _, _ -> validateConsents() }
        consent2.setOnCheckedChangeListener { _, _ -> validateConsents() }
    }

    private fun validateConsents() {
        onCheckedChangeListener?.onCheckedChange(consent1.isChecked && consent2.isChecked)
    }
}

interface OnConsentsCheckedChangeListener {
    fun onCheckedChange(allConsentsChecked: Boolean)
}