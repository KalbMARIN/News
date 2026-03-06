package com.practicum.news.data.mapper

import com.practicum.news.domain.entity.RefreshConfig
import com.practicum.news.domain.entity.Settings

fun Settings.toRefreshConfig(): RefreshConfig {
    return RefreshConfig(language, interval, wifiOnly)
}