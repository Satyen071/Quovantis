package com.example.DemoRecruitment;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruitmentRepository extends JpaRepository<DemoOffer, Long> {

public DemoOffer findByJobTitle(String title);

}
