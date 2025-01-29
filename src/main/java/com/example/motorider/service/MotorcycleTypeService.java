package com.example.motorider.service;

import com.example.motorider.dto.request.MotocycleTypeRequestDto;
import com.example.motorider.dto.response.MotorcycleTypeResponseDto;
import com.example.motorider.entity.MotorcycleType;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.motorider.repository.MotorcycleTypeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MotorcycleTypeService {
    private final MotorcycleTypeRepository motorcycleTypeRepository;
    private final ModelMapper modelMapper;


    public String createMotorcycleType(MotocycleTypeRequestDto motocycleTypeRequestDto) {
        MotorcycleType motorcycleType = modelMapper.map(motocycleTypeRequestDto, MotorcycleType.class);
        motorcycleTypeRepository.save(motorcycleType);
        return "Successfully created motorcycle type";
    }

    public List<MotorcycleTypeResponseDto> getAllMotorcycleTypes() {
        List<MotorcycleType> motorcycleTypeList = motorcycleTypeRepository.findAll();
        List<MotorcycleTypeResponseDto> motorcycleTypeResponseDtoList = motorcycleTypeList.stream().map(m -> modelMapper.map(m, MotorcycleTypeResponseDto.class)).toList();
        return motorcycleTypeResponseDtoList;
    }


    public String updatemotorcycleType(MotocycleTypeRequestDto motocycleTypeRequestDto, Long id) {
        MotorcycleType motorcycleType = motorcycleTypeRepository.findById(id).orElseThrow();
        modelMapper.map(motocycleTypeRequestDto, motorcycleType);
        motorcycleTypeRepository.save(motorcycleType);
        return "Successfully updated motorcycle type";
    }


    public String deleteMotorcycleType(Long id) {
        motorcycleTypeRepository.deleteById(id);
        return "Successfully deleted motorcycle type";
    }
}
