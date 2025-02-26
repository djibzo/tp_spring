package com.fall.tp_spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProduitVueController {
    @GetMapping("/")
    public String showProduitsPage() {
        return "produits";
    }
}
