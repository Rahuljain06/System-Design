package foobar.auctionsystem.controllers;

import foobar.auctionsystem.models.*;
import foobar.auctionsystem.services.*;

public class BidController {
    private UserController userController;
    private AuctionController auctionController;

    public BidController(UserController userController, AuctionController auctionController) {
        this.userController = userController;
        this.auctionController = auctionController;
    }

    public void createOrUpdateBid(String buyerName, String auctionId, double amount) {
        Buyer buyer = userController.getBuyer(buyerName);
        AuctionService auction = auctionController.getAuction(auctionId);
        if (buyer == null) {
            System.out.println("Buyer not found.");
            return;
        }
        if (auction == null) {
            System.out.println("Auction not found.");
            return;
        }
        BidService bidService = new BidService(auction);
        if (bidService.addOrUpdateBid(buyer, amount)) {
            System.out.println("Bid placed/updated by " + buyerName + " on auction " + auctionId + " with amount " + amount);
        }
    }

    public void withdrawBid(String buyerName, String auctionId) {
        Buyer buyer = userController.getBuyer(buyerName);
        AuctionService auction = auctionController.getAuction(auctionId);
        if (buyer == null) {
            System.out.println("Buyer not found.");
            return;
        }
        if (auction == null) {
            System.out.println("Auction not found.");
            return;
        }
        BidService bidService = new BidService(auction);
        if (bidService.withdrawBid(buyer)) {
            System.out.println("Bid withdrawn by " + buyerName + " from auction " + auctionId);
        }
    }
}
