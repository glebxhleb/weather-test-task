package com.shuster.testapp.presentation.utils

import java.math.BigDecimal
import java.math.MathContext

fun BigDecimal.toStringWithSign() =
    if (this < BigDecimal.ZERO) {
        round(MathContext(1)).toString()
    } else {
        "+${toString()}"
    }