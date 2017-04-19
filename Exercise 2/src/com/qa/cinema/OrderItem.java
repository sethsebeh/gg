package com.qa.cinema;

/**
 * @author EMMANUEL OSEI-BREFO
 * description: class to handle customers order
 */
public class OrderItem {
    private Ticket ticket;
    private Discount discount;
    private int quantity;   

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }    
    
}
