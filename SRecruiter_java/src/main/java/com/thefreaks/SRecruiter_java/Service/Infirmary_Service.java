package com.thefreaks.SRecruiter_java.Service;

import com.thefreaks.SRecruiter_java.Model.Infirmary;

import org.springframework.data.domain.Page;

public interface Infirmary_Service {
    void saveInfirmaryStudent(Infirmary infirmary);
    Infirmary getInfirmaryStudentById(long id);
    void deleteInfirmaryStudentById(long id);

    Page<Infirmary> findPaginatedInfirmaryPage(int pageNumInfirmary, int pageSizeInfirmary);
}
