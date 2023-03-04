package com.ateneamedran.dao

import com.ateneamedran.dao.DatabaseFactory.dbQuery
import com.ateneamedran.models.Day
import com.ateneamedran.models.centims
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.selectAll

//import org.jetbrains.exposed.sql.*


class DAOFacadeImpl : DAOFacade {
    private fun resultRowToDay(row: ResultRow) = Day(
        date = row[centims.date],
        fecha = row[centims.fecha],
        price01 = row[centims.price01],
        price12 = row[centims.price12],
        price23 = row[centims.price23],
        price34 = row[centims.price34],
        price45 = row[centims.price45],
        price56 = row[centims.price56],
        price67 = row[centims.price67],
        price78 = row[centims.price78],
        price89 = row[centims.price89],
        price910 = row[centims.price910],
        price1011 = row[centims.price1011],
        price1112 = row[centims.price1112],
        price1213 = row[centims.price1213],
        price1314 = row[centims.price1314],
        price1415 = row[centims.price1415],
        price1516 = row[centims.price1516],
        price1617 = row[centims.price1617],
        price1718 = row[centims.price1718],
        price1819 = row[centims.price1819],
        price1920 = row[centims.price1920],
        price2021 = row[centims.price2021],
        price2122 = row[centims.price2122],
        price2223 = row[centims.price2223],
        price2300 = row[centims.price2300]
    )

    override suspend fun showTable(): List<Day> = dbQuery {
        centims.selectAll().orderBy(centims.date, order = SortOrder.DESC).limit(30).map(::resultRowToDay)
    }
}

val dao: DAOFacade = DAOFacadeImpl()