package com.chewingk.sql.index.controller.impl;

import com.chewingk.sql.index.api.IIndexController;
import com.chewingk.sql.index.controller.service.IIndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
@RequiredArgsConstructor
public class IndexController implements IIndexController {
    private final IIndexService service;

    @PostMapping("/test-data")
    public void generateTestData() {
        service.generateTestData();
    }
}
