package com.advertisment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advertisment.constant.Constant;
import com.advertisment.dto.AdminSlotsDto;
import com.advertisment.entity.Slot;
import com.advertisment.entity.User;
import com.advertisment.exception.SlotNotFoundException;
import com.advertisment.exception.UserNotFoundException;
import com.advertisment.repository.SlotRepository;
import com.advertisment.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SlotServiceImpl implements SlotService {

	@Autowired
	SlotRepository slotRepository;

	@Autowired
	UserRepository userRepository;

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
	public List<AdminSlotsDto> getSlotsByUser(Integer userId) throws UserNotFoundException, SlotNotFoundException {

		Optional<User> user = userRepository.findById(userId);
		if (!user.isPresent()) {
			log.error("Exception occured in SlotServiceImpl getSlotsByUser method :" + Constant.USER_NOT_FOUND);
			throw new UserNotFoundException(Constant.USER_NOT_FOUND);
		}
		List<Slot> slots = slotRepository.findAllByCreatedBy(user.get());
		if (slots.isEmpty()) {
			log.error("Exception occured in SlotServiceImpl getSlotsByUser method :" + Constant.SLOT_NOT_FOUND);
			throw new SlotNotFoundException(Constant.SLOT_NOT_FOUND);
		}
		log.info("Entering into SlotServiceImpl getSlotsByUser method : getting slots");
		List<AdminSlotsDto> adminSlots = new ArrayList<>();
		slots.forEach(slot -> {
			AdminSlotsDto adminSlotsDto = new AdminSlotsDto();
			BeanUtils.copyProperties(slot, adminSlotsDto);
			adminSlotsDto.setPlanName(slot.getPlan().getPlanName());
			adminSlots.add(adminSlotsDto);
		});
		return adminSlots;
	}

}
