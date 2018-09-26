package com.ustory.relax_business_component.plugin

import com.ustory.relax_business_component.plugin.inter.IPlugin


/**
 * Created by qiyue on 2018/2/1.
 */

interface IProxy {
    fun attach(pluginActivity: IPlugin)
}
