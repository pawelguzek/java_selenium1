package pl.guzek.model;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@Entity
@Table(name= "addressbook")
public class ContactData {
    @Id
    @Column(name= "id")
    private int id  = Integer.MAX_VALUE;
    @Column(name= "firstname")
    private String name;
    @Column(name= "lastname")
    private String surname;

    @Transient
    private String address;
    @Transient
    private String allPhones;

    @Column(name= "home")
    @Type(type = "text")
    private String homeNumber;
    @Column(name= "mobile")
    @Type(type = "text")
    private String mobileNumber;
    @Column(name= "work")
    @Type(type = "text")
    private String workNumber;
    @Transient
    private String email1;
    @Column(name= "photo")
    @Type(type="text")
    private String photo;
    @Transient
    private String group;
    @Transient
    private String namesAndSurname;

    public File getPhoto() {
        return new File (photo);
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    public ContactData withNamesAndSurname(String namesAndSurname) {
        this.namesAndSurname = namesAndSurname;
        return this;
    }



    public String getNamesAndSurname() {
        return namesAndSurname;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }



    @Override

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withName(String name) {
        this.name = name;
        return this;
    }

    public ContactData withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
        return this;
    }
    public ContactData withMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }



    public ContactData withWorkNumber(String workNumber) {
        this.workNumber = workNumber;
        return this;

    }

    public ContactData withEmail1(String email1) {
        this.email1 = email1;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }




    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail1() {
        return email1;
    }

    public String getGroup() {
        return group;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }


}