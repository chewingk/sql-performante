package com.chewingk.sql.index.service.impl;

import com.chewingk.sql.index.controller.service.IIndexService;
import com.chewingk.sql.index.service.repository.IIndexRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IndexService implements IIndexService {

    private final IIndexRepository repository;

    @Override
    public void generateTestData() {
        repository.batchInsert(null);
    }
}
