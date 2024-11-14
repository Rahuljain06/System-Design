package foobar.auctionsystem.repository;

import foobar.auctionsystem.models.*;
import foobar.auctionsystem.services.AuctionService;

import java.util.HashMap;
import java.util.Map;

public class DataStore {
    private static DataStore instance;
    private Map<String, Buyer> buyers;
    private Map<String, Seller> sellers;
    private Map<String, AuctionService> auctions;

    private DataStore() {
        buyers = new HashMap<>();
        sellers = new HashMap<>();
        auctions = new HashMap<>();
    }

    public static DataStore getInstance() {
        if (instance == null) {
            instance = new DataStore();
        }
        return instance;
    }

    public Map<String, Buyer> getBuyers() {
        return buyers;
    }

    public Map<String, Seller> getSellers() {
        return sellers;
    }

    public Map<String, AuctionService> getAuctions() {
        return auctions;
    }
}
