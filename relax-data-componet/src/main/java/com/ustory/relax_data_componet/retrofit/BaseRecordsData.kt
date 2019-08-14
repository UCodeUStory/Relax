package com.ustory.relax_data_componet.retrofit

open class BaseRecordsData<out T>(
        val records: List<T>? = null,
        val version: String? = null
)
