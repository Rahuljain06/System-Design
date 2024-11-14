package foobar.auctionsystem.models;

public class Buyer extends User {
    private int auctionsParticipated;
    private boolean isPreferred;

    public Buyer(String name) {
        super(name);
        this.auctionsParticipated = 0;
        this.isPreferred = false;
    }

    public int getAuctionsParticipated() {
        return auctionsParticipated;
    }

    public void incrementAuctionsParticipated() {
        auctionsParticipated++;
    }

    public boolean isPreferred() {
        return isPreferred;
    }

    public void setPreferred(boolean preferred) {
        isPreferred = preferred;
    }
}
