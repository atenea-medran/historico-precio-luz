package com.ateneamedran.utilities

import com.ateneamedran.dao.DatabaseFactory
import com.ateneamedran.dao.dao
import com.ateneamedran.models.centims
import com.google.gson.Gson
import com.google.gson.JsonObject
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import java.net.URL
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.math.round

suspend fun addNewDay(link: String) {
    val jsonString = URL(link).readText()
    val prices: MutableList<Any> = mutableListOf()

    val gson = Gson()
    val jsonObject = gson.fromJson(jsonString, JsonObject::class.java)

    val listValues = jsonObject.get("included").asJsonArray
        .get(0).asJsonObject
        .get("attributes").asJsonObject
        .get("values").asJsonArray

    val dateString = listValues.get(0).asJsonObject.get("datetime").asString.substring(0,10)
    val date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    val nowString = dateString.split("-").reversed().joinToString("/")
    prices.add(date)
    prices.add(nowString)

    for (value in listValues) {
        prices.add((round(value.asJsonObject.get("value").asDouble)/10).toString())
    }

    DatabaseFactory.dbQuery {
        centims.insert {
            it[this.date] = LocalDate.now()
        }

    }



}



