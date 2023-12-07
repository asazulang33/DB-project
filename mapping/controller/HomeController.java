package jpaDB.mapping.controller;

import jpaDB.mapping.domain.Art;
import jpaDB.mapping.repository.ArtSearch;
import jpaDB.mapping.service.ArtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    // 장르별 검색 + 작품명 검색 + 페이징 + 컨텐츠 4개씩 표시
    @RequestMapping("/")
    public String home(@ModelAttribute("artSearch") ArtSearch artSearch,
                       @RequestParam(value="genreStatus", required=false) String genreStatus,
                       @RequestParam(value="page", defaultValue="0") int page,
                       Model model) {

        artService.setArtSearchGenre(artSearch, genreStatus);

        List<Art> allArts = artService.findArts(artSearch);
        model.addAttribute("allArts", allArts);

        Page<Art> paging = artService.findArtsPage(artSearch, PageRequest.of(page, 4));
        model.addAttribute("paging", paging);

        return "/main";
    }
}
