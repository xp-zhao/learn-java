package com.xp.lambda.compared;

import com.xp.lambda.compared.entity.Person;

@FunctionalInterface
public interface NameChecker {
    boolean check(Person person);
}
