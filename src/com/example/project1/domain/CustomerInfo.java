package com.example.project1.domain;

/**
 * Created by nobubele on 2014/08/15.
 */
public class CustomerInfo
{
    String name;
    String lastName;
    String email;
    String address;
    String cell_phone;
    int id;

    public CustomerInfo()
    {

    }

    public CustomerInfo(String name , String lastName , String email , String address)
    {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.address = address;

    }
    public CustomerInfo(int id ,String name, String cell_phone)
    {
        this.id = id;
        this.name = name;
        this.cell_phone = cell_phone;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCell_phone(String cell_phone) {
        this.cell_phone = cell_phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCell_phone() {
        return cell_phone;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
