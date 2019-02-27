package com.makor.compoundviewexample

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.consents_view.view.*

class ConsentsView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    var onConsentsCheckedChangeListener: (allConsentsChecked: Boolean) -> Unit = {}

    init {
        LayoutInflater.from(context).inflate(R.layout.consents_view, this, true)

        orientation = LinearLayout.VERTICAL
        gravity = Gravity.CENTER

        consent1.setOnCheckedChangeListener { _, _ -> validateConsents() }
        consent2.setOnCheckedChangeListener { _, _ -> validateConsents() }
    }

    private fun validateConsents() {
        onConsentsCheckedChangeListener.invoke(consent1.isChecked && consent2.isChecked)
    }
}