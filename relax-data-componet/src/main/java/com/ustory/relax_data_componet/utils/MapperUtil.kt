package com.ustory.relax_data_componet.utils

import android.annotation.SuppressLint
import android.text.TextUtils
import com.mvvm.utils.JsonUtil
import timber.log.Timber
import java.math.BigDecimal
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

fun Int.toBoolean(): Boolean = this != 0

fun Boolean.toInt(): Int = if (this) 1 else 0

fun String?.toBoolean(): Boolean =
        this != null && (this == "1" || this == "true" || this == "True")

fun String?.toDecimal(): BigDecimal =
        if (!TextUtils.isEmpty(this)) BigDecimal(this)
        else BigDecimal.ZERO

fun String?.toDecimal(default: BigDecimal): BigDecimal {
    try {
        return this.toDecimal()
    } catch (e: NumberFormatException) {
        Timber.e("toDecimal(): Failed to format string = $this, using default = $default")
    }
    return default
}

fun String?.toNonNullString() = this ?: ""

fun Int?.toNonNullInt(): Int = this ?: 0

fun String?.toNonNullInt(): Int = this?.toInt() ?: 0

fun String?.toNonNullLong(): Long = this?.toLong() ?: 0

fun <T, R> List<T>?.mapNonNull(transform: (T) -> R): List<R> =
        this?.map(transform) ?: emptyList()

fun BigDecimal.removeTrailingZeros(): String {
        return if (this.compareTo(BigDecimal.ZERO) == 0) {  // 在 BigDecimal.ZERO 上调用 stripTrailingZeros() 无效
                "0"
        } else {
                this.stripTrailingZeros().toPlainString()
        }
}

fun BigDecimal.removeZero(): String {
    return if (this.compareTo(BigDecimal.ZERO) == 0) {  // 在 BigDecimal.ZERO 上调用 stripTrailingZeros() 无效
        ""
    } else {
        this.stripTrailingZeros().toPlainString()
    }
}

fun BigDecimal.toRecordFormat(): String = this.toPlainString()

fun Boolean.formatString(): String = if (this) "1" else "0"

fun Any.toJson(): String = JsonUtil.toJson(this)

@SuppressLint("SimpleDateFormat")
fun buildOrderTimeFormatter(): SimpleDateFormat = SimpleDateFormat("yyyyMMddHHmmss")

@SuppressLint("SimpleDateFormat")
fun buildChannelOrderTimeFormatter(): SimpleDateFormat = SimpleDateFormat("yyyyMMddHHmm")

@SuppressLint("SimpleDateFormat")
fun buildOrderDateFormatter(): SimpleDateFormat = SimpleDateFormat("yyyyMMdd")

fun String?.parseOrderTime(formatter: DateFormat = buildOrderTimeFormatter()): Date? =
        if (this != null && this.isNotEmpty() && this != "0") formatter.parse(this) else null

fun Date?.formatOrderTime(formatter: DateFormat = buildOrderTimeFormatter()): String =
        if (this != null) formatter.format(this) else "0"

fun String?.parseOrderDate(formatter: DateFormat = buildOrderDateFormatter()): Date? =
        if (this != null && this.isNotEmpty() && this != "0") formatter.parse(this) else null

fun Date?.formatOrderDate(formatter: DateFormat = buildOrderDateFormatter()): String =
        if (this != null) formatter.format(this) else "0"
