package com.codegym.computerapp.fommater;

import com.codegym.computerapp.model.Type;
import com.codegym.computerapp.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class TypeComputerFormatter implements Formatter<Type> {

    private final ITypeService typeComputerService;

    @Autowired
    public TypeComputerFormatter(ITypeService typeComputerService) {
        this.typeComputerService = typeComputerService;
    }

    @Override
    public Type parse(String text, Locale locale) throws ParseException {
        Optional<Type> typeComputer = typeComputerService.findById(Long.parseLong(text));
        return typeComputer.orElse(null);
    }

    @Override
    public String print(Type object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
