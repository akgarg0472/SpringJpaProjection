package com.akarg.springjpaprojection.engineer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Akhilesh Garg
 * @since 16-11-2022
 */
public interface EngineerRepo extends JpaRepository<Engineer, String> {

    List<Engineer> findAllByType(final EngineerType type);

    // causes converter exception
    @Query("SELECT e FROM Engineer e WHERE e.salary > :minimumSalary")
    List<EngineerDTO> findAllBySalaryGreaterThan_Class(@Param("minimumSalary") final Integer minimumSalary);

    @Query("SELECT e FROM Engineer e WHERE e.salary > :minimumSalary")
    List<IEngineerDTO> findAllBySalaryGreaterThan(final Integer minimumSalary); // causes converter exception

}
