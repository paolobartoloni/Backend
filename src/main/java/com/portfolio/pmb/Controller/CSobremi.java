/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.pmb.Controller;

import com.portfolio.pmb.Dto.dtoSobremi;
import com.portfolio.pmb.Entity.Sobremi;
import com.portfolio.pmb.Security.Controller.Mensaje;
import com.portfolio.pmb.Service.SSobremi;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author walmart
 */
@RestController
@RequestMapping("/sobremi")
@CrossOrigin(origins = {"https://portfoliopmb2.web.app","http://localhost:4200"})
public class CSobremi {
    @Autowired
    SSobremi sSobremi;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Sobremi>> list(){
        List<Sobremi> list = sSobremi.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Sobremi> getById(@PathVariable("id") int id){
        if(!sSobremi.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Sobremi sobremi = sSobremi.getOne(id).get();
        return new ResponseEntity(sobremi, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sSobremi.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sSobremi.delete(id);
        return new ResponseEntity(new Mensaje("sobremi eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSobremi dtosobremi){      
        if(StringUtils.isBlank(dtosobremi.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sSobremi.existsByNombre(dtosobremi.getNombre()))
            return new ResponseEntity(new Mensaje("Esa sobremi existe"), HttpStatus.BAD_REQUEST);
        
        Sobremi sobremi = new Sobremi(dtosobremi.getNombre(), dtosobremi.getDescripcion());
        sSobremi.save(sobremi);
        
        return new ResponseEntity(new Mensaje("sobremi agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSobremi dtosobremi){
        //Validamos si existe el ID
        if(!sSobremi.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(sSobremi.existsByNombre(dtosobremi.getNombre()) && sSobremi.getByNombre(dtosobremi.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa sobremi ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtosobremi.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Sobremi sobremi = sSobremi.getOne(id).get();
        sobremi.setNombre(dtosobremi.getNombre());
        sobremi.setDescripcion(dtosobremi.getDescripcion());
        
        sSobremi.save(sobremi);
        return new ResponseEntity(new Mensaje("sobremi actualizada"), HttpStatus.OK);
             
    }
    
}
