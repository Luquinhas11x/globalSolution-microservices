package br.com.fiap.globalSolution.service;

import br.com.fiap.globalSolution.model.Dispositivo;
import br.com.fiap.globalSolution.repository.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DispositivoService {
    @Autowired
    private DispositivoRepository dispositivoRepository;

    public List<Dispositivo> list() {
        return dispositivoRepository.findAll();
    }

    public Dispositivo save(Dispositivo cliente) {
        return dispositivoRepository.save(cliente);
    }

    public boolean existsById(Long id) {
        return dispositivoRepository.existsById(id);
    }

    public void delete(Long id) {
        dispositivoRepository.deleteById(id);
    }

    public Optional<Dispositivo> findById(Long id) {
        return dispositivoRepository.findById(id);
    }
}
