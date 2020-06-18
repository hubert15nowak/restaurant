package com.e.restaurant.controller;

import com.e.restaurant.dto.feedstock.CreateFeedStockDto;
import com.e.restaurant.dto.feedstock.FeedStockDto;
import com.e.restaurant.service.FeedStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1/feed-stock")
public class FeedStockController {


    private FeedStockService feedStockService;

    @Autowired
    public FeedStockController(FeedStockService feedStockService) {
        this.feedStockService = feedStockService;
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity<CreateFeedStockDto> createFeedstock(@RequestBody CreateFeedStockDto feedStockDto) {
        try {
            feedStockService.createFeedStock(feedStockDto);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(feedStockDto, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(feedStockDto, HttpStatus.CREATED);
    }

    @GetMapping
    public @ResponseBody
    Iterable<FeedStockDto> getFeedStocks() {
        return feedStockService.getFeedStockDtos();
    }
}
