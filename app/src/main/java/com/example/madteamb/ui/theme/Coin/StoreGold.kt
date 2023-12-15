package com.example.madteamb.ui.theme.Coin

import android.content.Context

class StoreGold(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("My Preferences",Context.MODE_PRIVATE)
    fun saveGoldValue(goldValue:Int)
    {
        val editor = sharedPreferences.edit()
        editor.putInt("goldValue",goldValue)
        editor.apply()
    }
    fun getGoldValue(defaultValue:Int = 0):Int{
        return sharedPreferences.getInt("goldValue",defaultValue)
    }

}