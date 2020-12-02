package com.cxsplay.drvd

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cxsplay.drvd.adapter.GoodsAdapter
import com.cxsplay.drvd.adapter.GoodsTypeAdapter
import com.cxsplay.drvd.databinding.ActivityMainBinding
import com.cxsplay.drvd.stickyheader.OnStickyChangeListener
import com.cxsplay.drvd.stickyheader.StickyItemDecoration

class MainActivity : AppCompatActivity() {

    private var prePositionLeft = 0
    private lateinit var model: MainVM
    private lateinit var bind: ActivityMainBinding

    private val adapterRight by lazy { GoodsAdapter(R.layout.item_goods_manager, mutableListOf()) }
    private val adapterLeft by lazy { GoodsTypeAdapter(R.layout.item_goods_manager_type, mutableListOf()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this, R.layout.activity_main)
        model = ViewModelProvider(this).get(MainVM::class.java)
        init()
    }

    private fun init() {
        val leftLayoutManager = LinearLayoutManager(this)
        val rightLayoutManager = LinearLayoutManager(this)
        bind.rvLeft.layoutManager = leftLayoutManager
        bind.rvRight.layoutManager = rightLayoutManager
        bind.rvLeft.adapter = adapterLeft
        bind.rvRight.adapter = adapterRight

        adapterLeft.itemClick { _, _, p ->
            if (prePositionLeft != p) {
                val selectedItem = adapterLeft.data[p]
                val index = adapterRight.data.indexOfFirst { it.itemId == selectedItem.itemId }
                if (index != -1 && index <= adapterRight.data.size - 1) {
                    rightLayoutManager.scrollToPositionWithOffset(index, 0)
                    selectedItem.isSelect = true
                    adapterLeft.data[prePositionLeft].isSelect = false
                    adapterLeft.notifyDataSetChanged()
                    prePositionLeft = p
                }
            }
        }

        bind.rvRight.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            var preFirstPosition = 0
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val firstVisiblePosition = rightLayoutManager.findFirstVisibleItemPosition()
                if (preFirstPosition != firstVisiblePosition) {
                    if (prePositionLeft != firstVisiblePosition) {
                        val selectedItem = adapterRight.data[firstVisiblePosition]
                        val index = adapterLeft.data.indexOfFirst { it.itemId == selectedItem.itemId }
                        if (index != -1 && prePositionLeft != index) {
                            bind.rvLeft.scrollToPosition(index)
                            adapterLeft.data[index].isSelect = true
                            adapterLeft.data[prePositionLeft].isSelect = false
                            adapterLeft.notifyDataSetChanged()
                            prePositionLeft = index
                        }
                    }
                    preFirstPosition = firstVisiblePosition
                }
            }
        })

        getGoodsType()
        getGoods()
        initSHC()
    }

    private fun initSHC() {
        val stickyItemDecoration = StickyItemDecoration(bind.shc, GoodsItemBean.TYPE_HEADER)
        stickyItemDecoration.setOnStickyChangeListener(object : OnStickyChangeListener {
            override fun onScrollable(offset: Int) {
                bind.shc.scrollChild(offset)
                if (!adapterRight.data.isNullOrEmpty()) bind.shc.visibility = View.VISIBLE
            }

            override fun onInVisible() {
                bind.shc.reset()
                bind.shc.visibility = View.INVISIBLE
            }
        })
        bind.shc.setDataCallback { p ->
            if (!adapterRight.data.isNullOrEmpty() && adapterRight.data.size - 1 >= p) {
                updateData(adapterRight.data[p])
            }
        }
        bind.rvRight.addItemDecoration(stickyItemDecoration)
    }

    @SuppressLint("SetTextI18n")
    private fun updateData(item: GoodsItemBean) {
        bind.tvHeader.text = item.typeName
    }

    private fun getGoodsType() {
        model.getGoodsTypeList(object : MyCallback<MutableList<GoodsItemBean>>() {

            override fun onSuccess(data: MutableList<GoodsItemBean>) {
                adapterLeft.setNewInstance(data)
            }

            override fun onFailed(code: Int, msg: String?) {
            }
        })
    }

    private fun getGoods() {
        model.getGoodsList(object : MyCallback<MutableList<GoodsItemBean>>() {

            override fun onSuccess(data: MutableList<GoodsItemBean>) {
                adapterRight.setNewInstance(data)
            }

            override fun onFailed(code: Int, msg: String?) {
            }
        })
    }
}