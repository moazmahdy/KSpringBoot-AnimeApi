package com.example.animeapi.data

import com.example.animeapi.domain.model.Anime
import com.example.animeapi.domain.repository.AnimeRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository

@Repository
class AnimeRepoImpl (private val animeRepo: AnimeRepository) {

    // Initialize a Logger instance --> it's used to log message at different levels
    // (AnimeRepoImpl::class.java) --> The logger is specifically assigned to the AnimeRepoImpl class.
    private val logger = LoggerFactory.getLogger(AnimeRepoImpl::class.java)

    fun getAnimes(): List<Anime> {
        try {
            val animes: List<Anime> = animeRepo.findAll()
            logger.info("Retrieved {} games from the database", animes.size)
            return animes
        } catch (e: Exception) {
            // In case of an error, it logs an error message indicating the error while fetching animes from the database
            // The exception is re-thrown after being logged, allowing it to be handled elsewhere if necessary
            logger.error("Error fetching games from the database", e)
            throw e;
        }
    }

    fun searchInAnimes(searchQuery: String): List<Anime> {
        return try {
            val animes = animeRepo.findAll()
            // ignoreCase -->  it means that the search for the specified substring (searchQuery in this case) is case-insensitive
            val filteredAnimes = animes.filter { it.name.contains(searchQuery, ignoreCase = true) }

            if (filteredAnimes.isEmpty()) {
                emptyList()
            } else {
                filteredAnimes
            }
        } catch (e: Exception) {
            logger.error("Error fetching games from the database", e)
            throw e
        }
    }
}