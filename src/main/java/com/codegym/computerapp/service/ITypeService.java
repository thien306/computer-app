package com.codegym.computerapp.service;

import com.codegym.computerapp.dto.ICountComputer;
import com.codegym.computerapp.model.Type;

public interface ITypeService extends IGenerateService<Type>{

    Iterable<ICountComputer> getCountComputer();

}
