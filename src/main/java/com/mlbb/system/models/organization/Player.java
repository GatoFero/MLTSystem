package com.mlbb.system.models.organization;

import com.mlbb.system.models.enums.Role;

public record Player (
        String nickname,
        Role role) {
}
