package com.sparta.engineering72.sakilaproject.entites;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Customer {
    private Integer customerId;
    private String firstName;
    private String lastName;
    private String email;
    private byte active;
    private Timestamp createDate;
    private Timestamp lastUpdate;
    private Address addressByAddressId;

    @Id
    @Column(name = "customer_id")
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "active")
    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

    @Basic
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "last_update")
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (active != customer.active) return false;
        if (customerId != null ? !customerId.equals(customer.customerId) : customer.customerId != null) return false;
        if (firstName != null ? !firstName.equals(customer.firstName) : customer.firstName != null) return false;
        if (lastName != null ? !lastName.equals(customer.lastName) : customer.lastName != null) return false;
        if (email != null ? !email.equals(customer.email) : customer.email != null) return false;
        if (createDate != null ? !createDate.equals(customer.createDate) : customer.createDate != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(customer.lastUpdate) : customer.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerId != null ? customerId.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (int) active;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false)
    public Address getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(Address addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }
}
