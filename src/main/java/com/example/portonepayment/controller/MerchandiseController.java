package com.example.portonepayment.controller;


import com.example.portonepayment.entity.Merchandise;
import com.example.portonepayment.repository.ClientRepository;
import com.example.portonepayment.service.MerchandiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.NoSuchElementException;


@Controller
public class MerchandiseController {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private MerchandiseService merchandiseService;

    @GetMapping("/merchandise/list")
    public void list(Model model) {
        model.addAttribute("list", merchandiseService.findAll());
    }

    @GetMapping("/merchandise/insert")
    public void insert(Model model) {
        model.addAttribute("merchandise", new Merchandise());
    }

    @PostMapping("/merchandise/insert")
    public String insert(Merchandise merchandise) {
        merchandiseService.insert(merchandise);
        return "redirect:/merchandise/list";
    }

    @GetMapping("/merchandise/update")
    public void update(int num, Model model) {
        model.addAttribute("m", merchandiseService.findByNUM(num));
    }

    @GetMapping("/merchandise/detail")
    public String detail(int num, Model model) {
        String view = "/merchandise/detail";
        try {
            model.addAttribute("m", merchandiseService.findByNUM(num));
        } catch (NoSuchElementException e) {
            view = "/error";
            model.addAttribute("msg", "존재하지 않는 게시물");
        }
        return view;
    }
    @GetMapping("/merchandise/delete")
    public String delete(int num) {
        merchandiseService.delete(num);
        return "redirect:/merchandise/list";
    }
}
