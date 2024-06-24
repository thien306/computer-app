package com.codegym.computerapp.service.impl;


import com.codegym.computerapp.dto.ICountComputer;
import com.codegym.computerapp.model.Type;
import com.codegym.computerapp.repository.ITypeRepository;
import com.codegym.computerapp.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TypeServiceImpl implements ITypeService {

    @Autowired
    private ITypeRepository typeComputerRepository;

    @Override
    public Iterable<Type> findAll() {
        return typeComputerRepository.findAll();
    }

    @Override
    public Optional<Type> findById(Long id) {
        return typeComputerRepository.findById(id);
    }

    @Override
    public void save(Type typeComputer) {
        typeComputerRepository.save(typeComputer);
    }

    @Override
    public void delete(Long id) {
        typeComputerRepository.deleteById(id);
    }

    @Override
    public Iterable<ICountComputer> getCountComputer() {
        return typeComputerRepository.getCountComputer();
    }
}
