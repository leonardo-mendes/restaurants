package com.restaurant.searcher.service.filter.util

import org.apache.commons.lang3.StringUtils

class StringUtil {

    companion object {

        fun sanitizeString(value: String): String {
            return StringUtils.stripAccents(value.trim()).toLowerCase();
        }
    }
}