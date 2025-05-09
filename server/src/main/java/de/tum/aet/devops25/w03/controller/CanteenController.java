package de.tum.aet.devops25.w03.controller;

import de.tum.aet.devops25.w03.model.Dish;
import de.tum.aet.devops25.w03.service.CanteenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CanteenController {

    private final CanteenService canteenService;

    public CanteenController(CanteenService canteenService) {
        this.canteenService = canteenService;
    }

    /**
     * Get today's meals for a specific canteen
     * @param canteenName the ID of the canteen (e.g., "mensa-garching")
     * @return list of dishes available today at the specified canteen
     */
    @GetMapping("/{canteenName}/today")
    public ResponseEntity<List<Dish>> getTodayMeals(@PathVariable String canteenName) {
        List<Dish> todayMeals = canteenService.getTodayMeals(canteenName); 
        return ResponseEntity.ok(todayMeals);
    }
}
