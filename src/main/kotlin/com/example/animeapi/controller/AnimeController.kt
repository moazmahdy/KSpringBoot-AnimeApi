package com.example.animeapi.controller

import com.example.animeapi.domain.model.Anime
import com.example.animeapi.domain.usecase.GetAnimesUseCase
import com.example.animeapi.domain.usecase.SearchAnimeUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/animes")
class AnimeController(
    private val getAnimesUseCase: GetAnimesUseCase,
    private val searchAnimeUseCase: SearchAnimeUseCase
) {

    @GetMapping("/all")
    fun getAllAnimes(): List<Anime> {
        return getAnimesUseCase.invoke()
    }

    @GetMapping("/search")
    fun searchAnimes(@RequestParam searchQuery: String): ResponseEntity<Any> {
        val foundAnime = searchAnimeUseCase.invoke(searchQuery)

        return if (foundAnime.isEmpty()) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("No games found for the search term: $searchQuery")
        } else {
            ResponseEntity.ok(foundAnime)
        }
    }
}