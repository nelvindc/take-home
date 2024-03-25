package com.quantrics.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quantrics.demo.adapter.MediaWikiAdapter;
import com.quantrics.demo.adapter.OpenNotifyAdapter;
import com.quantrics.demo.model.GeoSearch;
import com.quantrics.demo.model.MediaWiki;
import com.quantrics.demo.model.OpenNotify;
import com.quantrics.demo.model.TrackPlace;
import com.quantrics.demo.model.TrackResult;



@Service
public class TakeHomeService {
	Log log = LogFactory.getLog(TakeHomeService.class);

	@Autowired
	private OpenNotifyAdapter openNotifyAdapter;

	@Autowired
	private MediaWikiAdapter mediaWikiAdapter;

	public TrackResult getTrackPlaces() throws Exception{
		
		OpenNotify openNotify = openNotifyAdapter.getIssLocation();

		return mapToTrackResult(
				mediaWikiAdapter.getPlaces(
						openNotify.getIss_position().getLatitude(), 
						openNotify.getIss_position().getLongitude()));

	}

	private TrackResult mapToTrackResult(MediaWiki mediaWiki) {
		TrackResult result = new TrackResult();
		List<TrackPlace> trackPlaceList = new ArrayList<>();

		if (mediaWiki != null 
				&& mediaWiki.getQuery() != null 
				&& mediaWiki.getQuery().getGeosearch() != null 
				&& !mediaWiki.getQuery().getGeosearch().isEmpty()) {

			for (GeoSearch geosearch : mediaWiki.getQuery().getGeosearch()) {
				TrackPlace place = new TrackPlace();
				place.setTitle(geosearch.getTitle());
				place.setLatitude(geosearch.getLat());
				place.setLongitude(geosearch.getLon());
				place.setCountry(geosearch.getCountry());
				trackPlaceList.add(place);
			}
		}
		result.setResults(trackPlaceList);

		return result;

	}





}
