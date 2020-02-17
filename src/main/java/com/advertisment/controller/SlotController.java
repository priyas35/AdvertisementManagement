package com.advertisment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advertisment.constant.Constant;
import com.advertisment.dto.AdminSlotsDto;
import com.advertisment.exception.SlotNotFoundException;
import com.advertisment.exception.UserNotFoundException;
import com.advertisment.service.SlotService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/slots")
@CrossOrigin
@Slf4j
public class SlotController {

	@Autowired
	SlotService slotService;

	/**
	 * 
	 * @author PriyaDharshini S.
	 * @since 2020-02-17. This method will get the slots for the user.
	 * @param userId - id of the user
	 * @return list of AdminSlotsDto which has the list of slot details.
	 * @throws UserNotFoundException it will throw the exception if the user is not
	 *                               there.
	 * @throws SlotNotFoundException it will throw the exception if the slot is not
	 *                               there.
	 * 
	 */
	@GetMapping("/{userId}")
	public ResponseEntity<List<AdminSlotsDto>> getSlotsByUser(@PathVariable Integer userId)
			throws UserNotFoundException, SlotNotFoundException {
		if (ObjectUtils.isEmpty(userId)) {
			log.error("Exception occured in SlotController getSlotsByUser method :" + Constant.USER_NOT_FOUND);
			throw new UserNotFoundException(Constant.USER_NOT_FOUND);
		}
		log.info("Entering into SlotController getSlotsByUser method : calling slotService");
		return new ResponseEntity<>(slotService.getSlotsByUser(userId), HttpStatus.OK);
	}

}
