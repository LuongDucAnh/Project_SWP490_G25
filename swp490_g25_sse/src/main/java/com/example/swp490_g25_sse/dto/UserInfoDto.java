
package com.example.swp490_g25_sse.dto;


public class UserInfoDto {
    private String firstName;
    private String lastName;
    private String email;
    
    
    public UserInfoDto() {
       
    }
    public UserInfoDto(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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

   

   

 
}
