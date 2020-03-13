package org.redlich.movies.repositories;

import java.util.List;
import java.util.Optional;

import org.redlich.movies.domain.Director;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.H2)
public interface DirectorRepository extends CrudRepository<Director,Long> {

    @Override
    List<Director> findAll();

    Optional<Director> findByName(String name);
    }
