import { Component, OnInit } from '@angular/core';
import { Movie } from '../movie';
import { Genre } from '../genre';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {
  selectedMovie: Movie;
  movies: Movie[];
  genres: Genre[];

  constructor(private movieService: MovieService) { }

  ngOnInit() {
    this.getMovies();
    this.getGenres();
    this.selectedMovie = new Movie();
  }

  getMovies(): void {
    this.movieService.getMovies()
      .subscribe(movies => this.movies = movies);
  }

   getGenres(): void {
    this.movieService.getGenres()
      .subscribe(genres => this.genres = genres);
  }

  delete(movie: Movie): void {
    this.movies = this.movies.filter(h => h !== movie);
    this.movieService.deleteMovie(movie).subscribe();
  }

  add(movie: Movie): void {
    this.movieService.addMovie(this.selectedMovie).subscribe();
    this.getMovies();
  }

}
