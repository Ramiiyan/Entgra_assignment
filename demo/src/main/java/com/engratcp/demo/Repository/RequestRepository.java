package com.engratcp.demo.Repository;


import com.engratcp.demo.Model.ServoRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<ServoRequest, Long> {
}
