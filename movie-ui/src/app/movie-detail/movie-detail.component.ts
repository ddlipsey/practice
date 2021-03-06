import { Component, OnInit, Input } from '@angular/core';
import { Movie } from '../movie';
import { Genre } from '../genre';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-movie-detail',
  templateUrl: './movie-detail.component.html',
  styleUrls: ['./movie-detail.component.css']
})



export class MovieDetailComponent implements OnInit {

  @Input() movie: Movie;
  genres: Genre[];

  constructor( private route: ActivatedRoute,
  private movieService: MovieService,
  private location: Location) { }

  ngOnInit(): void {
    this.getMovie();
    this.getGenres();
  }

  getMovie(): void {
  const id = ''+this.route.snapshot.paramMap.get('id');
  this.movieService.getMovie(id)
    .subscribe(movie => this.movie = movie);
  }

  getGenres(): void {
    this.movieService.getGenres().subscribe(genres => this.genres = genres);
  }

  save(): void {
   this.movieService.updateMovie(this.movie)
     .subscribe(() => this.goBack());
 }

  goBack(): void {
    this.location.back();
  }

}
