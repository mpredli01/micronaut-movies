package org.redlich.movies.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.redlich.movies.domain.Director;
import org.redlich.movies.repositories.DirectorRepository;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/directors")
class DirectorController {

    private final DirectorRepository directorRepository;

    DirectorController(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
        }

    @Get("/")
    List<Director> all() {
        return directorRepository.findAll();
        }

    @Get("/{name}")
    Optional<Director> byName(@NotBlank String name) {
        return directorRepository.findByName(name);
        }
    }
    