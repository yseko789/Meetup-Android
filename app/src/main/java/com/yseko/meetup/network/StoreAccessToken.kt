package com.yseko.meetup.network

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreAccessToken(private val context: Context) {
    companion object{
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("bearer")
        val BEARER_TOKEN = stringPreferencesKey("bearer")
    }

    val getBearerToken: Flow<String?> = context.dataStore.data
        .map{preferences->
            preferences[BEARER_TOKEN]?:""
        }

    suspend fun saveBearerToken(token: String){
        context.dataStore.edit{preferences->
            preferences[BEARER_TOKEN] = token
        }
    }
}