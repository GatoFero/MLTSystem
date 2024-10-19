package com.mlbb.system.models.enums;

import lombok.Getter;

@Getter
public enum Role {
    JG("jungler"),
    ML("midline"),
    RM("roamer"),
    GL("goldline"),
    EL("expline");

    private final String role;

    Role(String role) {
        this.role = role;
    }
}
