package jpaDB.mapping.controller;

import jpaDB.mapping.domain.Actor;
import jpaDB.mapping.domain.Art;
import jpaDB.mapping.repository.ArtSearch;
import jpaDB.mapping.service.ArtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {

    private final ArtService artService;

    @RequestMapping("/")
    public String home(Model model) {
        List<Art> arts = artService.findAllArts();
        model.addAttribute("arts", arts);
        return "/home";
    }
}
