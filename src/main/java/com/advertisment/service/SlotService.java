package com.advertisment.service;

import java.util.List;

import com.advertisment.dto.AdminSlotsDto;
import com.advertisment.exception.SlotNotFoundException;
import com.advertisment.exception.UserNotFoundException;

public interface SlotService {
	
	List<AdminSlotsDto> getSlotsByUser(Integer userId) throws UserNotFoundException, SlotNotFoundException;

}
