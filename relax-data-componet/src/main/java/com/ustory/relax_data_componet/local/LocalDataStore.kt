package com.hualala.mendianbao.v3.data.mendian.local

import com.hualala.mendianbao.v3.data.mendian.local.basedata.MenDianBaseDataRepository
import com.hualala.mendianbao.v3.data.mendian.local.order.MenDianOrderRepository
import com.hualala.mendianbao.v3.data.mendian.local.user.MenDianUserRepository

interface LocalDataStore {

    val mdUserRepository: MenDianUserRepository

    val mdBaseDataRepository: MenDianBaseDataRepository

    val mdOrderRepository: MenDianOrderRepository

}