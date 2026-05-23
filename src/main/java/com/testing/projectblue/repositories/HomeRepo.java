package com.testing.projectblue.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testing.projectblue.pojo.ProjectBlue;

@Repository
public interface HomeRepo extends JpaRepository<ProjectBlue, Long> {

}
