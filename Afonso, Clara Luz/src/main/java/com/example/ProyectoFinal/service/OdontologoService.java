package com.example.ProyectoFinal.service;
import com.example.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinal.repository.OdontologoRepository;
import com.example.ProyectoFinal.model.Odontologo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {
    //private IDao<Odontologo> odontologoIDao;
    private OdontologoRepository odontologoRepository;

    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public Odontologo guardar(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }

    public Odontologo buscar(Integer id) {
        Odontologo odontologo = null;
        Optional<Odontologo> optionalOdontologo= odontologoRepository.findById(id);
        if (optionalOdontologo.isPresent()){
            odontologo= optionalOdontologo.get();
        }
        return odontologo;
    }

    public List<Odontologo> buscarTodos() throws Exception {
        return odontologoRepository.findAll();
    }

    public void eliminar(Integer id) throws ResourceNotFoundException{
        //odontologoRepository.deleteById(id);

        if (this.buscar(id) == null)
            throw new ResourceNotFoundException("No existe un odontologo con el ID: " + id);
        odontologoRepository.deleteById(id);


    }

    public Odontologo actualizar(Odontologo odontologo) throws ResourceNotFoundException {
        if (this.buscar(odontologo.getId()) == null)
            throw new ResourceNotFoundException("No existe un odontologo con el ID: " + odontologo.getId());
        return odontologoRepository.save(odontologo);

    }
}
