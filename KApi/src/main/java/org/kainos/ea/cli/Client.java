package org.kainos.ea.cli;

public class Client {
    private int clientId;
    private String name;
    private String address;
    private String phoneNumber;
    private int salesRepresentativeId;

    public Client(int clientId, String name, String address, String phoneNumber, int salesRepresentativeId) {
        setClientId(clientId);
        setName(name);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setSalesRepresentativeId(salesRepresentativeId);
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalesRepresentativeId() {
        return salesRepresentativeId;
    }

    public void setSalesRepresentativeId(int salesRepresentativeId) {
        this.salesRepresentativeId = salesRepresentativeId;
    }
}