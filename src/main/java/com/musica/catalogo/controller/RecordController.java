package com.musica.catalogo.controller;

import com.musica.catalogo.model.Vinilo;
import com.musica.catalogo.repository.ViniloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
RestController: RestController is used for making restful web services with the help of the @RestController annotation.
This annotation is used at the class level and allows the class to handle the requests made by the client.
The RestController allows to handle all REST APIs such as GET, POST, Delete, PUT requests.
*/
@RestController
@RequestMapping("/") // This annotation maps HTTP requests to handler methods of MVC and REST controllers.
public class RecordController {
    @Autowired  // to inject this repository by Spring
    private ViniloRepository viniloRepository; // we inject the ViniloRepository to have access to the JpaRepository

    /*
     * Typically, if we want to implement the URL handler using traditional @RequestMapping annotation, it would have been something like this:
     * @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
     * The new approach makes it possible to shorten this simply to:
     * @GetMapping("/get/{id}")
     * */
    // get all records
    @GetMapping("/listar")
    public List<Vinilo> getAllRecords() {
        return viniloRepository.findAll();
    }

    /*
    The @RequestBody annotation is applicable to handler methods of Spring controllers.
    This annotation indicates that Spring should deserialize a request body into an object.
    This object is passed as a handler method parameter.
    */
    @PostMapping(value = "/guardarvinilo")
    public String saveTask(@RequestBody Vinilo vinilo){
        viniloRepository.save(vinilo);
        return "Vinilo guardado";
    }

    @DeleteMapping(value="borrarvinilo/{id}")
    public String deleteVinilo(@PathVariable long id){
        Vinilo deletedVinilo = viniloRepository.findById(id).get();
        viniloRepository.delete(deletedVinilo);
        return "Vinilo borrado";
    }

    @PutMapping(value="/modificar/{id}")
    public String updateVinilo(@PathVariable long id, @RequestBody Vinilo vinilo){
        Vinilo updatedVinilo = viniloRepository.findById(id).get();
        updatedVinilo.setRecord_Name(vinilo.getRecord_Name());
        updatedVinilo.setBand_name(vinilo.getBand_name());
        updatedVinilo.setYear(vinilo.getRecord_Year());
        viniloRepository.save(updatedVinilo);
        return "Vinilo modificado";
    }


}
