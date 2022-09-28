package com.tkachev.controller.impl;

import com.tkachev.controller.ServiceController;
import com.tkachev.dto.ServiceDto;
import com.tkachev.service.ServiceService;
import com.tkachev.util.sorting.sort_type.ServiceSortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.SortOrder;
import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceControllerImpl implements ServiceController {

    @Autowired
    private ServiceService serviceService;

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('services:write')")
    public ServiceDto addService(@RequestBody ServiceDto serviceDto) {
        return serviceService.addService(serviceDto);
    }

    @Override
    @PutMapping
    @PreAuthorize("hasAuthority('services:write')")
    public ServiceDto updateService(@RequestBody ServiceDto serviceDto) {
        return serviceService.updateService(serviceDto);
    }

    @Override
    @GetMapping
    @PreAuthorize("hasAuthority('services:read')")
    public List<ServiceDto> getServices(@RequestParam(name = "sort-type", defaultValue = "BY_ID") ServiceSortType sortType,
                                     @RequestParam(name = "sort-order", defaultValue = "ASCENDING") SortOrder sortOrder) {

        return serviceService.getServices(sortType, sortOrder);
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('services:read')")
    public ServiceDto getServiceById(@PathVariable Integer id) {
        return serviceService.getServiceById(id);
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('services:write')")
    public String deleteService(@PathVariable Integer id) {
        serviceService.deleteService(id);

        return "Service with ID = " + id + " has been deleted";
    }
}
