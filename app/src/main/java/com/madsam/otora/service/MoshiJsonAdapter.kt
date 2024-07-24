package com.madsam.otora.service

import com.madsam.otora.entity.web.OsuCard
import com.madsam.otora.entity.web.OsuGroup
import com.madsam.otora.entity.web.OsuMedalItem
import com.madsam.otora.entity.web.OsuStatistics
import com.madsam.otora.entity.web.OsuUserExtend
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.lang.reflect.Type
import java.util.Locale

class NullToDefaultStringAdapter {
    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): String {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<String>()
            ""
        } else {
            reader.nextString()
        }
    }
}

class NullToDefaultIntAdapter {
    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): Int {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<Int>()
            0
        } else {
            reader.nextInt()
        }
    }
}

class NullToDefaultLongAdapter {
    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): Long {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<Long>()
            0
        } else {
            reader.nextLong()
        }
    }
}

class NullToDefaultDoubleAdapter {
    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): Double {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<Double>()
            0.0
        } else {
            reader.nextDouble()
        }
    }
}

class NullToDefaultBooleanAdapter {
    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): Boolean {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<Boolean>()
            false
        } else {
            reader.nextBoolean()
        }
    }
}

class NullToDefaultActiveTournamentBannerAdapter {
    private val moshi: Moshi = Moshi.Builder()
        .add(NullToDefaultStringAdapter())
        .add(NullToDefaultLongAdapter())
        .add(CamelCaseJsonAdapterFactory())
        .addLast(KotlinJsonAdapterFactory())
        .build()
    private val activeTournamentBannerAdapter: JsonAdapter<OsuUserExtend.ActiveTournamentBanner> = moshi.adapter(OsuUserExtend.ActiveTournamentBanner::class.java)

    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): OsuUserExtend.ActiveTournamentBanner {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<OsuUserExtend.ActiveTournamentBanner>()
            OsuUserExtend.ActiveTournamentBanner()
        } else {
            activeTournamentBannerAdapter.fromJson(reader) ?: OsuUserExtend.ActiveTournamentBanner()
        }
    }
}

class NullToDefaultCountryAdapter {
    private val moshi: Moshi = Moshi.Builder()
        .add(NullToDefaultStringAdapter())
        .add(CamelCaseJsonAdapterFactory())
        .addLast(KotlinJsonAdapterFactory())
        .build()
    private val countryAdapter: JsonAdapter<OsuCard.Country> = moshi.adapter(OsuCard.Country::class.java)

    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): OsuCard.Country {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<OsuCard.Country>()
            OsuCard.Country()
        } else {
            countryAdapter.fromJson(reader) ?: OsuCard.Country()
        }
    }
}

class NullToDefaultCountryExtendAdapter {
    private val moshi: Moshi = Moshi.Builder()
        .add(NullToDefaultStringAdapter())
        .add(CamelCaseJsonAdapterFactory())
        .addLast(KotlinJsonAdapterFactory())
        .build()
    private val countryAdapter: JsonAdapter<OsuUserExtend.Country> = moshi.adapter(OsuUserExtend.Country::class.java)

    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): OsuUserExtend.Country {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<OsuUserExtend.Country>()
            OsuUserExtend.Country()
        } else {
            countryAdapter.fromJson(reader) ?: OsuUserExtend.Country()
        }
    }
}

class NullToEmptyStringListAdapter {
    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): List<String> {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<List<String>>()
            emptyList()
        } else {
            val list = mutableListOf<String>()
            reader.beginArray()
            while (reader.hasNext()) {
                list.add(reader.nextString())
            }
            reader.endArray()
            list
        }
    }
}

class NullToEmptyIntListAdapter {
    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): List<Int> {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<List<Int>>()
            emptyList()
        } else {
            val list = mutableListOf<Int>()
            reader.beginArray()
            while (reader.hasNext()) {
                list.add(reader.nextInt())
            }
            reader.endArray()
            list
        }
    }
}

class NullToDefaultGroupListAdapter {
    private val moshi: Moshi = Moshi.Builder()
        .add(NullToDefaultStringAdapter())
        .add(NullToDefaultBooleanAdapter())
        .add(NullToDefaultIntAdapter())
        .add(NullToEmptyStringListAdapter())
        .add(CamelCaseJsonAdapterFactory())
        .addLast(KotlinJsonAdapterFactory())
        .build()
    private val osuGroupAdapter: JsonAdapter<OsuGroup> = moshi.adapter(OsuGroup::class.java)

    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): List<OsuGroup> {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<List<OsuGroup>>()
            emptyList()
        } else {
            val list = mutableListOf<OsuGroup>()
            reader.beginArray()
            while (reader.hasNext()) {
                val osuGroup = osuGroupAdapter.fromJson(reader)
                if (osuGroup != null) {
                    list.add(osuGroup)
                }
            }
            reader.endArray()
            list
        }
    }
}

class NullToDefaultMedalItemListAdapter {
    private val moshi: Moshi = Moshi.Builder()
        .add(NullToDefaultStringAdapter())
        .add(NullToDefaultLongAdapter())
        .add(CamelCaseJsonAdapterFactory())
        .addLast(KotlinJsonAdapterFactory())
        .build()
    private val osuMedalItemAdapter: JsonAdapter<OsuMedalItem> = moshi.adapter(OsuMedalItem::class.java)

    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): List<OsuMedalItem> {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<List<OsuMedalItem>>()
            emptyList()
        } else {
            val list = mutableListOf<OsuMedalItem>()
            reader.beginArray()
            while (reader.hasNext()) {
                val osuMedalItem = osuMedalItemAdapter.fromJson(reader)
                if (osuMedalItem != null) {
                    list.add(osuMedalItem)
                }
            }
            reader.endArray()
            list
        }
    }
}

class NullToDefaultActiveTournamentBannerListAdapter {
    private val moshi: Moshi = Moshi.Builder()
        .add(NullToDefaultStringAdapter())
        .add(NullToDefaultLongAdapter())
        .add(CamelCaseJsonAdapterFactory())
        .addLast(KotlinJsonAdapterFactory())
        .build()
    private val activeTournamentBannerAdapter: JsonAdapter<OsuUserExtend.ActiveTournamentBanner> = moshi.adapter(OsuUserExtend.ActiveTournamentBanner::class.java)

    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): List<OsuUserExtend.ActiveTournamentBanner> {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<List<OsuUserExtend.ActiveTournamentBanner>>()
            emptyList()
        } else {
            val list = mutableListOf<OsuUserExtend.ActiveTournamentBanner>()
            reader.beginArray()
            while (reader.hasNext()) {
                val activeTournamentBanner = activeTournamentBannerAdapter.fromJson(reader)
                if (activeTournamentBanner != null) {
                    list.add(activeTournamentBanner)
                }
            }
            reader.endArray()
            list
        }
    }
}

class NullToDefaultBadgeListAdapter {
    private val moshi: Moshi = Moshi.Builder()
        .add(NullToDefaultStringAdapter())
        .add(CamelCaseJsonAdapterFactory())
        .addLast(KotlinJsonAdapterFactory())
        .build()
    private val badgeAdapter: JsonAdapter<OsuUserExtend.Badge> = moshi.adapter(OsuUserExtend.Badge::class.java)

    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): List<OsuUserExtend.Badge> {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<List<OsuUserExtend.Badge>>()
            emptyList()
        } else {
            val list = mutableListOf<OsuUserExtend.Badge>()
            reader.beginArray()
            while (reader.hasNext()) {
                val badge = badgeAdapter.fromJson(reader)
                if (badge != null) {
                    list.add(badge)
                }
            }
            reader.endArray()
            list
        }
    }
}

class NullToDefaultVariantListAdapter {
    private val moshi: Moshi = Moshi.Builder()
        .add(NullToDefaultStringAdapter())
        .add(NullToDefaultIntAdapter())
        .add(NullToDefaultDoubleAdapter())
        .add(CamelCaseJsonAdapterFactory())
        .addLast(KotlinJsonAdapterFactory())
        .build()
    private val variantAdapter: JsonAdapter<OsuStatistics.Variant> = moshi.adapter(OsuStatistics.Variant::class.java)

    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): List<OsuStatistics.Variant> {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<List<OsuStatistics.Variant>>()
            emptyList()
        } else {
            val list = mutableListOf<OsuStatistics.Variant>()
            reader.beginArray()
            while (reader.hasNext()) {
                val variant = variantAdapter.fromJson(reader)
                if (variant != null) {
                    list.add(variant)
                }
            }
            reader.endArray()
            list
        }
    }
}

class NullToDefaultUserAchievementListAdapter {
    private val moshi: Moshi = Moshi.Builder()
        .add(NullToDefaultStringAdapter())
        .add(CamelCaseJsonAdapterFactory())
        .addLast(KotlinJsonAdapterFactory())
        .build()
    private val userAchievementAdapter: JsonAdapter<OsuUserExtend.UserAchievement> = moshi.adapter(OsuUserExtend.UserAchievement::class.java)

    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): List<OsuUserExtend.UserAchievement> {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<List<OsuUserExtend.UserAchievement>>()
            emptyList()
        } else {
            val list = mutableListOf<OsuUserExtend.UserAchievement>()
            reader.beginArray()
            while (reader.hasNext()) {
                val userAchievement = userAchievementAdapter.fromJson(reader)
                if (userAchievement != null) {
                    list.add(userAchievement)
                }
            }
            reader.endArray()
            list
        }
    }

}

class CamelCaseJsonAdapterFactory : JsonAdapter.Factory {
    override fun create(
        type: Type,
        annotations: MutableSet<out Annotation>,
        moshi: Moshi
    ): JsonAdapter<*> {
        val delegate = moshi.nextAdapter<Any>(this, type, annotations)
        return object : JsonAdapter<Any>() {
            override fun fromJson(reader: JsonReader): Any? {
                val jsonValue = reader.readJsonValue()
                val map = jsonValue as? Map<*, *>
                val camelCasedMap = map?.mapKeys { entry ->
                    camelCase(entry.key.toString())
                }
                return delegate.fromJsonValue(camelCasedMap)
            }

            override fun toJson(writer: JsonWriter, value: Any?) {
                delegate.toJson(writer, value)
            }
        }
    }

    private fun camelCase(input: String): String {
        return input.split("_").joinToString("") { name ->
            name.replaceFirstChar { firstChar ->
                if (firstChar.isLowerCase()) firstChar.titlecase(
                    Locale.ROOT
                ) else firstChar.toString()
            }
        }.replaceFirstChar { it.lowercase(Locale.ROOT) }
    }
}