package org.example.People;

public class Person {
    protected String name;
    protected ContactInfo contactInfo;
    protected String id;
    public enum ContactDetails {EMAIL, PHONE, ADDRESS, ALL}


    public Person(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContactInfo getContactInfo() {
        return this.contactInfo;
    }


    public ContactInfo updateContactInfo() {
        return this.contactInfo;
    }

    public String getIndividualContactInfo(Person.ContactDetails type) {
        return switch (type) {
            case EMAIL -> this.contactInfo.getEmail();
            case PHONE -> this.contactInfo.getPhoneNumber();
            case ADDRESS -> this.contactInfo.getAddress();
            default -> "The type of information you requested is not available!";
        };
    }

}
