package com.example.tiketuxfarouq.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.ImageView
import androidx.core.widget.addTextChangedListener
import com.example.tiketuxfarouq.R
import com.example.tiketuxfarouq.databinding.ViewSearchBinding
import com.example.tiketuxfarouq.extension.setOnSearchListener
import com.google.android.material.card.MaterialCardView
import kotlinx.coroutines.*

class CustomSearchView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = R.attr.SearchTheme
) : MaterialCardView(context, attrs, defStyleAttr) {
    private var textChangeListener: (text: String) -> Unit = {}

    private var textChangeDebounceListener: (text: String) -> Unit = {}
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    private var job: Job? = null
    var debounceDelay = 1000L
    private var textSubmitListener: (text: String) -> Unit = {}

    private var binding: ViewSearchBinding = ViewSearchBinding.inflate(
        LayoutInflater.from(context), this
    )
    val iconStart: ImageView
    val inputSearch: EditText

    init {
        setAddStatesFromChildren(true)

        iconStart = binding.iconStart
        inputSearch = binding.inputSearch

        inputSearch.addTextChangedListener {
            textChangeListener(it.toString())

            job?.cancel()
            job = coroutineScope.launch {
                delay(debounceDelay)
                textChangeDebounceListener(it.toString())
            }
        }

        inputSearch.setOnSearchListener {
            textSubmitListener(inputSearch.text.toString())
        }

    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()

        job?.cancel()
    }

    fun setChangeListener(listener: (text: String) -> Unit) {
        textChangeListener = listener
    }

    fun setSubmitListener(listener: (text: String) -> Unit) {
        textSubmitListener = listener
    }

    fun setChangeDebounceListener(listener: (text: String) -> Unit) {
        textChangeDebounceListener = listener
    }

    fun setQueryHint(s: String) {
        inputSearch.hint = s
    }

    fun setIconStart(resId: Int, tintColor: Int? = null) {
        iconStart.setImageResource(resId)
        if (tintColor != null) {
            iconStart.setColorFilter(tintColor)
        } else {
            iconStart.clearColorFilter()
        }
    }

    fun setIconStartClickListener(listener: OnClickListener) {
        binding.iconStartLayout.setOnClickListener(listener)
    }
}