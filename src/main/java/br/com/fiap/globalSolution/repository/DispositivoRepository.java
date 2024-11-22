package br.com.fiap.globalSolution.repository;

import br.com.fiap.globalSolution.model.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {
    <T> T findByNome(String nome, Class<T> type);
    <T> List<T> findAllByNome(String nome, Class<T> type);
    <T> List<T> findAllByNomeContains(String nome, Class<T> type);
}
