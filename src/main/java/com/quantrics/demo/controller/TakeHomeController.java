package com.quantrics.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quantrics.demo.model.TrackResult;
import com.quantrics.demo.service.TakeHomeService;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@ControllerAdvice
@RequestMapping ("/quantrics/takehome")
public class TakeHomeController {
	Log log = LogFactory.getLog(TakeHomeController.class);

	@Autowired
	private TakeHomeService takeHomeService;

	@GetMapping("/track")
	public ResponseEntity<TrackResult> getTrackPlaces() {
		TrackResult result = new TrackResult();
		try {
			result = takeHomeService.getTrackPlaces();
			return new ResponseEntity<>(result, HttpStatus.OK);
			
		} catch (Exception e) {

			log.error("Exception in myEndpoint:", e);
			result.setMessage("An error occurred.");
			return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}




}
