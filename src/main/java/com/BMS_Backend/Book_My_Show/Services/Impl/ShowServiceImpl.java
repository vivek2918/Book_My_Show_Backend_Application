package com.BMS_Backend.Book_My_Show.Services.Impl;

import com.BMS_Backend.Book_My_Show.Converters.ShowRequestConvertor;
import com.BMS_Backend.Book_My_Show.Dtos.Request.ShowRequestDto;
import com.BMS_Backend.Book_My_Show.Enums.SeatType;
import com.BMS_Backend.Book_My_Show.Models.*;
import com.BMS_Backend.Book_My_Show.Repositories.MovieRepository;
import com.BMS_Backend.Book_My_Show.Repositories.ShowRepository;
import com.BMS_Backend.Book_My_Show.Repositories.TheaterRepository;
import com.BMS_Backend.Book_My_Show.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {
    @Autowired
    ShowRepository showRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheaterRepository theaterRepository;


    public String addShow(ShowRequestDto showRequestDto){
        Show show = ShowRequestConvertor.convertDtoToEntity(showRequestDto);

        int movieId = showRequestDto.getMovieId();
        int theaterId = showRequestDto.getTheaterId();

        Movie movie = movieRepository.findById(movieId).get();

        Theater theater = theaterRepository.findById(theaterId).get();


        // setting the attribute of foreign key
        show.setMovie(movie);
        show.setTheater(theater);

        // goal is to create showSeat
        List<ShowSeat> showSeatList = createShowSeats(showRequestDto,show);

        show.setShowSeatList(showSeatList);

        // now we also need to update the parent entities

        show = showRepository.save(show);

        movie.getShowList().add(show);
        theater.getShowList().add(show);

        movieRepository.save(movie);
        theaterRepository.save(theater);

        return "The show has been added successfully";

    }

    private List<ShowSeat> createShowSeats(ShowRequestDto showRequestDto, Show show){

        // now the goal is to create the showSeat
        // we need to set its attributes

        Theater theater = show.getTheater();

        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();

        List<ShowSeat> showSeatList = new ArrayList<>();

        for(TheaterSeat theaterSeat : theaterSeatList){

            ShowSeat showSeat = new ShowSeat();

            showSeat.setSeatNo(theaterSeat.getSeatNo());
            showSeat.setSeatType(theaterSeat.getSeatType());

            if(theaterSeat.getSeatType().equals(SeatType.CLASSIC)){
                showSeat.setPrice(showRequestDto.getClassicSeatPrice());
            }
            else{
                showSeat.setPrice(showRequestDto.getPremiumSeatPrice());
            }
            showSeat.setBooked(false);
            showSeat.setShow(show);

            showSeatList.add(showSeat);

        }

        return showSeatList;

    }
}
