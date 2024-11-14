package foobar.auctionsystem.services;

import foobar.auctionsystem.models.*;

public class AuctionService {
    private String id;
    private double lowestBidLimit;
    private double highestBidLimit;
    private double participationCost;
    private Seller seller;
    private BidManager bidManager;
    private ProfitCalculator profitCalculator;
    private boolean isClosed;

    public AuctionService(String id, double lowestBidLimit, double highestBidLimit, double participationCost, Seller seller) {
        this.id = id;
        this.lowestBidLimit = lowestBidLimit;
        this.highestBidLimit = highestBidLimit;
        this.participationCost = participationCost;
        this.seller = seller;
        this.bidManager = new BidManager();
        this.profitCalculator = new ProfitCalculator();
        this.isClosed = false;
    }

    public String getId() { return id; }
    public double getLowestBidLimit() { return lowestBidLimit; }
    public double getHighestBidLimit() { return highestBidLimit; }
    public double getParticipationCost() { return participationCost; }
    public Seller getSeller() { return seller; }
    public boolean isClosed() { return isClosed; }

    public boolean addOrUpdateBid(Buyer buyer, double amount) {
        if (isClosed) {
            System.out.println("Auction is closed.");
            return false;
        }
        if (amount < lowestBidLimit || amount > highestBidLimit) {
            System.out.println("Bid amount is out of bounds.");
            return false;
        }
        if (!bidManager.hasBid(buyer)) {
            buyer.incrementAuctionsParticipated();
            if (buyer.getAuctionsParticipated() > 2) {
                buyer.setPreferred(true);
            }
            bidManager.addBid(new Bid(buyer, amount));
        } else {
            bidManager.updateBid(buyer, amount);
        }
        return true;
    }

    public boolean withdrawBid(Buyer buyer) {
        if (isClosed) {
            System.out.println("Auction is closed.");
            return false;
        }
        return bidManager.removeBid(buyer);
    }

    public void closeAuction() {
        isClosed = true;
    }

    public Bid getWinningBid() {
        if (!isClosed) {
            System.out.println("Auction is not yet closed.");
            return null;
        }
        return bidManager.getWinningBid();
    }

    public double calculateProfitOrLoss() {
        return profitCalculator.calculateProfitOrLoss(this, bidManager);
    }
}
