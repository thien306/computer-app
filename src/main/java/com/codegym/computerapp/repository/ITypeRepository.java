package com.codegym.computerapp.repository;

import com.codegym.computerapp.dto.ICountComputer;
import com.codegym.computerapp.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeRepository extends JpaRepository<Type, Long> {

    @Query(nativeQuery = true, value = "select type.name, count(c.name) as number from type left join computer_app.computer c on type.id = c.type_id group by type.name;")
    Iterable<ICountComputer> getCountComputer();
}
