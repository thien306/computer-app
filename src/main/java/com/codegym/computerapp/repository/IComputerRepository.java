package com.codegym.computerapp.repository;

import com.codegym.computerapp.model.Computer;
import com.codegym.computerapp.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComputerRepository extends PagingAndSortingRepository<Computer, Long> {

    Iterable<Computer> findAllByType(Type typeComputer);

    Page<Computer> findAll(Pageable pageable);

    Page<Computer> findAllByName(Pageable pageable, String name);

//    Page<Computer> findAllByTypeComputer(Computer computer, TypeComputer typeComputer);
}
