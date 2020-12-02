package com.cxsplay.drvd

import android.app.Application
import androidx.lifecycle.AndroidViewModel

/**
 * Created by CxS on 2020/12/02
 */

class MainVM(app: Application) : AndroidViewModel(app) {

    fun getGoodsTypeList(callback: MyCallback<MutableList<GoodsItemBean>>) {
        val data = mutableListOf(
            GoodsItemBean().apply { itemId = 0; typeName = "热销"; isSelect = true },
            GoodsItemBean().apply { itemId = 1; typeName = "优惠" },
            GoodsItemBean().apply { itemId = 2; typeName = "月月上新" },
            GoodsItemBean().apply { itemId = 3; typeName = "招牌鸡汤" },
            GoodsItemBean().apply { itemId = 4; typeName = "精品套餐" },
            GoodsItemBean().apply { itemId = 5; typeName = "人气推荐" },
            GoodsItemBean().apply { itemId = 6; typeName = "家常现炒" },
            GoodsItemBean().apply { itemId = 7; typeName = "下饭好菜" },
            GoodsItemBean().apply { itemId = 8; typeName = "健康蔬食" },
            GoodsItemBean().apply { itemId = 9; typeName = "主食【需单点】" },
            GoodsItemBean().apply { itemId = 10; typeName = "配餐小食" },
            GoodsItemBean().apply { itemId = 11; typeName = "缤纷饮料" },
            GoodsItemBean().apply { itemId = 12; typeName = "商品券核销" },
            GoodsItemBean().apply { itemId = 13; typeName = "荤菜类" },
            GoodsItemBean().apply { itemId = 14; typeName = "开口汤" },
            GoodsItemBean().apply { itemId = 15; typeName = "温馨提示" },
            GoodsItemBean().apply { itemId = 16; typeName = "折扣区" },
            GoodsItemBean().apply { itemId = 17; typeName = "正新超大派系列" },
            GoodsItemBean().apply { itemId = 18; typeName = "饮料" },
            GoodsItemBean().apply { itemId = 19; typeName = "餐具" },
            GoodsItemBean().apply { itemId = 20; typeName = "会员专享菜" },
            GoodsItemBean().apply { itemId = 21; typeName = "风味烧烤" },
            GoodsItemBean().apply { itemId = 22; typeName = "哈哈哈大" }
        )
        return callback.onSuccess(data)
    }

    fun getGoodsList(callback: MyCallback<MutableList<GoodsItemBean>>) {
        val data = mutableListOf(
            GoodsItemBean().apply { layerType = GoodsItemBean.TYPE_HEADER; itemId = 0; typeName = "热销" },
            GoodsItemBean().apply { itemId = 0; name = "新品~钵钵鸡条块" },
            GoodsItemBean().apply { itemId = 0; name = "梅菜扣肉"; },
            GoodsItemBean().apply { itemId = 0; name = "凤爪蒸鸡米"; },
            GoodsItemBean().apply { layerType = GoodsItemBean.TYPE_HEADER; itemId = 1; typeName = "优惠" },
            GoodsItemBean().apply { itemId = 1; name = "香辣鸡杂"; },
            GoodsItemBean().apply { layerType = GoodsItemBean.TYPE_HEADER; itemId = 2; typeName = "月月上新" },
            GoodsItemBean().apply { itemId = 2; name = "新品~钵钵鸡条块1"; },
            GoodsItemBean().apply { itemId = 2; name = "新品~钵钵鸡条块2"; },
            GoodsItemBean().apply { itemId = 2; name = "新品~钵钵鸡条块3"; },
            GoodsItemBean().apply { itemId = 2; name = "新品~钵钵鸡条块4"; },
            GoodsItemBean().apply { itemId = 2; name = "新品~钵钵鸡条块5"; },
            GoodsItemBean().apply { itemId = 2; name = "新品~钵钵鸡条块6"; },
            GoodsItemBean().apply { layerType = GoodsItemBean.TYPE_HEADER; itemId = 3; typeName = "招牌鸡汤" },
            GoodsItemBean().apply { itemId = 3; name = "招牌鸡汤"; },
            GoodsItemBean().apply { layerType = GoodsItemBean.TYPE_HEADER; itemId = 4; typeName = "精品套餐" },
            GoodsItemBean().apply { itemId = 4; name = "精品套餐精品套餐"; },
            GoodsItemBean().apply { itemId = 4; name = "精品套餐精品套餐"; },
            GoodsItemBean().apply { itemId = 4; name = "精品套餐精品套餐"; },
            GoodsItemBean().apply { itemId = 4; name = "精品套餐精品套餐"; },
            GoodsItemBean().apply { itemId = 4; name = "精品套餐精品套餐"; },
            GoodsItemBean().apply { itemId = 4; name = "精品套餐精品套餐"; },
            GoodsItemBean().apply { itemId = 4; name = "精品套餐精品套餐"; },
            GoodsItemBean().apply { itemId = 4; name = "精品套餐精品套餐"; },
            GoodsItemBean().apply { itemId = 4; name = "精品套餐精品套餐"; },
            GoodsItemBean().apply { layerType = GoodsItemBean.TYPE_HEADER; itemId = 5; typeName = "人气推荐" },
            GoodsItemBean().apply { itemId = 5; name = "人气推荐人气推荐"; },
            GoodsItemBean().apply { layerType = GoodsItemBean.TYPE_HEADER; itemId = 6; typeName = "家常现炒" },
            GoodsItemBean().apply { itemId = 6; name = "家常现炒家常现炒"; },
            GoodsItemBean().apply { layerType = GoodsItemBean.TYPE_HEADER; itemId = 7; typeName = "下饭好菜" },
            GoodsItemBean().apply { itemId = 7; name = "下饭好菜"; },
            GoodsItemBean().apply { layerType = GoodsItemBean.TYPE_HEADER; itemId = 8; typeName = "健康蔬食" },
            GoodsItemBean().apply { itemId = 8; name = "健康蔬食健康蔬食"; },
            GoodsItemBean().apply { itemId = 8; name = "健康蔬食健康蔬食"; },
            GoodsItemBean().apply { itemId = 8; name = "健康蔬食健康蔬食"; },
            GoodsItemBean().apply { itemId = 8; name = "健康蔬食健康蔬食"; },
            GoodsItemBean().apply { itemId = 8; name = "健康蔬食健康蔬食"; },
            GoodsItemBean().apply { layerType = GoodsItemBean.TYPE_HEADER; itemId = 9; typeName = "主食【需单点】" },
            GoodsItemBean().apply { itemId = 9; name = "主食1"; },
            GoodsItemBean().apply { itemId = 9; name = "主食2"; },
            GoodsItemBean().apply { layerType = GoodsItemBean.TYPE_HEADER; itemId = 10; typeName = "配餐小食" },
            GoodsItemBean().apply { itemId = 10; name = "配餐小食配餐小食"; },
            GoodsItemBean().apply { layerType = GoodsItemBean.TYPE_HEADER; itemId = 15; typeName = "温馨提示" },
            GoodsItemBean().apply { itemId = 15; name = "温馨提示~~~~"; },
            GoodsItemBean().apply { itemId = 15; name = "温馨提示~~~~"; },
            GoodsItemBean().apply { itemId = 15; name = "温馨提示~~~~"; },
            GoodsItemBean().apply { layerType = GoodsItemBean.TYPE_HEADER; itemId = 17; typeName = "正新超大派系列" },
            GoodsItemBean().apply { itemId = 17; name = "正新超大派系列~~~~"; },
            GoodsItemBean().apply { itemId = 17; name = "正新超大派系列~~~~"; },
            GoodsItemBean().apply { itemId = 17; name = "正新超大派系列~~~~"; },
            GoodsItemBean().apply { itemId = 17; name = "正新超大派系列~~~~"; },
            GoodsItemBean().apply { layerType = GoodsItemBean.TYPE_HEADER; itemId = 19; typeName = "餐具" },
            GoodsItemBean().apply { itemId = 19; name = "餐具餐具餐具餐具"; },
            GoodsItemBean().apply { itemId = 19; name = "餐具餐具餐具餐具"; },
            GoodsItemBean().apply { itemId = 19; name = "餐具餐具餐具餐具"; },
            GoodsItemBean().apply { layerType = GoodsItemBean.TYPE_HEADER; itemId = 20; typeName = "会员专享菜" },
            GoodsItemBean().apply { itemId = 20; name = "会员专享菜会员专享菜"; },
            GoodsItemBean().apply { itemId = 20; name = "会员专享菜会员专享菜"; },
            GoodsItemBean().apply { itemId = 20; name = "会员专享菜会员专享菜"; },
            GoodsItemBean().apply { itemId = 20; name = "会员专享菜会员专享菜"; },
            GoodsItemBean().apply { itemId = 20; name = "会员专享菜会员专享菜"; },
            GoodsItemBean().apply { itemId = 20; name = "会员专享菜会员专享菜"; },
            GoodsItemBean().apply { itemId = 20; name = "会员专享菜会员专享菜"; },
            GoodsItemBean().apply { layerType = GoodsItemBean.TYPE_HEADER; itemId = 21; typeName = "风味烧烤" },
            GoodsItemBean().apply { itemId = 20; name = "风味烧烤风味烧烤风味烧烤"; }
        )
        return callback.onSuccess(data)
    }
}