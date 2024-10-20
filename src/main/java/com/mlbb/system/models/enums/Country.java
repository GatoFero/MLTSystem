package com.mlbb.system.models.enums;

import lombok.Getter;

@Getter
public enum Country {
    PER("Perú", "per"),
    ARG("Argentina", "arg"),
    BRA("Brazil", "bra"),
    CHL("Chile", "chl"),
    BOL("Bolivia", "bol"),
    COL("Colombia", "col"),
    CRI("Costa Rica", "cri"),
    CUB("Cuba", "cub"),
    DOM("República Dominicana", "dom"),
    ECU("Ecuador", "ecu"),
    SLV("El Salvador", "slv"),
    GTM("Guatemala", "gtm"),
    HND("Honduras", "hnd"),
    MEX("México", "mex"),
    NIC("Nicaragua", "nic"),
    PAN("Panamá", "pan"),
    PRY("Paraguay", "pry"),
    PRI("Puerto Rico", "pry"),
    URY("Uruguay", "ury"),
    VEN("Venezuela", "ven");

    private final String country;
    private final String flag;

    Country(String country, String flag) {
        this.country = country;
        this.flag = flag;
    }
}
