package com.practicum.news.data.mapper

import com.practicum.news.data.local.ArticleDbModel
import com.practicum.news.data.remote.NewsResponseDto
import com.practicum.news.domain.entity.Article
import com.practicum.news.domain.entity.Interval
import com.practicum.news.domain.entity.Language
import java.text.SimpleDateFormat
import java.util.Locale

fun NewsResponseDto.toDbModels(topic: String): List<ArticleDbModel> {
    return articles.map {
        ArticleDbModel(
            title = it.title,
            description = it.description,
            url = it.url,
            imageUrl = it.urlToImage,
            sourceName = it.source.name,
            topic = topic,
            publishedAt = it.publishedAt.toTimestamp()
        )
    }
}

fun Language.toQueryParam(): String {
    return when(this) {
        Language.ENGLISH -> "en"
        Language.RUSSIAN -> "ru"
        Language.FRENCH -> "fr"
        Language.GERMAN -> "de"
    }
}

fun Int.toInterval(): Interval {
    return Interval.entries.first { it.minutes == this }
}

fun List<ArticleDbModel>.toEntities(): List<Article> {
    return map {
        Article(
            title = it.title,
            description = it.description,
            imageUrl = it.imageUrl,
            sourceName = it.sourceName,
            publishedAt = it.publishedAt,
            url = it.url
        )
    }.distinct()
}

private fun String.toTimestamp(): Long {
    val dateFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())

    return dateFormatter.parse(this)?.time ?: System.currentTimeMillis()
}