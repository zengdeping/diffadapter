package com.silencedut.diffadapterdemo.adapter

import com.silencedut.core.provider.legend.pojo.LegendSkin
import com.silencedut.diffadapter.data.BaseMutableData
import com.silencedut.diffadapterdemo.R

/**
 * @author SilenceDut
 * @date 2018/12/5
 */
class SkinViewData(var id: Long, var legendIcon:String?,var legendSkin: LegendSkin?) : BaseMutableData<SkinViewData>() {

    companion object {
         const val VIEW_ID = R.layout.holder_skins
    }

    override fun getItemViewId(): Int {
        return VIEW_ID
    }


    //可以用来添加更多的匹配规则,默认以uniqueItemFeature作为匹配规则，默认是uniqueItemFeature()
    override fun appendMatchFeature(allMatchFeatures: MutableSet<Any>) {
        super.appendMatchFeature(allMatchFeatures)
        legendIcon?.let { allMatchFeatures.add(it) }

    }

    override fun areUISame(newData: SkinViewData): Boolean {
        return this.legendIcon == newData.legendIcon && this.legendSkin?.equals(newData.legendSkin)?:false
    }

    override fun uniqueItemFeature(): Any {
        return this.id
    }


}