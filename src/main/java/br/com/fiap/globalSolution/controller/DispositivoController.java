package br.com.fiap.globalSolution.controller;

import br.com.fiap.globalSolution.dto.DispositivoRequestCreateDto;
import br.com.fiap.globalSolution.dto.DispositivoRequestUpdateDto;
import br.com.fiap.globalSolution.dto.DispositivoResponseDto;
import br.com.fiap.globalSolution.mapper.DispositivoMapper;
import br.com.fiap.globalSolution.repository.DispositivoRepository;
import br.com.fiap.globalSolution.service.DispositivoService;
import br.com.fiap.globalSolution.view.DispositivoFullView;
import br.com.fiap.globalSolution.view.DispositivoSimpleView;
import br.com.fiap.globalSolution.view.DispositivoViewType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dispositivos")
@RequiredArgsConstructor
public class DispositivoController {

    private final DispositivoService dispositivoService;
    private final DispositivoMapper dispositivoMapper;
    private final DispositivoRepository dispositivoRepository;

    @GetMapping
    public ResponseEntity<List<DispositivoResponseDto>> list() {
        List<DispositivoResponseDto> dtos = dispositivoService.list()
                .stream()
                .map(dispositivoMapper::toDto)
                .toList();

        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<DispositivoResponseDto> create(@RequestBody DispositivoRequestCreateDto dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        dispositivoMapper.toDto(
                                dispositivoService.save(dispositivoMapper.toModel(dto)))
                );
    }

    @PutMapping("{id}")
    public ResponseEntity<DispositivoResponseDto> update(
            @PathVariable Long id,
            @RequestBody DispositivoRequestUpdateDto dto) {
        if (!dispositivoService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }
        return ResponseEntity.ok()
                .body(
                        dispositivoMapper.toDto(
                                dispositivoService.save(dispositivoMapper.toModel(id, dto)))
                );
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (!dispositivoService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }

        dispositivoService.delete(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<DispositivoResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(
                        dispositivoService
                                .findById(id)
                                .map(dispositivoMapper::toDto)
                                .orElseThrow(() -> new RuntimeException("Id inexistente"))
                );
    }

    @GetMapping("/find")
    public  ResponseEntity<?> findByNome(
            @RequestParam String nome,
            DispositivoViewType type) {

        return switch (type) {
            case FULL -> ResponseEntity.ok().body(dispositivoRepository.findAllByNomeContains(nome, DispositivoFullView.class));
            case SIMPLE ->
                    ResponseEntity.ok().body(dispositivoRepository.findAllByNomeContains(nome, DispositivoSimpleView.class));
        };
    }
}
