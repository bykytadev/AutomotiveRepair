package vti.finalexam.finalexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import vti.finalexam.finalexam.entity.Accessory;

@Transactional
public interface AccessoryRepository extends JpaRepository<Accessory, Long>{


}
