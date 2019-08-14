package com.ustory.relax_business_component.core.viewmodel.precondition

import android.content.Context

class Precondition {

    class Result(
            success: Boolean,
            cause: Throwable
    ) {
        var success: Boolean = success
            internal set

        var cause: Throwable = cause
            internal set

        fun throwIfError() {
            if (!success) {
                throw cause
            }
        }
    }

    open class ResultBuilder<out T>(
            protected val factory: (String) -> Throwable = ::PreconditionException
    ) {
        val result: Result = Result(true, PLACE_HOLDER_EXCEPTION)

        fun check(success: Boolean): T {
            if (result.success) {
                result.success = success
            }
            @Suppress("UNCHECKED_CAST")
            return this as T
        }

        fun <S> check(subject: S, predicate: (S) -> Boolean): T {
            if (result.success) {
                result.success = predicate(subject)
            }
            @Suppress("UNCHECKED_CAST")
            return this as T
        }

        fun <S1, S2> check(subject1: S1, subject2: S2, predicate: (S1, S2) -> Boolean): T {
            if (result.success) {
                result.success = predicate(subject1, subject2)
            }
            @Suppress("UNCHECKED_CAST")
            return this as T
        }

        fun check(predicate: () -> Boolean): T {
            if (result.success) {
                result.success = predicate()
            }
            @Suppress("UNCHECKED_CAST")
            return this as T
        }

        fun onFail(message: String): T {
            if (!result.success && result.cause is PlaceHolderException) {
                result.cause = factory(message)
            }
            @Suppress("UNCHECKED_CAST")
            return this as T
        }

        fun throwIfFail() {
            if (!result.success) {
                throw result.cause
            }
        }

        fun isSuccess(): Boolean = result.success

        fun validate(): Result = result

        companion object {
            @JvmStatic
            internal val PLACE_HOLDER_EXCEPTION: Exception = PlaceHolderException()
        }
    }

    class ContextResultBuilder(
            context: Context,
            factory: (String) -> Throwable
    ) : ResultBuilder<ContextResultBuilder>(factory) {
        private val context: Context = context.applicationContext

        fun onFail(messageResId: Int) : ContextResultBuilder {
            if (!result.success && result.cause is PlaceHolderException) {
                result.cause = factory(context.getString(messageResId))
            }
            return this
        }

        fun onFail(messageResIdBuilder: () -> Int) : ContextResultBuilder {
            if (!result.success && result.cause is PlaceHolderException) {
                result.cause = factory(context.getString(messageResIdBuilder()))
            }
            return this
        }

    }

    companion object {

        @JvmStatic
        fun with(context: Context, factory: (String) -> Throwable = ::PreconditionException):
                ContextResultBuilder = ContextResultBuilder(context, factory)

    }
}

infix fun Precondition.Result.and(another: () -> Precondition.Result): Precondition.Result =
        if (!this.success) this else another()

class PlaceHolderException : RuntimeException("Place holder exception")
