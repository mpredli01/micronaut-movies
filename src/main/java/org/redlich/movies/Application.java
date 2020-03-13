package org.redlich.movies;

import java.util.Arrays;

import javax.inject.Singleton;

import org.redlich.movies.domain.Director;
import org.redlich.movies.domain.Movie;
import org.redlich.movies.domain.Movie.MovieType;
import org.redlich.movies.repositories.DirectorRepository;
import org.redlich.movies.repositories.MovieRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.context.event.StartupEvent;
import io.micronaut.core.annotation.TypeHint;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.annotation.EventListener;

@Singleton
@TypeHint(typeNames = {"org.h2.Driver","org.h2.mvstore.db.MVTableEngine"})
public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    private final DirectorRepository directorRepository;
    private final MovieRepository movieRepository;

    Application(DirectorRepository directorRepository, MovieRepository movieRepository) {
        this.directorRepository = directorRepository;
        this.movieRepository = movieRepository;
        }

    public static void main(String[] args) {
        Micronaut.run(Application.class);
        }

    @EventListener
    void init(StartupEvent event) {
        if (LOG.isInfoEnabled()) {
            LOG.info("Populating data");
            }

        Director tarantino = new Director("Tarantino","Quentin");
        Director darabont = new Director("Darabont","Frank");
        Director abrahams = new Director("Abrahams","James");
        Director sturges = new Director("Sturges","John");
        Director hooper = new Director("Hooper","Tobe");
        Director guillermin = new Director("Guillermin","John");
        Director neame = new Director("Neame","Ronald");

        directorRepository.saveAll(Arrays.asList(
                tarantino,
                darabont,
                abrahams,
                sturges,
                hooper,
                guillermin,
                neame
                ));

        Movie reservoirDogs = new Movie("Reservoir Dogs",tarantino,MovieType.ACTION,1992);
        Movie pulpFiction = new Movie("Pulp Fiction",tarantino,MovieType.CRIME,1994);

        Movie shawshankRedemption = new Movie("The Shawshank Redemption",darabont,MovieType.DRAMA,1994);
        Movie greenMile = new Movie("The Green Mile",darabont,MovieType.DRAMA,1999);

        Movie airplane = new Movie("Airplane!",abrahams,MovieType.COMEDY,1980);
        Movie policeSquad = new Movie("Police Squad!",abrahams,MovieType.COMEDY,1982);

        Movie magnificantSeven = new Movie("The Magnificent Seven",sturges,MovieType.WESTERN,1960);
        Movie greatEscape = new Movie("The Great Escape",sturges,MovieType.ADVENTURE,1963);

        Movie texasChainsaw = new Movie("The Texas Chainsaw Massacre",hooper,MovieType.HORROR,1974);
        Movie poltergeist = new Movie("Poltergeist",hooper,MovieType.HORROR,1982);

        Movie toweringInferno = new Movie("The Towering Inferno",guillermin,MovieType.DRAMA,1974);
        Movie kingKong = new Movie("King Kong",guillermin,MovieType.ADVENTURE,1976);

        Movie poseidonAdventure = new Movie("The Poseidon Adventure",neame,MovieType.ADVENTURE,1972);
        Movie meteor = new Movie("Meteor",neame,MovieType.ACTION,1979);

        movieRepository.saveAll(Arrays.asList(
                reservoirDogs,
                pulpFiction,
                shawshankRedemption,
                greenMile,
                airplane,
                policeSquad,
                magnificantSeven,
                greatEscape,
                texasChainsaw,
                poltergeist,
                toweringInferno,
                kingKong,
                poseidonAdventure,
                meteor
                ));
        }
    }
