package com.example.MovieApp;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MovieService {
   
   private final MovieRepository movieRepo;

   public MovieService(MovieRepository movieRepo){
    this.movieRepo = movieRepo;
   }

   public MovieApp saved(MovieApp m){
     return movieRepo.save(m);
   }

   public List<MovieApp> getPopularMovies(){
    return movieRepo.findByIsPopularTrue();
   }

   public List<MovieApp> getMoviesByGenre(String genre) {
    return movieRepo.findByGenre(genre);
  }

   public List<MovieApp> Search(String mname){
    return movieRepo.Search(mname);
   }

   public List<MovieApp> saveBulk(List<MovieApp>m){
    return movieRepo.saveAll(m);
   }
   
   public MovieApp findBymname(String mname){
    return movieRepo.findBymname(mname);
   }


public List<MovieApp> getMoviesByReleaseDate(Long releaseDate) {
        return movieRepo.findAll(); 
    }

    // public List<MovieApp> getUpcomingMovies() {
    //     LocalDate today = LocalDate.now();
    //     return movieRepo.findUpcomingMovies(today);
    // }

    // public List<MovieApp> getUpcomingMoviesDesc(){
    //   LocalDate today = LocalDate.now();
    //   return movieRepo.findUpcomingMoviesDescending(today);
    // }

//     public String deletemovie(Long id){
//       movieRepo.deleteById(id);
//       return "Deleted Successfully";
//  }   
    
}
