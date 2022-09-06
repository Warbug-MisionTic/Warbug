package com.misiontic.warbug.service;

import com.misiontic.warbug.models.Employee;
import com.misiontic.warbug.models.Enterprise;
import net.bytebuddy.asm.Advice;

import java.util.List;

public interface IEnterpriseService {

    Enterprise create(Enterprise enterprise) throws Exception;
    Enterprise update(Enterprise enterprise, Long id) throws Exception;
    List<Enterprise> readAll() throws Exception;
    Enterprise readById(Long id) throws Exception;
    void delete(Long id) throws Exception;
    Enterprise saveTransactional(Enterprise enterprise, List<Employee> details);

}
