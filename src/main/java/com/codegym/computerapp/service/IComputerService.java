package com.codegym.computerapp.service;

import com.codegym.computerapp.model.Computer;
import com.codegym.computerapp.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IComputerService extends IGenerateService<Computer> {

    Iterable<Computer> findAllType(Type type);

    Page<Computer> findAll(Pageable pageable);

    Page<Computer> findAllByName(Pageable pageable, String name);
}
