package ru.turev.photogallery.util.exstension

import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.core.widget.ImageViewCompat

private const val DEBOUNCE: Long = 300L
private var isClickEnabled: Boolean = true
private val enable: () -> Unit = { isClickEnabled = true }

/**
 * Клик-листенер, предотвращающий многократные быстрые клики.
 * После удачного клика, другие клики не срабатывают в течение 300мс
 */
fun View.setOnDebouncedClickListener(action: () -> Unit) {
    this.setOnClickListener { v ->
        if (isClickEnabled) {
            isClickEnabled = false
            v.postDelayed(enable, DEBOUNCE)
            action.invoke()
        }
    }
}

fun View.clicks(isNeedDebounce: Boolean = false, action: () -> Unit) {
    addSelectableItemBackground()
    if (isNeedDebounce) {
        setOnDebouncedClickListener(action)
    } else {
        this.setOnClickListener {
            action.invoke()
        }
    }
}

private fun View.addSelectableItemBackground() {
    if (this is ImageView) return
    if (this is ImageViewCompat) return

    val outValue = TypedValue()
    context.theme.resolveAttribute(android.R.attr.selectableItemBackground, outValue, true)
    this.rootView.foreground = context.getDrawable(outValue.resourceId)
}

fun View.layoutInflater(): LayoutInflater = LayoutInflater.from(context)
