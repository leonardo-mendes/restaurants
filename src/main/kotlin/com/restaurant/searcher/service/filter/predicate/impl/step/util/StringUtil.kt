package com.restaurant.searcher.service.filter.predicate.impl.step.util

import org.apache.commons.lang3.StringUtils

object StringUtil {

    fun sanitizeString(value: String): String {
        return StringUtils.stripAccents(value.trim()).toLowerCase();
    }
}