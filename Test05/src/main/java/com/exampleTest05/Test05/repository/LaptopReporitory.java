package com.exampleTest05.Test05.repository;

import com.exampleTest05.Test05.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopReporitory extends JpaRepository<Laptop,String> {
}
