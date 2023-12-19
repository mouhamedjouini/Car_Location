package com.example.med.car_location.Controller;

import com.example.med.car_location.entities.Voiture;
import com.example.med.car_location.service.VoitureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/voiture")
public class VoitureController {

        private final VoitureService voitureService;

    public VoitureController( VoitureService voitureService) {
        super();
        this.voitureService = voitureService;

    }

    @PostMapping()
        public ResponseEntity<Voiture> saveVoiture(@RequestBody Voiture
                                                             voiture){
            return new
                    ResponseEntity<Voiture>(voitureService.saveVoiture(voiture),
                    HttpStatus.CREATED);
        }
        // build get all employees REST API
        @GetMapping
        public List<Voiture> getAllVoitures(){
            return voitureService.getAllVoiture();
        }
        // build get employee by id REST API
// http://localhost:8080/api/employees/1
        @GetMapping("{id}")
        @ResponseBody
        public ResponseEntity<Voiture> getvoitureById(@PathVariable("id")
                                                        long voitureId){
            return new
                    ResponseEntity<Voiture>(voitureService.getVoitureById(voitureId),
                    HttpStatus.OK);
        }
        // build update employee REST API

        @PutMapping("{id}")
        public ResponseEntity<Voiture> updateVoiture(@PathVariable("id")
                                                       long id
                ,@RequestBody Voiture voiture){
            return new
                    ResponseEntity<Voiture>(voitureService.updateVoiture(voiture,id),
                    HttpStatus.OK);
        }
    @RequestMapping(method = RequestMethod.PUT)
    public Voiture updateProduit(@RequestBody Voiture voiture) {
        return voitureService.updateVoiture(voiture);
    }

    // build delete employee REST API

        @DeleteMapping("{id}")
        public ResponseEntity<String> deleteVoiture(@PathVariable("id") long
                                                             id){
// delete employee from DB
            voitureService.deleteVoitureById(id);
            return new ResponseEntity<String>("voiture deleted successfully!.", HttpStatus.OK);
        }
    @RequestMapping(value="/VoitureMar/{idMar}",method = RequestMethod.GET)
    public List<Voiture> getVoitureByMarId(@PathVariable("idMar") Long idMar) {
        return voitureService.findByMarqueIdMar(idMar);
    }

}

