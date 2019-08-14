package com.ustory.relax_business_component.core.viewmodel.precondition

class PreconditionException(
        message: String,
        val level: Level = Level.INFO
) : RuntimeException(message) {

    constructor(message: String): this(message, Level.INFO)

    enum class Level {
        INFO, WARNING, ERROR;
    }

    @Suppress("unused")
    companion object Builder {
        @JvmStatic
        fun forInfo(message: String): PreconditionException =
                PreconditionException(message, Level.INFO)
        @JvmStatic
        fun forWarning(message: String): PreconditionException =
                PreconditionException(message, Level.WARNING)
        @JvmStatic
        fun forError(message: String): PreconditionException =
                PreconditionException(message, Level.ERROR)
    }
}
