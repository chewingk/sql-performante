package com.chewingk.sql.index.infrastructure.mapper;

import com.chewingk.sql.index.domain.persistent.EmployeePo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    void batchInsert(List<EmployeePo> employeePos);
}
