package com.BMS_Backend.Book_My_Show.Repositories;

import com.BMS_Backend.Book_My_Show.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {

}
