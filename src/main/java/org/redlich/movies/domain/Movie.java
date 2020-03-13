package org.redlich.movies.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.annotation.Nullable;

import io.micronaut.core.annotation.Creator;
import io.micronaut.data.annotation.AutoPopulated;

@Entity
public class Movie {

    @Id
    @AutoPopulated
    private UUID id;

    private String name;
    private MovieType type;
    private int year;

    @ManyToOne
    private Director director;

    @Creator
    public Movie(String name,@Nullable Director director,MovieType type,int year) {
        setName(name);
        setDirector(director);
        setType(type);
        setYear(year);
        }

    public UUID getId() {
        return id;
        }

    public void setId(UUID id) {
        this.id = id;
        }

    public String getName() {
        return name;
        }

    public void setName(String name) {
        this.name = name;
        }

    public Director getDirector() {
        return director;
        }

    public void setDirector(Director director) {
        this.director = director;
        }

    public MovieType getType() {
        return type;
        }

    public void setType(MovieType type) {
        this.type = type;
        }

    public int getYear() {
        return year;
        }

    public void setYear(int year) {
        this.year = year;
        }

    public enum MovieType {
        ACTION,
        ADVENTURE,
        COMEDY,
        CRIME,
        DRAMA,
        EPIC,
        HORROR,
        MUSICAL,
        SCIFI,
        WAR,
        WESTERN
        }
    }
