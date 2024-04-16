package com.example.booking_az.service.impl;

import com.example.booking_az.dto.requestDto.HotelRequestDto;
import com.example.booking_az.dto.responseDto.HotelByRatingDto;
import com.example.booking_az.dto.responseDto.HotelResponseDto;
import com.example.booking_az.entity.Hotel;
import com.example.booking_az.entity.Review;
import com.example.booking_az.exception.handler.NotFoundException;
import com.example.booking_az.mapper.HotelMapper;
import com.example.booking_az.mapper.ReviewMapper;
import com.example.booking_az.repository.HotelRepository;
import com.example.booking_az.repository.ReviewRepository;
import com.example.booking_az.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;


    @Override
    public HotelResponseDto getById(Long id) {
        Hotel getHotelById = hotelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Hotel not found with this id: " + id));
        HotelResponseDto hotelResponseDto = hotelMapper.entityToHotelResponseDto(getHotelById);
        log.info("Hotel invoked with this id= ", id);
        return hotelResponseDto;

    }


    @Override
    public List<HotelByRatingDto> getHotelsByRating(Double rating) {
        List<Review> getByRating = reviewRepository.findByRatingGreaterThanEqual(rating);
        if (getByRating.isEmpty()) {
            throw new NotFoundException("Hotel not found with this rating degree");
        } else {
            List<HotelByRatingDto> getHotelsByRating = reviewMapper.reviewToHotelsByRatingDto(getByRating);
            return getHotelsByRating;
        }
    }

    @Override
    public Hotel add(HotelRequestDto hotelRequestDto) {
        Hotel hotel = hotelMapper.hotelRequestDtoToEntity(hotelRequestDto);
        return hotelRepository.save(hotel);
    }

    @Override
    public void update(Long id, HotelRequestDto hotelRequestDto) {
        Hotel updatedHotel = hotelRepository.findById(id).orElseThrow(() -> new NotFoundException
                ("Hotel not found with this id: " + id));
        hotelMapper.update(updatedHotel, hotelRequestDto);
        hotelRepository.save(updatedHotel);
        log.info("Hotel updated with this id= ", id);
    }

    @Override
    public void delete(Long id) {
        Hotel deletedHotel = hotelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Hotel not found with this id: " + id));
        hotelRepository.delete(deletedHotel);
        log.info("Hotel deleted with this id= ", id);
    }

    @Override
    public List<HotelResponseDto> getAll() {
        List<Hotel> hotelList = hotelRepository.findAll();
        List<HotelResponseDto> hotelResponseDto = hotelMapper.entityToHotelResponseDto(hotelList);
        return hotelResponseDto;
    }

}
