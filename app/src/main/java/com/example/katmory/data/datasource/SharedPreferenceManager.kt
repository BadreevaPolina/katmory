package com.example.katmory.data.datasource

import android.content.Context
import android.util.Log
import com.example.katmory.common.utils.GameType

class SharedPreferenceManager(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("game_state", Context.MODE_PRIVATE)

    fun getCurrentLevel(gameType: GameType): Int {
        Log.i("SharedPreferenceManager","level for ${gameType.name} is ${sharedPreferences.getInt("current_level_${gameType.name}", 1)}")
        return sharedPreferences.getInt("current_level_${gameType.name}", 1)

    }

    fun setCurrentLevel(gameType: GameType, level: Int) {
        sharedPreferences.edit().putInt("current_level_${gameType.name}", level).apply()
    }
}
