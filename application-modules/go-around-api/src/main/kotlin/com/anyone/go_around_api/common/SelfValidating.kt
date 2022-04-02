package com.anyone.go_around_api.common

import javax.validation.ConstraintViolationException
import javax.validation.Validation
import javax.validation.Validator

abstract class SelfValidating<T> {
    private var validator: Validator? = null

    open fun SelfValidating() {
        val factory = Validation.buildDefaultValidatorFactory()
        validator = factory.validator
    }

    protected open fun validateSelf() {
        val violations = validator!!.validate(this as T)
        if (!violations.isEmpty()) {
            throw ConstraintViolationException(violations)
        }
    }
}