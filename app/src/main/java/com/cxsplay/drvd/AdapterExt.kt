package com.cxsplay.drvd

import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * Created by CxS on 2019/6/17 10:01.
 * Description: 针对 BaseRecyclerViewAdapterHelper BaseQuickAdapter 的一些扩展。
 */

var itemClickable: Boolean = true

/**
 * 设置点击监听, 并自定义防抖时间
 */
fun <T : BaseQuickAdapter<*, *>> T.itemClick(time: Long = 300, action: (adapter: BaseQuickAdapter<*, *>, v: View, p: Int) -> Unit) {
    setOnItemClickListener { adapter, v, p ->
        if (itemClickable) {
            itemClickable = false
            action(adapter, v, p)
            v.postDelayed({ itemClickable = true }, time)
        }
    }
}

/**
 * 设置点击监听, 并自定义防抖时间
 */
fun <T : BaseQuickAdapter<*, BaseViewHolder>> T.itemChildClick(
    time: Long = 300,
    action: (adapter: BaseQuickAdapter<*, BaseViewHolder>, v: View, p: Int) -> Unit
) {
    setOnItemChildClickListener { adapter, v, p ->
        if (itemClickable) {
            itemClickable = false
            action(adapter, v, p)
            v.postDelayed({ itemClickable = true }, time)
        }
    }
}