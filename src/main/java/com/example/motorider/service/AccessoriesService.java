package com.example.motorider.service;

import com.example.motorider.dto.request.AccessoriesRequestDto;
import com.example.motorider.dto.response.AccessoriesResponseDto;
import com.example.motorider.entitiy.Accessories;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.motorider.repository.AccessoriesRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccessoriesService {
    private final AccessoriesRepository accessoriesRepository;
    private final ModelMapper modelMapper;


    public String createAccessories(AccessoriesRequestDto accessoriesRequestDto) {
        Accessories accessories = modelMapper.map(accessoriesRequestDto, Accessories.class);
        accessoriesRepository.save(accessories);
        return "Accessories created";

    }

    public List<AccessoriesResponseDto> getAllAccessories() {
        List<Accessories> accessories = accessoriesRepository.findAll();
        List<AccessoriesResponseDto> accessoriesList = accessories.stream().map(a -> modelMapper.map(a, AccessoriesResponseDto.class)).toList();
        return accessoriesList;
    }

    public String updateAccessories(AccessoriesRequestDto accessoriesRequestDto, Long id) {
        Accessories accessories = accessoriesRepository.findById(id).orElseThrow();
        accessoriesRepository.save(accessories);
        return "Accessories updated";
    }

    public String deleteAccessories(Long id) {
        accessoriesRepository.deleteById(id);
        return "Accessories deleted";
    }

}
