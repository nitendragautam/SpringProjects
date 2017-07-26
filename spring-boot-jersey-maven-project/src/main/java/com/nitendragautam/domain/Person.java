package com.nitendragautam.domain;

public class Person {

    private Long id;
    private String loginId;
    private String firstName;
    private String lastName;
    private String currentAddress;

    public Person(Long id, String loginId, String firstName, String lastName , String currentAddress) {
        this.id = id;
        this.loginId = loginId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.currentAddress =currentAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCurrentAddress(){
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress){
        this.currentAddress =currentAddress;
    }

}
