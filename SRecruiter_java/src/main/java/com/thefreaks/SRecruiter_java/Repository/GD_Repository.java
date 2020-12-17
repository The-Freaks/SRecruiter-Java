package com.thefreaks.SRecruiter_java.Repository;

import com.thefreaks.SRecruiter_java.Model.GraphicDesign;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GD_Repository extends JpaRepository<GraphicDesign, Long>{
    @Query("select MAX(d.id) from GraphicDesign d")
    public abstract int maxGDStudents();
}
