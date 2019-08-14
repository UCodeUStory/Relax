package com.ustory.relax_business_component.core.viewmodel;

class CreateViewModelFailedException(
        message: String,
        cause: Throwable
        ) : RuntimeException(message, cause)
