package com.cxsplay.drvd

/**
 * Created by CxS on 2020/12/02
 */

class GoodsItemBean {

    companion object {
        const val TYPE_BODY: Int = 0
        const val TYPE_HEADER: Int = 1
    }

    var layerType: Int = TYPE_BODY


    var isSelect: Boolean = false
    var itemId: Int = 0
    var name: String? = null
    var typeName: String? = null
    var coverImg: String? = null
}