package com.example.dbproject.repository;

import com.example.dbproject.model.PassengerEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerEntityRepository extends JpaRepository<PassengerEntity, Integer> {
  Optional<PassengerEntity> findByIdAndPassportnumber(int id, int passportnumber);
}
