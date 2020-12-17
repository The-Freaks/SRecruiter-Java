package com.thefreaks.SRecruiter_java.Repository;

import com.thefreaks.SRecruiter_java.Model.BusinessManagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BM_Repository extends JpaRepository<BusinessManagement, Long>{
    @Query("select MAX(d.id) from BusinessManagement d")
    public abstract int maxBMStudents();
}
