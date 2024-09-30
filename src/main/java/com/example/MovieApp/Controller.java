package com.example.MovieApp;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
public class Controller {

//using @autowired annotation
    // @Autowired
    // private MovieService s;
    //  @PostMapping("save")
    // public MovieApp savedata(@RequestBody MovieApp p){
    //     return s.savedata(p);
    // }


    private final MovieService movieService;
    
    public Controller(MovieService movieService){
        this.movieService = movieService;
    }

    @PostMapping("saveMovies")
    public MovieApp saved(@RequestBody MovieApp m){
        return movieService.saved(m);
    }
   
    @PostMapping("saveBulk")
    public List<MovieApp>saveBulk(@RequestBody List <MovieApp> m){
        return movieService.saveBulk(m);
    }

    @GetMapping("/popular")
    public List<MovieApp>getPopularMovies(){
        return movieService.getPopularMovies();
    }

    @GetMapping("/genre/{genre}")
    public List<MovieApp> getMoviesByGenre(@PathVariable String genre) {
        return movieService.getMoviesByGenre(genre);
    }

    @GetMapping("findbymname/{mname}")
    public MovieApp getbymname(@PathVariable String mname){
        return movieService.findBymname(mname);
    }

    @GetMapping("Search/{mname}")
    public List<MovieApp>getSimilar(@PathVariable String mname){
        return movieService.Search(mname);
    }

    // @GetMapping("/upcoming")
    // public List<MovieApp> getUpcomingMovies() {
    //     return movieService.getUpcomingMovies();
    // }

    // @GetMapping("/upcoming-desc")
    // public List<MovieApp> getMoviesBasedonDesc(){
    //     return movieService.getUpcomingMoviesDesc();
    // }

    // @DeleteMapping("/delete/{id}")
    // public String deletemovie(@PathVariable Long id){
    //     return movieService.deletemovie(id);
}