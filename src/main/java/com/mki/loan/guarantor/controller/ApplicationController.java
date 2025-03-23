package com.mki.loan.guarantor.controller;

import com.mki.loan.guarantor.db.model.Application;
import com.mki.loan.guarantor.db.repo.ApplicationRepo;
import com.mki.loan.guarantor.dto.AppRequest;
import com.mki.loan.guarantor.exception.ResourceNotFoundException;
import com.mki.loan.guarantor.exception.ValidationException;
import com.mki.loan.guarantor.util.EnumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/application")
public class ApplicationController {

    @Autowired
    private ApplicationRepo applicationRepo;

    @PostMapping(value = {"/create"})
    public ResponseEntity<String> createApp(@RequestBody AppRequest request) {
        if (applicationRepo.existsByAppId(request.getAppId())) {
            throw new ValidationException("Application ID already exists");
        }

        EnumUtil.EnumVar status = EnumUtil.EnumVar.fromValue(request.getStatus()).orElseThrow(() -> new ValidationException("Invalid status"));
        Application application = new Application(request.getAppId(), request.getName(), status);
        applicationRepo.save(application);

        return ResponseEntity.ok("Application created success");
    }

    @PostMapping(value = {"/list"})
    public ResponseEntity<List<Application>> listApp(@RequestBody AppRequest request) {
        String direction = "DESC";
        String field = "createdAt";
        Integer page = 0;
        Integer size = 999999;

        if (request.getPage() != null) {
            page = request.getPage();
        }

        if (request.getSize() != null) {
            size = request.getSize();
        }

        if (request.getSortDirection() != null && !request.getSortDirection().equalsIgnoreCase("")) {
            direction = request.getSortDirection();
        }

        if (request.getSortField() != null && !request.getSortField().equalsIgnoreCase("")) {
            field = request.getSortField();
        }

        Sort sort = Sort.by(Sort.Direction.fromString(direction), field);
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Application> apps = applicationRepo.findAll(pageable);
        return ResponseEntity.ok(apps.getContent());
    }

    @GetMapping("/{appId}")
    public ResponseEntity<Application> getApplicationByAppId(@PathVariable String appId) {
        Application app = applicationRepo.findByAppId(appId)
                .orElseThrow(() -> new ResourceNotFoundException("Application not found with ID: " + appId));

        return ResponseEntity.ok(app);
    }

}
