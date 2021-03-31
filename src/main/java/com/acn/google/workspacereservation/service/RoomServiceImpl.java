package com.acn.google.workspacereservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acn.google.workspacereservation.entity.Rooms;
import com.acn.google.workspacereservation.repo.RoomsRepo;

@Service
public class RoomServiceImpl implements RoomService {
	
	private RoomsRepo roomsRepo;
	
	@Autowired
	public RoomServiceImpl(RoomsRepo theRoomsRepo) {
		roomsRepo = theRoomsRepo;
	}

	@Override
	public List<Rooms> findAll() {
		
		return roomsRepo.findAll();
	}
}
