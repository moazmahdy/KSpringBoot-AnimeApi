package com.example.animeapi.domain.usecase

import com.example.animeapi.data.AnimeRepoImpl
import com.example.animeapi.domain.model.Anime
import org.springframework.stereotype.Service

@Service
class SearchAnimeUseCase(
    private val repo: AnimeRepoImpl
) {

    operator fun invoke(searchQuery: String): List<Anime> = repo.searchInAnimes(searchQuery)
}