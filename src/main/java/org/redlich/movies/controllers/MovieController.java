package org.redlich.movies.controllers;

import java.util.List;
import java.util.Optional;

import org.redlich.movies.domain.Movie;
import org.redlich.movies.domain.MovieDTO;
import org.redlich.movies.repositories.MovieRepository;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.data.model.Pageable;

@Controller("/movies")
class MovieController {

    private final MovieRepository movieRepository;

    MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
        }

    @Get("/")
    List<MovieDTO> all(Pageable pageable) {
        return movieRepository.list(pageable);
        }

    @Get("/{name}")
    Optional<Movie> byName(String name) {
        return movieRepository.findByName(name);
        }
    }
    