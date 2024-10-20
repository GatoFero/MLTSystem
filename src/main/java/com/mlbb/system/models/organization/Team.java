package com.mlbb.system.models.organization;

import com.mlbb.system.models.enums.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    private String name;
    private String logo;
    private Country country;
    private List<Player> players;
}
