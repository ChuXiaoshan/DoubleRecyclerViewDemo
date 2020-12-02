package com.cxsplay.drvd.adapter

import com.chad.library.adapter.base.BaseDelegateMultiAdapter
import com.chad.library.adapter.base.delegate.BaseMultiTypeDelegate
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.cxsplay.drvd.GoodsItemBean
import com.cxsplay.drvd.R

/**
 * Created by CxS on 2020/12/02
 */

class GoodsAdapter(layoutResId: Int, data: MutableList<GoodsItemBean>) : BaseDelegateMultiAdapter<GoodsItemBean, BaseViewHolder>() {

    init {
        setMultiTypeDelegate(object : BaseMultiTypeDelegate<GoodsItemBean>() {
            override fun getItemType(data: List<GoodsItemBean>, position: Int) = data[position].layerType

        })

        getMultiTypeDelegate()?.addItemType(GoodsItemBean.TYPE_HEADER, R.layout.item_goods_manager_header)
        getMultiTypeDelegate()?.addItemType(GoodsItemBean.TYPE_BODY, R.layout.item_goods_manager)
    }

    override fun convert(holder: BaseViewHolder, item: GoodsItemBean) {
        when (holder.itemViewType) {
            GoodsItemBean.TYPE_BODY -> {
                holder.setText(R.id.tv_title, item.name)
            }
            GoodsItemBean.TYPE_HEADER -> holder.setText(R.id.tv, item.typeName)
        }
    }
}