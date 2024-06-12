package com.example.todov1.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.todov1.entities.Tasks;
import com.example.todov1.repository.TasksRepo;


@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    TasksRepo tp;

    @GetMapping
    public String displayTasks(Model model) {

        List<Tasks> tasks = tp.findAll();
        model.addAttribute("tasks", tasks);
        return "main/home";

    }

    @RequestMapping("/new")
    public String displayHome(Model model) {

        Tasks aTask = new Tasks();
        model.addAttribute("tasks", aTask);
        return "main/form";

    }

    @PostMapping(value = "/save")
    public String processForm(Tasks tasks, Model model) {

        tp.save(tasks);
        return "redirect:/";


    }

    @GetMapping("/edit/{id}")
    public String editTutorial(@PathVariable("id") long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Tasks aTask =  tp.findById(id).get();
            model.addAttribute("tasks", aTask);
            tp.deleteById(id);

            return "main/form";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());

            return "redirect:/";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteTutorial(@PathVariable("id") long id, Model model, RedirectAttributes redirectAttributes) {
        try {
           tp.deleteById(id);

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }

        return "redirect:/";
    }

}

