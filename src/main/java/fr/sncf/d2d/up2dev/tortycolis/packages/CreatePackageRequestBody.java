package fr.sncf.d2d.up2dev.tortycolis.packages;

import com.fasterxml.jackson.annotation.JsonView;

public class CreatePackageRequestBody {

    // public interface WithoutPasswordView {
    // };

    // public interface WithPasswordView extends WithoutPasswordView {
    // };

private String number;
private String street;
private String postalCode;
private String city;
private String country;
private String detail;
private String phoneNumber;
private String email;
private String deliveryPersonID;

public CreatePackageRequestBody() {
}
    // @JsonView(WithoutPasswordView.class)
    public String getNumber() {
    return number;
}


public void setNumber(String number) {
    this.number = number;
}


public String getStreet() {
    return street;
}


public void setStreet(String street) {
    this.street = street;
}


public String getPostalCode() {
    return postalCode;
}


public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
}


public String getCity() {
    return city;
}


public void setCity(String city) {
    this.city = city;
}


public String getCountry() {
    return country;
}


public void setCountry(String country) {
    this.country = country;
}


public String getDetail() {
    return detail;
}


public void setDetail(String detail) {
    this.detail = detail;
}


public String getPhoneNumber() {
    return phoneNumber;
}


public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
}


public String getEmail() {
    return email;
}


public void setEmail(String email) {
    this.email = email;
}


public String getDeliveryPersonID() {
    return deliveryPersonID;
}


public void setDeliveryPersonID(String deliveryPersonID) {
    this.deliveryPersonID = deliveryPersonID;
}


@Override
public String toString(){
    return String.format("email=%s", this.email);
}

}
