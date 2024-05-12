/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.echannellingproject.dao;

import com.mycompany.echannellingproject.classes.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hasit
 */
public class PersonDao {
    
    private static Map<Integer, Person> persons = new HashMap<>();
    private static int nextId = 1;
    
    static {
        // Example Person objects
        Person person1 = new Person(1,"John Doe", "1234567890", "john@example.com", "123 Street, City");
        Person person2 = new Person(2,"Alice Smith", "9876543210", "alice@example.com", "456 Avenue, Town");
        Person person3 = new Person(3,"Bob Johnson", "5678901234", "bob@example.com", "789 Road, Village");

        // Adding persons to the map
        addPerson(person1);
        addPerson(person2);
        addPerson(person3);
    }

    // Create
    public static int addPerson(Person person) {
        person.setPerson_id(nextId++);
        persons.put(person.getPerson_id(), person);
        return person.getPerson_id();
    }

    // Read
    public static Person getPersonById(int id) {
        return persons.get(id);
    }

    public static List<Person> getAllPersons() {
        return new ArrayList<>(persons.values());
    }

    // Update
    public static void updatePerson(int id, Person updatedPerson) {
        if (persons.containsKey(id)) {
            updatedPerson.setPerson_id(id);
            persons.put(id, updatedPerson);
        } else {
            throw new IllegalArgumentException("Person with ID " + id + " does not exist.");
        }
    }

    // Delete
    public static void deletePerson(int id) {
        if (persons.containsKey(id)) {
            persons.remove(id);
        } else {
            throw new IllegalArgumentException("Person with ID " + id + " does not exist.");
        }
    }

    // Exception Handling and Validation
    public static void validatePerson(Person person) {
        if (person.getPerson_name()== null || person.getPerson_name().isEmpty()) {
            throw new IllegalArgumentException("Person name cannot be empty.");
        }
        // Similarly, validate other fields like phoneNumber, email, address
    }
    
}
