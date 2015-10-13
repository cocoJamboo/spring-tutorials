/*
 * Copyright 2014-11-21 the original author or authors.
 */

package pl.altkom.spring.spring.jmx;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class MyBean {
    
    private String name;
    private int age;
    private boolean isSuperman;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isIsSuperman() {
        return isSuperman;
    }

    public void setIsSuperman(boolean isSuperman) {
        this.isSuperman = isSuperman;
    }
    
    public void dontExposeMe() {
        throw new RuntimeException();
    }
    
}
