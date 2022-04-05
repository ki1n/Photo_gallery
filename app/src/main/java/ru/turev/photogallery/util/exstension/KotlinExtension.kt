package ru.turev.photogallery.util.exstension

data class Quadruple<out A, out B, out C, out D>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D
) {
    override fun toString(): String = "($first, $second, $third, $fourth)"
}

data class Quintuple<out A, out B, out C, out D, out E>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D,
    val fifth: E
) {
    override fun toString(): String = "($first, $second, $third, $fourth, $fifth)"
}

inline fun <reified T> Any?.unsafeCastTo(): T {
    return this as T
}

inline fun <reified T> Any?.castTo(): T? {
    return this as? T
}

val String.Companion.empty
    get() = ""

val String.Companion.space
    get() = " "

val String.Companion.dot
    get() = "."

fun invokeIf(predicate: () -> Boolean, block: () -> Unit) {
    if (predicate()) {
        block()
    }
}

fun invokeIfNot(predicate: () -> Boolean, block: () -> Unit) {
    if (!predicate()) {
        block()
    }
}

inline fun Any?.isNull(): Boolean {
    return this == null
}

inline fun Any?.isNotNull(): Boolean {
    return this != null
}
