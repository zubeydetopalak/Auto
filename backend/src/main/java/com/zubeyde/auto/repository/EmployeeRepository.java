package com.zubeyde.auto.repository;
import com.zubeyde.auto.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Belirli bir istasyondaki çalışanları listele
    List<Employee> findByStationId(Long stationId);
    
    java.util.Optional<Employee> findByName(String name);
}