package com.advertisment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.advertisment.entity.Slot;
import com.advertisment.entity.User;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Integer>{

	List<Slot> findAllByCreatedBy(User user);

}
