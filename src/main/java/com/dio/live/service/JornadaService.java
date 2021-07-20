package com.dio.live.service;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.repository.JornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JornadaService {

    @Autowired
    JornadaRepository jornadaRepository;

    public JornadaTrabalho save(JornadaTrabalho jornadaTrabalho){
        return jornadaRepository.save(jornadaTrabalho);
    }

    public List<JornadaTrabalho> findAll() {
        return jornadaRepository.findAll();
    }

    public JornadaTrabalho update(Long id, JornadaTrabalho jornadaTrabalho){
        try {
            JornadaTrabalho entity = jornadaRepository.getOne(id);
            entity.setDescricao(jornadaTrabalho.getDescricao());
            return jornadaRepository.save(entity);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return jornadaRepository.save(jornadaTrabalho);
    }

    public void delete(Long id){
        jornadaRepository.deleteById(id);
    }

    public Optional<JornadaTrabalho> findById(Long id) {
        return jornadaRepository.findById(id);
    }
}
