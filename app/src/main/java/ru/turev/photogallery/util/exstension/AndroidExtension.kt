package ru.turev.photogallery.util.exstension

import android.content.Context
import android.content.res.Resources
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder

val Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

val Float.dp: Float
    get() = this * Resources.getSystem().displayMetrics.density + 0.5f

val Double.dp: Double
    get() = this * Resources.getSystem().displayMetrics.density + 0.5f

val Int.sp: Int
    get() = (this * Resources.getSystem().displayMetrics.scaledDensity).toInt()

fun materialAlertDialogOf(
    context: Context,
    overrideThemeResId: Int = 0,
    block: MaterialAlertDialogBuilder.() -> Unit
): AlertDialog {
    return MaterialAlertDialogBuilder(context, overrideThemeResId).apply(block).create()
}

fun AlertDialog.dismissOnDestroy(lifecycleOwner: LifecycleOwner): AlertDialog {
    return lifecycleOwner
        .doOnDestroy { dismiss() }
        .let { this }
}

fun LifecycleOwner.doOnDestroy(block: () -> Unit) {
    lifecycle.addObserver(object : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun onDestroy() {
            block()
        }
    })
}

fun RecyclerView.addItemDecorations(vararg decorations: RecyclerView.ItemDecoration) {
    while (itemDecorationCount > 0) {
        removeItemDecorationAt(0)
    }
    decorations.forEach(::addItemDecoration)
}
