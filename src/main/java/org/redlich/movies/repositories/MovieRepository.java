package org.redlich.movies.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.redlich.movies.domain.Movie;
import org.redlich.movies.domain.MovieDTO;

import io.micronaut.data.annotation.Join;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.PageableRepository;

@JdbcRepository(dialect = Dialect.H2)
public interface MovieRepository extends PageableRepository<Movie,UUID> {

    List<MovieDTO> list(Pageable pageable);

    @Join("director")
    Optional<Movie> findByName(String lastName);
    }
    