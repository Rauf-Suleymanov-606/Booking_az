package com.example.booking_az.service.impl;

import com.example.booking_az.dto.requestDto.ReviewRequestDto;
import com.example.booking_az.dto.responseDto.ReviewResponseDto;
import com.example.booking_az.entity.Review;
import com.example.booking_az.exception.handler.NotFoundException;
import com.example.booking_az.mapper.ReviewMapper;
import com.example.booking_az.repository.ReviewRepository;
import com.example.booking_az.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    @Override
    public ReviewResponseDto getById(Long id) {
        Review getReviewById = reviewRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Review not found with this id: "+id));
        ReviewResponseDto getById = reviewMapper.entityToReviewResponseDto(getReviewById);
        log.info("Review deleted with this id", id);
        return getById;

    }

    @Override
    public List<ReviewResponseDto> getAll() {
        List<Review> reviewResponseDtos = reviewRepository.findAll();
        List<ReviewResponseDto> reviewList = reviewMapper.entityToReviewResponseDto(reviewResponseDtos);
        return reviewList;
    }

    @Override
    public Review add(ReviewRequestDto reviewRequestDto) {
        Review review = reviewMapper.reviewRequestDtoToEntity(reviewRequestDto);
        return reviewRepository.save(review);
    }

    @Override
    public void update(Long id, ReviewRequestDto reviewRequestDto) {
        Review updatedReview = reviewRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Review not found with this id: "+id));
        reviewMapper.update(updatedReview, reviewRequestDto);
        reviewRepository.save(updatedReview);
        log.info("Review updated with this id: "+ id);
    }

    @Override
    public void delete(Long id) {
        Review deletedReview = reviewRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Review not found with this id: "+id));
        reviewRepository.delete(deletedReview);
        log.info("Review deleted with this id: "+ id);
    }
}
