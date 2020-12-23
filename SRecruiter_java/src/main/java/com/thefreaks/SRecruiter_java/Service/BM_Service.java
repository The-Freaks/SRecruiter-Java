package com.thefreaks.SRecruiter_java.Service;

import com.thefreaks.SRecruiter_java.Model.BusinessManagement;

import org.springframework.data.domain.Page;

public interface BM_Service {
    void saveBMStudent(BusinessManagement businessManagement);
    BusinessManagement getBMStudentById(long id);
    void deleteBMStudentById(long id);

    Page<BusinessManagement> findPaginatedBMPage(int pageNumBM, int pageSizeBM);
}
