package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImpl;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarServiceImpl carService;

// Другой способ чере @PathVariable
//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, ModelMap model) {
//        model.addAttribute("car", carService.show(id));
//        return "show";
//    }

    @GetMapping(value = "/cars")
    public String show(@RequestParam(required = false) Integer count, ModelMap model) {
        List<Car> cars;
        if(count != null) {
            cars = carService.show(count);
        } else {
            cars = carService.index();
        }
        model.addAttribute("cars", cars);
        return "cars";
    }
}
