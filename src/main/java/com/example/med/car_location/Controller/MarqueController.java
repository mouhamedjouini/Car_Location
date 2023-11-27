package com.example.med.car_location.Controller;

import com.example.med.car_location.entities.Marque;
import com.example.med.car_location.entities.Voiture;
import com.example.med.car_location.service.MarqueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Marque")
public class MarqueController {
    private final MarqueService marqueService;

    public MarqueController(MarqueService marqueService) {
        super();
        this.marqueService = marqueService;
    }
    @PostMapping()
    public ResponseEntity<Marque> saveMarque(@RequestBody Marque
                                                       marque){
        return new
                ResponseEntity<Marque>(marqueService.saveMarque(marque),
                HttpStatus.CREATED);
    }
    // build get all employees REST API
    @GetMapping
    public List<Marque> getAllMarques(){
        return marqueService.getAllMarque();
    }
    // build get employee by id REST API

    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<Marque> getMarqueById(@PathVariable("id")
                                                  long idMar){
        return new
                ResponseEntity<Marque>(marqueService.getMarqueById(idMar),
                HttpStatus.OK);
    }
    // build update employee REST API

    @PutMapping("{id}")
    public ResponseEntity<Marque> updateMarque(@PathVariable("id")
                                                 long id
            ,@RequestBody Marque marque){
        return new
                ResponseEntity<Marque>(marqueService.updateMarque(marque,id),
                HttpStatus.OK);
    }
    // build delete employee REST API

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteVoiture(@PathVariable("id") long
                                                        id){
// delete employee from DB
        marqueService.deleteMarqueById(id);
        return new ResponseEntity<String>("Marque deleted successfully!.", HttpStatus.OK);
    }
}
