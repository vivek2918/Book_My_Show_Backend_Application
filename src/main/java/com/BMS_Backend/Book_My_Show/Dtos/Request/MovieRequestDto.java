package com.BMS_Backend.Book_My_Show.Dtos.Request;

import com.BMS_Backend.Book_My_Show.Enums.Genre;
import com.BMS_Backend.Book_My_Show.Enums.Language;
import lombok.Data;

@Data
public class MovieRequestDto {
    private String movieName;
    private double rating;
    private double duration;
    private Language language;
    private Genre genre;
}
