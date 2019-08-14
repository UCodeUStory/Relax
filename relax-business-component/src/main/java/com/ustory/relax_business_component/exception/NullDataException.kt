package com.ustory.relax_business_component.exception

import kotlin.reflect.KClass

class NullDataException(
        val srcClass: KClass<*>? = null
) : RuntimeException(srcClass.toString() + " is null")
