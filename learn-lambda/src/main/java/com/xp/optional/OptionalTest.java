package com.xp.optional;

import com.xp.optional.model.Car;
import com.xp.optional.model.Insurance;
import com.xp.optional.model.Person;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Person person = new Person();
        // 用户可能没有车，车可能没有买保险
        person.setCar(Optional.ofNullable(new Car(Optional.ofNullable(new Insurance()))));
        Optional<Person> optionalPerson = Optional.of(person);

        Optional<Car> optionalCar = optionalPerson.flatMap(Person::getCar);

        String name = optionalPerson.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
        System.out.println(name);

        System.out.println(getPersonName(person));
        System.out.println(getInsuranceName(person));
    }

    public static String getPersonName(Person person){
        return Optional.ofNullable(person)
            .map(p -> p.getName())
            .orElse("Unknown");
    }

    public static String getInsuranceName(Person person){
        return Optional.ofNullable(person)
            .flatMap(p -> p.getCar())
            .flatMap(car -> car.getInsurance())
            .map(insurance -> insurance.getName()).orElse("Unknown");
    }
}
