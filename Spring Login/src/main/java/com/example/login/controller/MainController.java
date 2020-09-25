package com.example.login.controller;

import com.example.login.entity.Faculty;
import com.example.login.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private FacultyRepository facultyRepository;

    @GetMapping("/")
    public String greeting() {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Model model) {
        Iterable<Faculty> faculties = facultyRepository.findAll();

        model.addAttribute("faculties", faculties);

        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String name, Model model) {
        Faculty faculty = new Faculty(name);

        facultyRepository.save(faculty);
        Iterable<Faculty> faculties = facultyRepository.findAll();
        model.addAttribute("faculties", faculties);

        return "main";
    }


}
