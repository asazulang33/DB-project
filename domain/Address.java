package jpaDB.mapping.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Address {

    private String CTPRVN_NM;
    private String SIGNGU_NM;
    private String Specific_Addr_NM;

    protected Address() {
    }

    public Address(String CTPRVN_NM, String SIGNGU_NM, String specific_Addr_NM) {
        this.CTPRVN_NM = CTPRVN_NM;
        this.SIGNGU_NM = SIGNGU_NM;
        this.Specific_Addr_NM = specific_Addr_NM;
    }
}
