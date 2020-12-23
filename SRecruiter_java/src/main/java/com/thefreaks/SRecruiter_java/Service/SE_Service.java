package com.thefreaks.SRecruiter_java.Service;

import com.thefreaks.SRecruiter_java.Model.SoftwareEngineering;

import org.springframework.data.domain.Page;

public interface SE_Service {
    void saveSEStudent(SoftwareEngineering softwareEngineering);
    SoftwareEngineering getSEStudentById(long id);
    void deleteSEStudentById(long id);

    Page<SoftwareEngineering> findPaginatedSEPage(int pageNumSE, int pageSizeSE);
}
