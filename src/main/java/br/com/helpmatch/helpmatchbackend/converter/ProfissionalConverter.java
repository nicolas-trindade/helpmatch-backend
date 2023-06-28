package br.com.helpmatch.helpmatchbackend.converter;

import br.com.helpmatch.helpmatchbackend.controller.request.ProfissionalRequest;
import br.com.helpmatch.helpmatchbackend.controller.response.ProfissionalResponse;
import br.com.helpmatch.helpmatchbackend.dto.ProfissionalDto;
import br.com.helpmatch.helpmatchbackend.entities.Profissional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProfissionalConverter {
    @Autowired
    private ModelMapper mapper;

    public ProfissionalDto converterRequestToDto(ProfissionalRequest request){
        return mapper.map( request, ProfissionalDto.class );
    }
    public ProfissionalDto converterEntityToDto(Profissional entity){
        return mapper.map( entity, ProfissionalDto.class );
    }
    public ProfissionalResponse converterDtoToResponse(ProfissionalDto request){
        return mapper.map( request, ProfissionalResponse.class );
    }
    public Profissional converterDtoToEntity(ProfissionalDto request){
        return mapper.map( request, Profissional.class );
    }

    public List<ProfissionalResponse> converterListDtoToListResponse(List<ProfissionalDto> listDto){

        return listDto.stream().map(clienteEntity -> mapper.map(clienteEntity, ProfissionalResponse.class)).collect(Collectors.toList());
    }

    public List<ProfissionalDto> converterListEntityToListDto(Collection<Profissional> listEntity){

        return listEntity.stream().map(clienteEntity -> mapper.map(clienteEntity, ProfissionalDto.class)).collect(Collectors.toList());

    }

}
