package com.thefreaks.SRecruiter_java.Repository;

import com.thefreaks.SRecruiter_java.Model.English;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface English_Repository extends JpaRepository<English, Long>{
}
