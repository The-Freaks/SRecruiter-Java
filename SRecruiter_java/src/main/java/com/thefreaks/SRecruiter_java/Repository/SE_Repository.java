package com.thefreaks.SRecruiter_java.Repository;

import com.thefreaks.SRecruiter_java.Model.SoftwareEngineering;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SE_Repository extends JpaRepository<SoftwareEngineering, Long>{
    @Query("select MAX(d.id) from SoftwareEngineering d")
    public abstract int maxSEStudents();
}
