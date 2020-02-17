package com.advertisment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advertisment.constant.Constant;
import com.advertisment.dto.LoginRequestDto;
import com.advertisment.dto.LoginResponseDto;
import com.advertisment.entity.User;
import com.advertisment.exception.UserNotFoundException;
import com.advertisment.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	/**
	 * 
	 * @author PriyaDharshini S.
	 * @since 2020-02-11. This method will authenticate the user.
	 * @param loginDto - details of the user login
	 * @return LoginResponseDto which has status message,statusCode and user
	 *         details
	 * @throws UserNotFoundException it will throw the exception if the user
	 *                                   is not there.
	 * 
	 */
	@Override
	public LoginResponseDto authenticateEmployee(LoginRequestDto loginRequestDto) throws UserNotFoundException {
		Optional<User> employee = userRepository.findByMobileAndPassword(loginRequestDto.getMobile(),
				loginRequestDto.getPassword());
		if (!employee.isPresent()) {
			log.error("Exception occurred in EmployeeServiceImpl authenticateEmployee method:"
					+ Constant.USER_NOT_FOUND);
			throw new UserNotFoundException(Constant.USER_NOT_FOUND);
		}
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		loginResponseDto.setUserId(employee.get().getUserId());
		loginResponseDto.setUserName(employee.get().getUserName());
		log.info("Entering into EmployeeServiceImpl authenticateEmployee method: Authentication Successful");
		return loginResponseDto;

	}

}
