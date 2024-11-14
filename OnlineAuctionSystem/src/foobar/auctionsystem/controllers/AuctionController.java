package foobar.auctionsystem.controllers;

import foobar.auctionsystem.models.*;
import foobar.auctionsystem.services.*;
import foobar.auctionsystem.repository.DataStore;

public class AuctionController {
    private DataStore dataStore;
    private UserController userController;

    public AuctionController(UserController userController) {
        dataStore = DataStore.getInstance();
        this.userController = userController;
    }

    public void createAuction(String id, double lowestBidLimit, double highestBidLimit, double participationCost, String sellerName) {
        if (dataStore.getAuctions().containsKey(id)) {
            System.out.println("Auction with this ID already exists.");
            return;
        }
        Seller seller = userController.getSeller(sellerName);
        if (seller == null) {
            System.out.println("Seller not found.");
            return;
        }
        AuctionService auction = new AuctionService(id, lowestBidLimit, highestBidLimit, participationCost, seller);
        dataStore.getAuctions().put(id, auction);
        System.out.println("Auction created: " + id);
    }

    public AuctionService getAuction(String auctionId) {
        return dataStore.getAuctions().get(auctionId);
    }

    public void closeAuction(String auctionId) {
        AuctionService auction = getAuction(auctionId);
        if (auction == null) {
            System.out.println("Auction not found.");
            return;
        }
        auction.closeAuction();
        Bid winningBid = auction.getWinningBid();
        if (winningBid != null) {
            System.out.println("Auction " + auctionId + " closed. Winner: " + winningBid.getBuyer().getName() + " with bid " + winningBid.getAmount());
        } else {
            System.out.println("Auction " + auctionId + " closed. No winner.");
        }
    }

    public void getProfitOrLoss(String sellerName, String auctionId) {
        Seller seller = userController.getSeller(sellerName);
        AuctionService auction = getAuction(auctionId);
        if (seller == null) {
            System.out.println("Seller not found.");
            return;
        }
        if (auction == null) {
            System.out.println("Auction not found.");
            return;
        }
        double profitOrLoss = auction.calculateProfitOrLoss();
        System.out.println("Profit/Loss for seller " + sellerName + " on auction " + auctionId + " is " + profitOrLoss);
    }
}
