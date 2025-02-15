package com.madsam.otora.utils

import android.content.Context
import android.content.SharedPreferences
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

object ShareUtil {
    private var sps: SharedPreferences?=null
    private val moshi: Moshi = Moshi.Builder()
        .build()

    private fun getSps(context: Context):SharedPreferences{
        if(sps==null){
            sps=context.getSharedPreferences("default",Context.MODE_PRIVATE)
        }
        return sps!!
    }

    fun putString(key:String,value:String?,context:Context){
        if(!value.isNullOrBlank()){
            val editor:SharedPreferences.Editor=getSps(context).edit()
            editor.putString(key,value)
            editor.apply()
        }
    }

    fun getString(key:String,context:Context):String?{
        if(key.isNotBlank()){
            val sps:SharedPreferences=getSps(context)
            return sps.getString(key,null)
        }
        return null
    }

    private fun putStringArray(key: String, array: List<String>, context: Context) {
        val jsonAdapter = moshi.adapter<List<String>>(Types.newParameterizedType(List::class.java, String::class.java))
        val json = jsonAdapter.toJson(array)
        putString(key, json, context)
    }

    private fun getStringArray(key: String, context: Context): List<String>? {
        val json = getString(key, context)
        return if (json != null) {
            val type = Types.newParameterizedType(List::class.java, String::class.java)
            val jsonAdapter = moshi.adapter<List<String>>(type)
            jsonAdapter.fromJson(json)
        } else {
            null
        }
    }

    fun insertStringArray(key: String, value: String, context: Context) {
        val array = getStringArray(key, context)
        if (array != null) {
            val list = array.toMutableList()
            list.add(value)
            putStringArray(key, list, context)
        } else {
            putStringArray(key, listOf(value), context)
        }
    }

    fun findStringArray(key: String, value: String, context: Context): Boolean {
        val array = getStringArray(key, context)
        return array?.contains(value) == true
    }
}