package foobar.auctionsystem.controllers;

import foobar.auctionsystem.models.*;
import foobar.auctionsystem.repository.DataStore;

public class UserController {
    private DataStore dataStore;

    public UserController() {
        dataStore = DataStore.getInstance();
    }

    public void addBuyer(String name) {
        if (!dataStore.getBuyers().containsKey(name)) {
            dataStore.getBuyers().put(name, new Buyer(name));
            System.out.println("Buyer added: " + name);
        } else {
            System.out.println("Buyer already exists.");
        }
    }

    public void addSeller(String name) {
        if (!dataStore.getSellers().containsKey(name)) {
            dataStore.getSellers().put(name, new Seller(name));
            System.out.println("Seller added: " + name);
        } else {
            System.out.println("Seller already exists.");
        }
    }

    public Buyer getBuyer(String name) {
        return dataStore.getBuyers().get(name);
    }

    public Seller getSeller(String name) {
        return dataStore.getSellers().get(name);
    }
}
