package com.thefreaks.SRecruiter_java.Service;


import com.thefreaks.SRecruiter_java.Model.English;

import org.springframework.data.domain.Page;

public interface English_Service {
    void saveEnglishStudent(English english);
    English getEnglishStudentById(long id);
    void deleteEnglishStudentById(long id);

    Page<English> findPaginatedEnglishPage(int pageNumEnglish, int pageSizeEnglish);
}
