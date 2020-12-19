package com.thefreaks.SRecruiter_java.Service;

import java.util.List;

import com.thefreaks.SRecruiter_java.Model.English;

import org.springframework.data.domain.Page;

public interface English_Service {
    List<English> getAllEnglishStudents();
    void saveEnglishStudent(English english);
    English getEnglishStudentById(long id);
    void deleteEnglishStudentById(long id);

    Page<English> findPaginatedEnglishPage(int pageNumEnglish, int pageSizeEnglish);
}
