package org.redlich.movies.controllers;

import java.util.List;

import javax.inject.Inject;

import org.redlich.movies.domain.Director;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
class DirectorControllerTest {

    @Inject
    @Client("/directors")
    RxHttpClient client;

    @Test
    void testListInitialDirectors() {

        List<Director> directors = client.retrieve(HttpRequest.GET("/"),Argument.listOf(Director.class)).blockingFirst();

        Assertions.assertEquals(
                7,
                directors.size()
                );
        }
    }
