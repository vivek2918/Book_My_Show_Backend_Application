package com.BMS_Backend.Book_My_Show.Services.Impl;

import com.BMS_Backend.Book_My_Show.Converters.TicketRequestConvertor;
import com.BMS_Backend.Book_My_Show.Dtos.Request.TicketRequestDto;
import com.BMS_Backend.Book_My_Show.Models.Show;
import com.BMS_Backend.Book_My_Show.Models.ShowSeat;
import com.BMS_Backend.Book_My_Show.Models.Ticket;
import com.BMS_Backend.Book_My_Show.Models.User;
import com.BMS_Backend.Book_My_Show.Repositories.ShowRepository;
import com.BMS_Backend.Book_My_Show.Repositories.TicketRepository;
import com.BMS_Backend.Book_My_Show.Repositories.UserRepository;
import com.BMS_Backend.Book_My_Show.Services.TicketService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    JavaMailSender javaMailSender;

    public String addTicket(TicketRequestDto ticketRequestDto) throws Exception{

        // create ticket from the ticketRequestDto
        Ticket ticket = TicketRequestConvertor.convertDtoToEntity(ticketRequestDto);

        // validation : check if the requested seats are available or not ?
        boolean isValidRequest = checkValidityOfRequestedSeats(ticketRequestDto);

        if(!isValidRequest){
            throw new Exception("Requested seats are not available");
        }

        // we assume that the requestedSeats are valid

        // calculate the total amount :
        Show show = showRepository.findById(ticketRequestDto.getShowId()).get();

        List<ShowSeat> showSeatList = show.getShowSeatList();
        List<String> requestedSeats = ticketRequestDto.getRequestedSeats();

        int totalAmount = 0;
        for(ShowSeat showSeat : showSeatList){

            if(requestedSeats.contains(showSeat.getSeatNo())){

                totalAmount += showSeat.getPrice();
                showSeat.setBooked(true);
                showSeat.setBookedAt(java.time.LocalDateTime.now());

            }

        }

        ticket.setPrice(totalAmount);

        // setting the other attributes
        ticket.setMovieName(show.getMovie().getMovieName());
        ticket.setShowDate(show.getShowDate());
        ticket.setShowTime(show.getShowTime());
        ticket.setTheaterName(show.getTheater().getName());


        // we need to set that string that talked about requestedSeats
        String allottedSeats = getAllottedSeatsFromShowSeats(requestedSeats);
        ticket.setBookedSeats(allottedSeats);

        // setting the foreign key attributes
        User user = userRepository.findById(ticketRequestDto.getUserId()).get();

        ticket.setUser(user);
        ticket.setShow(show);

        // save parents
        ticket = ticketRepository.save(ticket);



        List<Ticket> ticketList = show.getTicketList();
        ticketList.add(ticket);
        show.setTicketList(ticketList);

        showRepository.save(show);

        List<Ticket> ticketList1 = user.getTicketList();
        ticketList1.add(ticket);
        user.setTicketList(ticketList1);

        userRepository.save(user);

        String body = "Hi this is to confirm your booking for seat No "+ allottedSeats +"for the movie : " + ticket.getMovieName();

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("backendbot1103@gmail.com");
        mimeMessageHelper.setTo(user.getEmail());
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject("Confirming your booked Ticket");

        javaMailSender.send(mimeMessage);

        return "Ticket has successfully been added";
    }

    private String getAllottedSeatsFromShowSeats(List<String> requestedSeats){

        StringBuilder result = new StringBuilder();

        for(String seat : requestedSeats){

            result.append(seat).append(", ");

        }

        return result.toString();
    }

    private boolean checkValidityOfRequestedSeats(TicketRequestDto ticketRequestDto){

        int showId = ticketRequestDto.getShowId();

        List<String> requestedSeats = ticketRequestDto.getRequestedSeats();

        Show show = showRepository.findById(showId).get();

        List<ShowSeat> showSeatList =  show.getShowSeatList();

        // iterating over the list of seats
        for(ShowSeat showSeat : showSeatList){

            String seatNo = showSeat.getSeatNo();

            if(requestedSeats.contains(seatNo)){

                if(showSeat.isBooked()){
                    return false; // since this seat cannot be occupied : returning false
                }

            }

        }

        // all the requested were available
        return true;
    }
}
