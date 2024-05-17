package com.example.booking_az;

import com.example.booking_az.auth.AuthenticationService;
import com.example.booking_az.auth.RegisterRequest;
import com.example.booking_az.entity.Booking;
import com.example.booking_az.repository.BookingRepository;
import com.example.booking_az.repository.CustomerRepository;
import com.example.booking_az.repository.HotelRepository;
import com.example.booking_az.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


//      Customer customer= customerRepository.findById(1L).orElseThrow();
//      log.info("customer : {}",customer);

//       Hotel hotelEntity1= hotelRepository.findById(2).orElseThrow();
//        log.info("byId : {}",hotelEntity1);


    }
}
