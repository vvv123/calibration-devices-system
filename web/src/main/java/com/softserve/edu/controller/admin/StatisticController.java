package com.softserve.edu.controller.admin;

import com.softserve.edu.dto.admin.CountDTO;
import com.softserve.edu.service.admin.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin/statistics/")
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @RequestMapping(value = "organizations", method = RequestMethod.GET)
    public CountDTO countOrganizations() {
        return new CountDTO(statisticService.countOrganizations());
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public CountDTO countUsers() {
        return new CountDTO(statisticService.countUsers());
    }

    @RequestMapping(value = "devices", method = RequestMethod.GET)
    public CountDTO countDevices() {
        return new CountDTO(statisticService.countDevices());
    }

    @RequestMapping(value = "verifications", method = RequestMethod.GET)
    public CountDTO countVerifications() {
        return new CountDTO(statisticService.countVerifications());
    }

}
