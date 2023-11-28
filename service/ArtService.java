package jpaDB.mapping.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jpaDB.mapping.domain.*;
import jpaDB.mapping.repository.ActorRepository;
import jpaDB.mapping.repository.ArtRepository;
import jpaDB.mapping.repository.ArtSearch;
import jpaDB.mapping.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
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

    // 작품 생성로직
    @Transactional
    public Long createArt(String name, Integer year, List<Long> actorIds, List<Long> locationIds, GenreStatus genreStatus) {
        List<Actor> actors = actorIds.stream()
                .map(actorRepository::findOne)
                .collect(Collectors.toList());
        List<Location> locations = locationIds.stream()
                .map(locationRepository::findOne)
                .collect(Collectors.toList());

        List<Filmed> filmedList = locations.stream()
                .map(Filmed::createFilmed)
                .collect(Collectors.toList());

        Art art = Art.createArt(name, year, filmedList, actors, genreStatus);
        artRepository.save(art);
        return art.getId();
    }

    // 영화 생성
    public Long artMovie(String name, Integer year, List<Long> actorIds, List<Long> locationIds) {
        return createArt(name, year, actorIds, locationIds, GenreStatus.MOVIE);
    }

    // 드라마 생성
    public Long artDrama(String name, Integer year, List<Long> actorIds, List<Long> locationIds) {
        return createArt(name, year, actorIds, locationIds, GenreStatus.DRAMA);
    }

    // 책 생성
    public Long artBook(String name, Integer year, List<Long> actorIds, List<Long> locationIds) {
        return createArt(name, year, actorIds, locationIds, GenreStatus.BOOK);
    }

}
