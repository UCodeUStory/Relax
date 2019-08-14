package com.ustory.relax_business_component.core


import com.ustory.relax_business_component.businesscase.login.model.UserModel

class BasicData {

    lateinit var user: UserModel

    val isInitialized: Boolean
        get() = ::user.isInitialized
}
