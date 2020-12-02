package com.cxsplay.drvd.adapter

import android.view.View
import androidx.core.content.ContextCompat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.cxsplay.drvd.GoodsItemBean
import com.cxsplay.drvd.R

/**
 * Created by CxS on 2020/12/02
 */

class GoodsTypeAdapter(layoutResId: Int, data: MutableList<GoodsItemBean>) : BaseQuickAdapter<GoodsItemBean, BaseViewHolder>(layoutResId, data) {

    override fun convert(holder: BaseViewHolder, item: GoodsItemBean) {
        holder.setText(R.id.tv, item.typeName)
        holder.setBackgroundColor(
            R.id.cl_content, ContextCompat.getColor(
                holder.getView<View>(R.id.tv).context,
                if (item.isSelect) R.color.white else R.color.grey300
            )
        )
    }
}