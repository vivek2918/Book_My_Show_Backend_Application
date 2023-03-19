package com.BMS_Backend.Book_My_Show.Converters;

import com.BMS_Backend.Book_My_Show.Dtos.Request.MovieRequestDto;
import com.BMS_Backend.Book_My_Show.Models.Movie;

public class MovieRequestConvertor {
    public static Movie convertDtoTOEntity(MovieRequestDto movieRequestDto){

        return Movie.builder()
                .movieName(movieRequestDto.getMovieName())
                .duration(movieRequestDto.getDuration())
                .genre(movieRequestDto.getGenre())
                .rating(movieRequestDto.getRating())
                .language(movieRequestDto.getLanguage())
                .build();
    }
}
