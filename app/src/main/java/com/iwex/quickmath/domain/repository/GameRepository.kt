package com.iwex.quickmath.domain.repository

import com.iwex.quickmath.domain.entity.GameSettings
import com.iwex.quickmath.domain.entity.Level
import com.iwex.quickmath.domain.entity.Question

interface GameRepository {
    fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question

    fun getGameSettings(level: Level): GameSettings
}