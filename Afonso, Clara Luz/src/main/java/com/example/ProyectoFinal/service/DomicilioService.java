package com.example.ProyectoFinal.service;

import com.example.ProyectoFinal.repository.DomicilioRepository;
import com.example.ProyectoFinal.model.Domicilio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService {
    //private IDao<Domicilio> domicilioDao;
    private DomicilioRepository domicilioRepository;

    /*public DomicilioService(IDao<Domicilio> domicilioDao) {
        this.domicilioDao = domicilioDao;
    }*/

    //Nuevo constructor(Inyecta la dependencia del repository)
    public DomicilioService(DomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }

    public Domicilio guardar(Domicilio d){
        //domicilioDao.guardar(d);
        //return d;
        return domicilioRepository.save(d);
    }

    public Domicilio buscar(Integer id){
        //return domicilioDao.buscar(id);
        Optional<Domicilio> domicilio = domicilioRepository.findById(id);
        if(domicilio == null){
            return null;
        }
        return domicilio.get();

    }

    public List<Domicilio> buscarTodos() throws Exception {
        //return domicilioDao.buscarTodos();
        return domicilioRepository.findAll();
    }
    public void eliminar(Integer id){
        //domicilioDao.eliminar(id);
        domicilioRepository.deleteById(id);
    }

}
