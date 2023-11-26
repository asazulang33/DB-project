package jpaDB.mapping.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Participates {

    @Id
    @GeneratedValue
    @Column(name = "Participate_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Actor_id")
    private Actor actor;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "A_id")
    private Art art;

    private String actorName;

    public static Participates createParticipate(Actor actor) {
        Participates participates = new Participates();
        participates.setActor(actor);
        participates.setActorName(actor.getAct_name());
        return participates;
    }
}
