package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.ds.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {

	@Query("SELECT s FROM Staff s WHERE s.name = :name")
    public Staff getUserByUsername(@Param("name") String name);
}
