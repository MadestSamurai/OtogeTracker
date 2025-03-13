package com.madsam.otora.core.utils

import org.jsoup.nodes.Element
import org.jsoup.select.Elements

object SafeSoupUtil {
    fun Elements?.safeFirst(): Element {
        return this?.first() ?: Element("null")
    }

    fun Elements?.safeFirstText(default: String = ""): String {
        return this?.first()?.text() ?: default
    }

    fun Element?.safeAttr(attrName: String, default: String = ""): String {
        return this?.attr(attrName) ?: default
    }

    fun Elements?.safeFirstAttr(attrName: String, default: String = ""): String {
        return this?.first()?.attr(attrName) ?: default
    }

    fun Element?.safePreviousElementSibling(default: Element = Element("null")): Element {
        return this?.previousElementSibling() ?: default
    }

    fun Element?.safeText(default: String = ""): String {
        return this?.text() ?: default
    }

    fun Element?.safeSelect(query: String): Elements {
        return this?.select(query) ?: Elements()
    }

    fun Elements?.safeFind(predicate: (Element) -> Boolean): Element {
        return this?.find(predicate) ?: Element("null")
    }
    
    fun Elements?.safeJoinToString(
        separator: String = "",
        transform: (Element) -> String
    ): String {
        return this?.joinToString(separator, transform = transform) ?: ""
    }

    fun Element?.safeSelectFirst(query: String): Element {
        return this?.selectFirst(query) ?: Element("null")
    }
}