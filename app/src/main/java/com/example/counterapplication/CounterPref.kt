package com.example.counterapplication

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.counterapplication.AppKey.KEY
import com.example.counterapplication.AppKey.KEYS

class CounterPref(context: Context) {

    private val counterPref: SharedPreferences =
        context.getSharedPreferences(KEYS, Context.MODE_PRIVATE)

    fun saveCount(value: Int){
        counterPref.edit { putInt(KEY, value) }
    }
    fun getCount(): Int{
        return counterPref.getInt(KEY, 0)
    }
}