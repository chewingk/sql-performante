package com.chewingk.sql.index.infrastructure.repository;

import com.chewingk.sql.index.domain.persistent.EmployeePo;
import com.chewingk.sql.index.infrastructure.mapper.EmployeeMapper;
import com.chewingk.sql.index.service.repository.IIndexRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class IndexRepository implements IIndexRepository {
    private final EmployeeMapper mapper;

    public void batchInsert(List<EmployeePo> employeePos) {
        mapper.batchInsert(employeePos);
    }
}
