package com.iwex.quickmath.data.repository

import com.iwex.quickmath.domain.entity.GameSettings
import com.iwex.quickmath.domain.entity.Level
import com.iwex.quickmath.domain.entity.Question
import com.iwex.quickmath.domain.repository.GameRepository
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

object GameRepositoryImpl : GameRepository {
    private const val MIN_SUM_VALUE = 2
    private const val MIN_VISIBLE_NUMBER = 1

    private val SETTINGS_DEBUG = GameSettings(
        10,
        3,
        50,
        8
    )
    private val SETTINGS_EASY = GameSettings(
        10,
        10,
        70,
        60
    )
    private val SETTINGS_NORMAL = GameSettings(
        20,
        20,
        80,
        40
    )
    private val SETTINGS_HARD = GameSettings(
        30,
        30,
        90,
        40
    )

    override fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        val sum = Random.nextInt(MIN_SUM_VALUE, maxSumValue + 1)
        val visibleNumber = Random.nextInt(MIN_VISIBLE_NUMBER, sum)
        val rightAnswer = sum - visibleNumber
        val options = HashSet<Int>()
        options.add(rightAnswer)
        val from = max(rightAnswer - countOfOptions, MIN_VISIBLE_NUMBER)
        val to = min(rightAnswer + countOfOptions, maxSumValue)
        while (options.size < countOfOptions) {
            options.add(Random.nextInt(from, to))
        }
        return Question(sum, visibleNumber, options.toList())
    }

    override fun getGameSettings(level: Level): GameSettings {
        return when (level) {
            Level.DEBUG -> SETTINGS_DEBUG
            Level.EASY -> SETTINGS_EASY
            Level.NORMAL -> SETTINGS_NORMAL
            Level.HARD -> SETTINGS_HARD
        }
    }

}