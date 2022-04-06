package ru.turev.photogallery.util.exstension

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.SingleSource

fun <T> T.toSingle(): Single<T> {
    return Single.just(this)
}

fun <T> T.toObservable(): Observable<T> {
    return Observable.just(this)
}

fun <T1, T2> combineSingle(
    single1: SingleSource<T1>,
    single2: SingleSource<T2>
): Single<Pair<T1, T2>> =
    Single.zip(
        single1,
        single2,
        { t1, t2 -> t1 to t2 }
    )

fun <T1, T2, T3, T4> combineSingle(
    single1: SingleSource<T1>,
    single2: SingleSource<T2>,
    single3: SingleSource<T3>,
    single4: SingleSource<T4>
): Single<Quadruple<T1, T2, T3, T4>> {
    return Single.zip(
        single1,
        single2,
        single3,
        single4,
        { t1, t2, t3, t4 -> Quadruple(t1, t2, t3, t4) })
}

