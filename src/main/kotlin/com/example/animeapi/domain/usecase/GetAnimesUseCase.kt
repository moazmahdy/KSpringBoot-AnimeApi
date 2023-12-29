package com.example.animeapi.domain.usecase

import com.example.animeapi.data.AnimeRepoImpl
import org.springframework.stereotype.Service

@Service
class GetAnimesUseCase(
    private val repo: AnimeRepoImpl
) {
    operator fun invoke() = repo.getAnimes()
}