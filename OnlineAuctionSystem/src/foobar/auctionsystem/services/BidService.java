package foobar.auctionsystem.services;

import foobar.auctionsystem.models.*;

public class BidService {
    private AuctionService auction;

    public BidService(AuctionService auction) {
        this.auction = auction;
    }

    public boolean addOrUpdateBid(Buyer buyer, double amount) {
        return auction.addOrUpdateBid(buyer, amount);
    }

    public boolean withdrawBid(Buyer buyer) {
        return auction.withdrawBid(buyer);
    }
}
