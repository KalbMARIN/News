package com.practicum.news.domain.usecase

import com.practicum.news.domain.entity.Interval
import com.practicum.news.domain.entity.Language
import com.practicum.news.domain.repository.SettingsRepository
import javax.inject.Inject

class UpdateLanguageUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository
) {

    suspend operator fun invoke(language: Language) {
        settingsRepository.updateLanguage(language)
    }
}