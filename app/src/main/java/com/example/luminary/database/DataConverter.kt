package com.example.luminary.database

import androidx.room.TypeConverter
import com.example.luminary.net.models.Name
import com.example.luminary.net.models.Picture
import com.example.luminary.net.models.User
import com.example.luminary.net.response.UserResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class DataConverter {

    @TypeConverter
    fun fromUserList(documentModel: List<User?>?): String? {
        if (documentModel == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<User?>?>() {}.type
        return gson.toJson(documentModel, type)
    }

    @TypeConverter
    fun toUserList(documentModel: String?): List<User>? {
        if (documentModel == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<User?>?>() {}.type
        return gson.fromJson<List<User>>(documentModel, type)
    }

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
    fun toName(documentModel: String?):Name? {
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
    fun toPicture(documentModel: String?):Picture? {
        if (documentModel == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<Picture>() {}.type
        return gson.fromJson<Picture>(documentModel, type)
    }

    @TypeConverter
    fun fromUser(name: User): String? {
        if (name == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<User>() {}.type
        return gson.toJson(name, type)
    }

    @TypeConverter
    fun toUser(documentModel: String?):User? {
        if (documentModel == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<User>() {}.type
        return gson.fromJson<User>(documentModel, type)
    }

    @TypeConverter
    fun fromUserRes(name: UserResponse): String? {
        if (name == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<UserResponse>() {}.type
        return gson.toJson(name, type)
    }

    @TypeConverter
    fun toUserRes(documentModel: String?):UserResponse? {
        if (documentModel == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<UserResponse>() {}.type
        return gson.fromJson<UserResponse>(documentModel, type)
    }


}