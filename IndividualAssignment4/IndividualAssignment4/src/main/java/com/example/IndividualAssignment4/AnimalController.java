package com.example.IndividualAssignment4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping("/all")
    public List<Animal> getAllAnimals(){
        return animalService.getAllAnimals();
    }
    @GetMapping("/{animalId}")
    public Animal getAnimalById(@PathVariable int animalId){
        return animalService.getAnimalById(animalId);
    }
    @PostMapping("/new")
    public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal){
        animalService.addNewAnimal(animal);
        return ResponseEntity.ok(animal);
    }
    @PutMapping("{/animalId}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable int animalId, @RequestBody Animal animal){
        animalService.updateAnimal(animalId,animal);
        return ResponseEntity.ok(animalService.getAnimalById(animalId));
    }
    @DeleteMapping("/delete/{animalId}")
    public List<Animal> deleteAnimalById(@PathVariable int animalId){
        animalService.deleteAnimalById(animalId);
        return animalService.getAllAnimals();
    }
}
