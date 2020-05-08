package com.akukhtin.webgamecity.controller;

import com.akukhtin.webgamecity.exception.EnteredTheWrongLetter;
import com.akukhtin.webgamecity.model.City;
import com.akukhtin.webgamecity.service.CityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class CityController {
    public static String oldWord;
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/begin")
    public String begin() {
        City randomCityById = cityService.findRandomCityById();
        oldWord = randomCityById.getCityName();
        return oldWord;
    }

    @GetMapping("/next/{word}")
    public String nextWord(@PathVariable String word) {
        if (oldWord.charAt(oldWord.length() - 1) != word.charAt(0)) {
            try {
                throw new EnteredTheWrongLetter("Entered the wrong word");
            } catch (EnteredTheWrongLetter enteredTheWrongLetter) {
                enteredTheWrongLetter.printStackTrace();
            }
        }
        oldWord = cityService.findCityByCity(word);
        return oldWord;
    }

    @PostMapping("/end")
    public String end() {

        return "Thanks for game";
    }
}
