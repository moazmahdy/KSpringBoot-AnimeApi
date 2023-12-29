package com.example.animeapi.domain.repository

import com.example.animeapi.domain.model.Anime
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface AnimeRepository : JpaRepository<Anime, Int>

// Explain
// JpaRepository --> Java persistence Api
//               --> is a pre-defined interface that offers many standard operations for interacting with the database using the Java Persistence API (JPA)
//                واجهة جاهزة توفر العديد من العمليات القياسية للتفاعل مع قاعدة البيانات باستخدام JPA
//               --> Anime --> Refers to the type (entity) being dealt with in the database
//               --> Int --> Indicates the type of the primary key for the data table