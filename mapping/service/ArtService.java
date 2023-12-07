package jpaDB.mapping.service;

import jpaDB.mapping.domain.*;
import jpaDB.mapping.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ArtService {

    private final ArtRepository artRepository;
    private final GenreRepository genreRepository;


    public List<Art> findAllArts() {
        return artRepository.findAllArts();
    }

    // 모든 작품을 찾는 기능
    public List<Art> findArts(ArtSearch artSearch) {
        return artRepository.findAll(artSearch);
    }

    // 작품 검색 및 페이징 기능
    public Page<Art> findArtsPage(ArtSearch artSearch, Pageable pageable) {
        return artRepository.findArtsPage(artSearch, pageable);
    }

    // URL 장르 검색을 위한 기능
    public void setArtSearchGenre(ArtSearch artSearch, String genreStatus) {
        genreRepository.setArtSearchGenre(artSearch, genreStatus);
    }
}
