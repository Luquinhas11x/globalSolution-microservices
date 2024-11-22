package br.com.fiap.globalSolution.mapper;

import br.com.fiap.globalSolution.dto.DispositivoRequestCreateDto;
import br.com.fiap.globalSolution.dto.DispositivoRequestUpdateDto;
import br.com.fiap.globalSolution.dto.DispositivoResponseDto;
import br.com.fiap.globalSolution.model.Dispositivo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DispositivoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public DispositivoResponseDto toDto(Dispositivo dispositivo) {
        return modelMapper.map(dispositivo, DispositivoResponseDto.class);
    }

    public Dispositivo toModel(DispositivoRequestCreateDto dto) {
        return modelMapper.map(dto, Dispositivo.class);
    }

    public Dispositivo toModel(Long id, DispositivoRequestUpdateDto dto) {
        Dispositivo result = modelMapper.map(dto, Dispositivo.class);
        result.setId(id);
        return result;
    }
}
