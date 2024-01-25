package com.iwex.quickmath.domain.use_case

import com.iwex.quickmath.domain.entity.GameSettings
import com.iwex.quickmath.domain.entity.Level
import com.iwex.quickmath.domain.repository.GameRepository

class GetGameSettingsUseCase(private val repository: GameRepository) {
    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}