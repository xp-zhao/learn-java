package com.xp.stream.apple;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xp-zhao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Apple {
    private Integer id;
    private String color;
    private Integer weight;
    private String origin;
}
