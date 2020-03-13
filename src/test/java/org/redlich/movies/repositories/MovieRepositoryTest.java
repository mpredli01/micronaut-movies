package org.redlich.movies.repositories;

import javax.inject.Inject;

import org.redlich.movies.domain.Movie;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.micronaut.data.annotation.Query;
import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.context.BeanContext;

@MicronautTest
public class MovieRepositoryTest {

    @Inject
    MovieRepository movieRepository;
    
    @Inject
    BeanContext beanContext;

    @Test
    void testQuery() {
        String query = beanContext.getBeanDefinition(MovieRepository.class)
                .getRequiredMethod("findByName",String.class)
                .getAnnotationMetadata()
                .stringValue(Query.class)
                .get();
        assertEquals(
                "SELECT movie_.`id`,movie_.`name`,movie_.`director_id`,movie_.`type`,movie_.`year`,movie_director_.`last_name` AS director_last_name,movie_director_.`first_name` AS director_first_name,movie_director_.`name` AS director_name FROM `movie` movie_ INNER JOIN `director` movie_director_ ON movie_.`director_id`=movie_director_.`id` WHERE (movie_.`name` = ?)",
                query
                );
        }

    @Test
    void testRetrieveMovieAndDirector() {
        Movie pulpFiction = movieRepository.findByName("Pulp Fiction").orElse(null);
        assertNotNull(pulpFiction);
        assertEquals("Pulp Fiction",pulpFiction.getName());
        assertEquals("Tarantino, Quentin",pulpFiction.getDirector().getName());
        assertEquals(Movie.MovieType.CRIME,pulpFiction.getType());
        }
    }
