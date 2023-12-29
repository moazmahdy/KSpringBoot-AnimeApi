package com.example.animeapi.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "Animes")
data class Anime(

    @Id
    @Column(name = "id")
    var id: Int,
    @Column(name = "name")
    var name: String,
    @Column(name = "description")
    var description: String,
    @Column(name = "year")
    var year: Int,
    @Column(name = "studio")
    var studio: String,
    @Column(name = "director")
    var director: String,
    @Column(name = "episodes")
    var episodes: Int,
    @Column(name = "status")
    var status: String,
    @Column(name = "rating")
    var rating: Float,
    @Column(name = "imageurl")
    var imageurl: String,
    @Column(name = "genersid")
    var genersid: Int

) {
    constructor() : this(
        0, "", "", 0, "", "", 0, "", 0.0F, "", 0
    )
}