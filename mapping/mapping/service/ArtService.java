package jpaDB.mapping.service;

import jpaDB.mapping.domain.*;
import jpaDB.mapping.repository.ActorRepository;
import jpaDB.mapping.repository.ArtRepository;
import jpaDB.mapping.repository.ArtSearch;
import jpaDB.mapping.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ArtService {

    private final ArtRepository artRepository;
    private final ActorRepository actorRepository;
    private final LocationRepository locationRepository;


    public List<Art> findAllArts() {
        return artRepository.findAllArts();
    }

    // 작품명, 장르로 찾는 로직
    public List<Art> findArts(ArtSearch artSearch) {
        return artRepository.findAll(artSearch);
    }

    // 작품 검색 및 페이징 기능
    public Page<Art> findArtsPage(ArtSearch artSearch, Pageable pageable) {
        return artRepository.findArtsPage(artSearch, pageable);
    }

}
