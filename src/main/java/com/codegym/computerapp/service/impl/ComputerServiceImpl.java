package com.codegym.computerapp.service.impl;

import com.codegym.computerapp.model.Computer;
import com.codegym.computerapp.model.Type;
import com.codegym.computerapp.repository.IComputerRepository;
import com.codegym.computerapp.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComputerServiceImpl implements IComputerService {

    @Autowired
    private IComputerRepository computerRepository;

    @Override
    public Iterable<Computer> findAllType(Type typeComputer) {
        return computerRepository.findAllByType(typeComputer);
    }

    @Override
    public Page<Computer> findAll(Pageable pageable) {
        return computerRepository.findAll(pageable);
    }

    @Override
    public Page<Computer> findAllByName(Pageable pageable, String name) {
        return computerRepository.findAllByName(pageable, name);
    }

    @Override
    public Iterable<Computer> findAll() {
        return computerRepository.findAll();
    }

    @Override
    public Optional<Computer> findById(Long id) {
        return computerRepository.findById(id);
    }

    @Override
    public void save(Computer computer) {
        computerRepository.save(computer);
    }

    @Override
    public void delete(Long id) {
        computerRepository.deleteById(id);
    }
}
