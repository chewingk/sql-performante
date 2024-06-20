package com.chewingk.sql.index.service.repository;

import com.chewingk.sql.index.domain.persistent.EmployeePo;

import java.util.List;

public interface IIndexRepository {
    void batchInsert(List<EmployeePo> employeePos);
}
