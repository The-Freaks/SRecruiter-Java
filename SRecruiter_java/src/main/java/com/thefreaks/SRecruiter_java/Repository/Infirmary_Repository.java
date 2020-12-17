package com.thefreaks.SRecruiter_java.Repository;

import com.thefreaks.SRecruiter_java.Model.Infirmary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Infirmary_Repository extends JpaRepository<Infirmary, Long>{
    @Query("select MAX(d.id) from Infirmary d")
    public abstract int maxInfirmaryStudents();
}
