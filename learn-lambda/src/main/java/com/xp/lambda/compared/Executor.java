package com.xp.lambda.compared;

import com.xp.lambda.compared.entity.Person;

@FunctionalInterface
public interface Executor {
    void execute(Person person);
}
