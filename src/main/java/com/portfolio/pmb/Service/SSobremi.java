/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.pmb.Service;

import com.portfolio.pmb.Entity.Sobremi;
import com.portfolio.pmb.Repository.RSobremi;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author walmart
 */
@Service
@Transactional
public class SSobremi {
    @Autowired
    RSobremi rSobremi;
    
    public List<Sobremi> list(){
        return rSobremi.findAll();
    }
    
    public Optional<Sobremi> getOne(int id){
        return rSobremi.findById(id);
    }
    
    public Optional<Sobremi> getByNombre(String nombre){
        return rSobremi.findByNombre(nombre);
    }
    
    public void save(Sobremi sobremi){
        rSobremi.save(sobremi);
    }
    
    public void delete(int id){
        rSobremi.deleteById(id);
    }
    public boolean existsById(int id){
        return rSobremi.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rSobremi.existsByNombre(nombre);
    }
}
