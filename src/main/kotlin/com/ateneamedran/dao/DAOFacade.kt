package com.ateneamedran.dao

import com.ateneamedran.models.Day

interface DAOFacade {
    suspend fun showTable(): List<Day>
}