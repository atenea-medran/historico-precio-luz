package com.ateneamedran.models

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.date

object centims : Table() {
    val date = date("date")
    val fecha = varchar("fecha",20)
    val price01 = varchar("price01",8)
    val price12 = varchar("price12",8)
    val price23 = varchar("price23",8)
    val price34 = varchar("price34",8)
    val price45 = varchar("price45",8)
    val price56 = varchar("price56",8)
    val price67 = varchar("price67",8)
    val price78 = varchar("price78",8)
    val price89 = varchar("price89",8)
    val price910 = varchar("price910",8)
    val price1011 = varchar("price1011",8)
    val price1112 = varchar("price1112",8)
    val price1213 = varchar("price1213",8)
    val price1314 = varchar("price1314",8)
    val price1415 = varchar("price1415",8)
    val price1516 = varchar("price1516",8)
    val price1617 = varchar("price1617",8)
    val price1718 = varchar("price1718",8)
    val price1819 = varchar("price1819",8)
    val price1920 = varchar("price1920",8)
    val price2021 = varchar("price2021",8)
    val price2122 = varchar("price2122",8)
    val price2223 = varchar("price2223",8)
    val price2300 = varchar("price2324",8)

    override val primaryKey = PrimaryKey(date)
}