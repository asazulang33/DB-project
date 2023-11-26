package jpaDB.mapping.service;

import jpaDB.mapping.domain.*;
import jpaDB.mapping.repository.ActorRepository;
import jpaDB.mapping.repository.ArtRepository;
import jpaDB.mapping.repository.ArtSearch;
import jpaDB.mapping.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
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

    public List<Art> findArts(ArtSearch artSearch) {
        return artRepository.findAll(artSearch);
    }

    @Transactional
    public Long artDrama(String name, Integer year, List<Long> actorIds, Long locationId) {

        List<Actor> actors = actorIds.stream()
                .map(actorRepository::findOne)
                .collect(Collectors.toList());
        Location location = locationRepository.findOne(locationId);

        Filmed filmed = new Filmed();
        filmed.setLocation(location);

        Art art = new Art();
        art.setName(name);
        art.setYear(year);
        art.addFilmed(filmed);
        art.setGenreStatus(GenreStatus.DRAMA);

        for (Actor actor : actors) {
            Participates participates = new Participates();
            participates.setActor(actor);
            participates.setArt(art);
            // 다른 필요한 설정
            art.addParticipates(participates);
        }

        artRepository.save(art);
        return art.getId();
    }
    @Transactional
    public Long artMovie(String name, Integer year, List<Long> actorIds, Long locationId) {

        List<Actor> actors = actorIds.stream()
                .map(actorRepository::findOne)
                .collect(Collectors.toList());
        Location location = locationRepository.findOne(locationId);

        Filmed filmed = new Filmed();
        filmed.setLocation(location);

        Art art = new Art();
        art.setName(name);
        art.setYear(year);
        art.addFilmed(filmed);
        art.setGenreStatus(GenreStatus.MOVIE);

        for (Actor actor : actors) {
            Participates participates = new Participates();
            participates.setActor(actor);
            participates.setArt(art);
            // 다른 필요한 설정
            art.addParticipates(participates);
        }

        artRepository.save(art);
        return art.getId();
    }

    @Transactional
    public Long artBook(String name, Integer year, List<Long> actorIds, Long locationId) {

        List<Actor> actors = actorIds.stream()
                .map(actorRepository::findOne)
                .collect(Collectors.toList());
        Location location = locationRepository.findOne(locationId);

        Filmed filmed = new Filmed();
        filmed.setLocation(location);

        Art art = new Art();
        art.setName(name);
        art.setYear(year);
        art.addFilmed(filmed);
        art.setGenreStatus(GenreStatus.BOOK);

        for (Actor actor : actors) {
            Participates participates = new Participates();
            participates.setActor(actor);
            participates.setArt(art);
            // 다른 필요한 설정
            art.addParticipates(participates);
        }

        artRepository.save(art);
        return art.getId();
    }


}
