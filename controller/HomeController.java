package jpaDB.mapping.controller;

import jpaDB.mapping.domain.Art;
import jpaDB.mapping.repository.ArtSearch;
import jpaDB.mapping.service.ArtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {

    private final ArtService artService;

//    @RequestMapping("/")
//    public String home(@ModelAttribute("artSearch") ArtSearch artSearch,
//                       @RequestParam(value = "page", defaultValue = "0") int page,
//                       Model model) {
//        List<Art> arts = artService.findArts(artSearch);
//        model.addAttribute("arts", arts);
//
//        return "/mainV2";
//    }

    @RequestMapping("/")
    public String home(@ModelAttribute("artSearch") ArtSearch artSearch,
                       @RequestParam(value="page", defaultValue="0") int page,
                       Model model) {
        List<Art> arts = artService.findArts(artSearch); // 카카오맵에 필요한 arts 리스트
        model.addAttribute("arts", arts);

        Page<Art> paging = artService.findArts(PageRequest.of(page, 4)); // 페이징 처리
        model.addAttribute("paging", paging);

        return "/main";
    }
}
