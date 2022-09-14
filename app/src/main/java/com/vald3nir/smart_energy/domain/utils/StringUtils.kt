package com.vald3nir.smart_energy.domain.utils

fun String.parseEmailToKey() = this.replace("@", "_").replace(".", "_")