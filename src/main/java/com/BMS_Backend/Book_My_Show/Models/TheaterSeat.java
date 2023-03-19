package com.BMS_Backend.Book_My_Show.Models;

import com.BMS_Backend.Book_My_Show.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TheaterSeats")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheaterSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    @ManyToOne
    @JoinColumn
    private Theater theater;
}
