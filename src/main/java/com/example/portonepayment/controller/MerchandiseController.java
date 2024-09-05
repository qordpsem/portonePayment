package com.example.portonepayment.controller;


import com.example.portonepayment.entity.Merchandise;
import com.example.portonepayment.repository.ClientRepository;
import com.example.portonepayment.service.MerchandiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


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
    @PreAuthorize("hasRole('admin')")
    public void insert(Model model) {
        model.addAttribute("merchandise", new Merchandise());
    }

    @PostMapping("/merchandise/insert")
    @PreAuthorize("hasRole('admin')")
    public String insert(Merchandise merchandise) {
        merchandiseService.insert(merchandise);
        return "redirect:/merchandise/list";
    }
}
