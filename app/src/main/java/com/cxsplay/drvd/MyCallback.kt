package com.cxsplay.drvd

/**
 * Created by CxS on 202012/02
 */

abstract class MyCallback<T> {

    open fun onPre() {}

    abstract fun onSuccess(data: T)

    open fun cancelled() {}

    abstract fun onFailed(code: Int, msg: String?)

    open fun onFinished() {

    }
}
