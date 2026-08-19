package com.app.service.room;

import java.util.List;

import com.app.dto.room.Room;
import com.app.dto.room.RoomSearchCondition;

public interface RoomService {
	List<Room> findRoomList();
	public List<Room> findRoomListBySearchCondition(RoomSearchCondition roomSearchCondition);
	
	
	int saveRoom(Room room);
	
	Room findRoomByRoomId(int roomId);
	
	
	int removeRoom(int roomId);
	
	int modifyRoom(Room room);
}
