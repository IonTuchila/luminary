package com.example.luminary.database

import androidx.room.TypeConverter
import com.example.luminary.net.models.Name
import com.example.luminary.net.models.Picture
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class DataConverter {

    @TypeConverter
    fun fromName(name: Name): String? {
        if (name == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<Name>() {}.type
        return gson.toJson(name, type)
    }

    @TypeConverter
    fun toName(documentModel: String?): Name? {
        if (documentModel == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<Name>() {}.type
        return gson.fromJson<Name>(documentModel, type)
    }

    @TypeConverter
    fun fromPicture(name: Picture): String? {
        if (name == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<Picture>() {}.type
        return gson.toJson(name, type)
    }

    @TypeConverter
    fun toPicture(documentModel: String?): Picture? {
        if (documentModel == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<Picture>() {}.type
        return gson.fromJson<Picture>(documentModel, type)
    }

}