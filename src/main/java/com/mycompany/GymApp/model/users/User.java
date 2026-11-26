package com.mycompany.GymApp.model.users;

public abstract class User {
    private Long UserId;
    private String FirstName;
    private String LastName;
    private String Username;
    private String PassWord;
    private Boolean isActive;

    public User(Long userId, String firstName, String lastName, String username, String passWord, Boolean isActive) {
        UserId = userId;
        FirstName = firstName;
        LastName = lastName;
        Username = username;
        PassWord = passWord;
        this.isActive = isActive;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

}
