package com.codegym.computerapp.controller;

import com.codegym.computerapp.dto.ICountComputer;
import com.codegym.computerapp.fommater.TypeComputerFormatter;
import com.codegym.computerapp.form.TypeForm;
import com.codegym.computerapp.model.Type;
import com.codegym.computerapp.service.IComputerService;
import com.codegym.computerapp.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.util.Optional;

@Controller
@RequestMapping("/types")
@PropertySource("classpath:upload_file.properties")
public class TypeController {

    @Value("${upload}")
    private String upload;

    @Autowired
    private ITypeService typeService;

    @Autowired
    private IComputerService computerService;

    @GetMapping
    public ModelAndView homeTypeComputer() {
        ModelAndView modelAndView = new ModelAndView("/type/home");
        Iterable<Type> typeIterable = typeService.findAll();
        modelAndView.addObject("type", typeIterable);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createTypeComputer() {
        ModelAndView modelAndView = new ModelAndView("/type/create");
        modelAndView.addObject("type", new TypeForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveTypeComputer(TypeForm typeForm, RedirectAttributes attributes) throws Exception {

        MultipartFile multipartFile = typeForm.getImage();
        String fileImage = multipartFile.getOriginalFilename();

        File uploadDir = new File(upload);
        if (uploadDir.exists()) {
            uploadDir.mkdir();
        }

        File subDir = new File(uploadDir, "image");
        if (!subDir.exists()) {
            subDir.mkdir();
        }


        FileCopyUtils.copy(multipartFile.getBytes(), new File(subDir, fileImage));
        Type type = new Type();
        type.setId((long) (Math.random() * 10000));
        type.setName(typeForm.getName());
        type.setImage("image/" + fileImage);
        typeService.save(type);
        attributes.addFlashAttribute("message", "add new of computer successfully");
        return "redirect:/types";
    }

//    @GetMapping("/update/{id}")
//    public ModelAndView formUpdate(@PathVariable Long id) {
//        ModelAndView modelAndView = new ModelAndView("/type/update");
//        modelAndView.addObject("type", typeService.findById(id));
//        return modelAndView;
//    }

    @GetMapping("/update/{id}")
    public ModelAndView formUpdate(@PathVariable Long id, RedirectAttributes attributes) {
        ModelAndView modelAndView = new ModelAndView("/type/update");
        Optional<Type> findById = typeService.findById(id);

        if (findById.isPresent()) {
            modelAndView.addObject("type", findById.get());
        } else {
            attributes.addFlashAttribute("error", "No computer type found");
            modelAndView.setViewName("redirect:/types");
        }

        return modelAndView;
    }


    @PostMapping("/update")
    public String updateTypeComputer(TypeForm typeForm, RedirectAttributes attributes) throws Exception {
        Optional<Type> optionalType = typeService.findById(typeForm.getId());
        MultipartFile file = typeForm.getImage();

        if (optionalType.isPresent()) {
            Type type = optionalType.get();

            if (file != null && !file.isEmpty()) {
                File uploadDir = new File(upload);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }

                File subDir = new File(upload, "image");
                if (!subDir.exists()) {
                    subDir.mkdir();
                }

                String fileImage = file.getOriginalFilename();
                FileCopyUtils.copy(file.getBytes(), new File(subDir, fileImage));
                type.setImage("image/" + fileImage);
            } else {
                type.setImage(typeForm.getImage().getOriginalFilename());
            }

            type.setName(typeForm.getName());
            typeService.save(type);
            attributes.addFlashAttribute("message", "Type computer update successful");
            return "redirect:/types";
        } else {
            attributes.addFlashAttribute("error", "Type not found");
            return "redirect:/types";
        }
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteTypeComputer(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/type/home");
        typeService.findById(id);

    }



    @GetMapping("/view/{id}")
    public ModelAndView typeComputer(@PathVariable Long id) {
        Optional<Type> findType = typeService.findById(id);

        if (findType.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/type/typeComputer");
            Iterable<ICountComputer> computers = typeService.getCountComputer();
            modelAndView.addObject("type", computers);
            return modelAndView;
        }
        return new ModelAndView("/error");
    }

}
