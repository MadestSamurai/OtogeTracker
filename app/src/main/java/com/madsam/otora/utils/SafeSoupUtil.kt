package com.madsam.otora.utils

import org.jsoup.nodes.Element
import org.jsoup.select.Elements

object SafeSoupUtil {
    fun Elements?.safeFirstText(default: String = ""): String {
        return this?.first()?.text() ?: default
    }

    fun Element?.safePreviousElementSibling(default: Element = Element("null")): Element {
        return this?.previousElementSibling() ?: default
    }

    fun Elements?.safeFirstAttr(attrName: String, default: String = ""): String {
        return this?.first()?.attr(attrName) ?: default
    }
}