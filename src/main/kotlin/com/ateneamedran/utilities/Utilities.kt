package com.ateneamedran.utilities

import com.ateneamedran.models.centims
import com.google.gson.Gson
import com.google.gson.JsonObject
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import java.net.URL
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.math.round

object Utilities {
    private fun createNewDay(link: String): MutableList<Any> {
        val jsonString = URL(link).readText()
        val day: MutableList<Any> = mutableListOf()

        val gson = Gson()
        val jsonObject = gson.fromJson(jsonString, JsonObject::class.java)

        val listValues = jsonObject.get("included").asJsonArray
            .get(0).asJsonObject
            .get("attributes").asJsonObject
            .get("values").asJsonArray

        val dateString = listValues.get(0).asJsonObject.get("datetime").asString.substring(0, 10)
        val dateKotlin = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        val nowString = dateString.split("-").reversed().joinToString("/")
        day.add(dateKotlin)
        day.add(nowString)

        for (value in listValues) {
            day.add((round(value.asJsonObject.get("value").asDouble) / 10).toString())
        }
        return day
    }
    private fun addNewDay(prices: MutableList<Any>): Boolean {
        transaction {
            centims.insert {
                it[date] = prices[0] as LocalDate
                it[fecha] = prices[1] as String
                it[price01] = prices[2] as String
                it[price12] = prices[3] as String
                it[price23] = prices[4] as String
                it[price34] = prices[5] as String
                it[price45] = prices[6] as String
                it[price56] = prices[7] as String
                it[price67] = prices[8] as String
                it[price78] = prices[9] as String
                it[price89] = prices[10] as String
                it[price910] = prices[11] as String
                it[price1011] = prices[12] as String
                it[price1112] = prices[13] as String
                it[price1213] = prices[14] as String
                it[price1314] = prices[15] as String
                it[price1415] = prices[16] as String
                it[price1516] = prices[17] as String
                it[price1617] = prices[18] as String
                it[price1718] = prices[19] as String
                it[price1819] = prices[20] as String
                it[price1920] = prices[21] as String
                it[price2021] = prices[22] as String
                it[price2122] = prices[23] as String
                it[price2223] = prices[24] as String
                it[price2300] = prices[25] as String
            }
        }
        if (prices.isNotEmpty()) return true
        return false
    }
    fun updateDay() = Runnable {
        val tomorrow = LocalDate.now()//.plusDays(1)
        val startDate = tomorrow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        val endDate = tomorrow.plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        val day = createNewDay("https://apidatos.ree.es/en/datos/mercados/precios-mercados-tiempo-real?start_date=$startDate&T00:00&end_date=$endDate&T00:00&time_trunc=hour")
        while (!addNewDay(day)) {
            addNewDay(day)
            Thread.sleep(1000*60)
        }
    }

    fun scheduleUpdateEveryDay(task: Runnable, localTime: LocalTime) {
        val scheduler = Executors.newSingleThreadScheduledExecutor()
        val now = LocalDateTime.now()
        val scheduledTime = now.with(localTime)
        val delay = ChronoUnit.MILLIS.between(now, scheduledTime)
        scheduler.scheduleAtFixedRate(task, delay, 24 * 60 * 60 * 1000, TimeUnit.MILLISECONDS)
    }
}