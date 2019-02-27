package com.makor.compoundviewexample

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
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

        context.theme.obtainStyledAttributes(attrs, R.styleable.ConsentsView, 0, 0).apply {
            val separatorVisible = getBoolean(R.styleable.ConsentsView_separatorVisibility, true)
            consentsSeparator.visibility = if (separatorVisible) View.VISIBLE else View.GONE
            recycle()
        }
    }

    private fun validateConsents() {
        onConsentsCheckedChangeListener.invoke(consent1.isChecked && consent2.isChecked)
    }
}