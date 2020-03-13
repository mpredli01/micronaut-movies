package org.redlich.movies.domain;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class MovieDTO {

    private String name;

    public String getName() {
        return name;
        }

    public void setName(String name) {
        this.name = name;
        }
    }
