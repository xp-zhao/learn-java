package com.spring.example04.v3.api;

import java.util.*;

/**
 * @author zhaoxiaoping
 * @date 2024-6-14
 */
public class Facts implements Iterable<Fact<?>> {
  private final Set<Fact<?>> facts = new HashSet<>();

  public <T> void put(String name, T value) {
    Objects.requireNonNull(name, "fact name must not be null");
    Objects.requireNonNull(value, "fact value must not be null");
    Fact<?> retrievedFact = getFact(name);
    if (retrievedFact != null) {
      remove(retrievedFact);
    }
    add(new Fact<>(name, value));
  }

  public <T> void add(Fact<T> fact) {
    Objects.requireNonNull(fact, "fact must not be null");
    Fact<?> retrievedFact = getFact(fact.getName());
    if (retrievedFact != null) {
      remove(retrievedFact);
    }
    facts.add(fact);
  }

  public void remove(String factName) {
    Objects.requireNonNull(factName, "fact name must not be null");
    Fact<?> fact = getFact(factName);
    if (fact != null) {
      remove(fact);
    }
  }

  public <T> void remove(Fact<T> fact) {
    Objects.requireNonNull(fact, "fact must not be null");
    facts.remove(fact);
  }

  @SuppressWarnings("unchecked")
  public <T> T get(String factName) {
    Objects.requireNonNull(factName, "fact name must not be null");
    Fact<?> fact = getFact(factName);
    if (fact != null) {
      return (T) fact.getValue();
    }
    return null;
  }

  public Fact<?> getFact(String factName) {
    Objects.requireNonNull(factName, "fact name must not be null");
    return facts.stream().filter(fact -> fact.getName().equals(factName)).findFirst().orElse(null);
  }

  public boolean contains(String factName) {
    return getFact(factName) != null;
  }

  public boolean contains(Fact fact) {
    if (fact == null) {
      return false;
    }
    return getFact(fact.getName()) != null;
  }

  public int size() {
    return facts.size();
  }

  public Map<String, Object> toMap() {
    Map<String, Object> map = new HashMap<>();
    for (Fact<?> fact : facts) {
      map.put(fact.getName(), fact.getValue());
    }
    return map;
  }

  @Override
  public Iterator<Fact<?>> iterator() {
    return facts.iterator();
  }

  public void clear() {
    facts.clear();
  }

  @Override
  public String toString() {
    Iterator<Fact<?>> iterator = facts.iterator();
    StringBuilder stringBuilder = new StringBuilder("[");
    while (iterator.hasNext()) {
      stringBuilder.append(iterator.next().toString());
      if (iterator.hasNext()) {
        stringBuilder.append(",");
      }
    }
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}
