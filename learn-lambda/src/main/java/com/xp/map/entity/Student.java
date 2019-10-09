package com.xp.map.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author ch113
 */
@Data
@Builder
public class Student {
    private String name;
    private String subject;
    private float score;
}
