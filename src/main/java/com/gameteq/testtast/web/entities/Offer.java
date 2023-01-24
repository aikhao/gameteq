package com.gameteq.testtast.web.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Offer {

    boolean forTest;
    String category;
    String group;
    String key;
    String name;
    String[] networks;
    String segment;

}
