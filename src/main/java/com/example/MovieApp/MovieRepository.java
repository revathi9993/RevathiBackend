package com.example.MovieApp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends JpaRepository<MovieApp,Long> {
    
        MovieApp findBymname(@Param("mname") String mname);
   
       List<MovieApp> findByGenre(String genre);
   
       List<MovieApp> findByIsPopularTrue();
   
       @Query("SELECT m FROM MovieApp m WHERE m.mname LIKE :mname%")
       List<MovieApp> Search(@Param("mname")String mname);
   
       @Query("SELECT m FROM MovieApp m WHERE m.genre = :genre")
       List<MovieApp> findBYGenre(@Param("genre") String genre);
       
       @Query("SELECT m FROM MovieApp m WHERE m.releaseDate >= :today")
       List<MovieApp> findUpcomingMovies(@Param("today")LocalDate today);
   
       @Query("SELECT m FROM MovieApp m WHERE m.releaseDate >= :today ORDER BY m.releaseDate DESC")
       List<MovieApp> findUpcomingMoviesDescending(@Param("today")LocalDate today);
   }
    


