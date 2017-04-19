
package com.qa.cinema;

/** 
 * @author EMMANUEL OSEI-BREFO
 */
public abstract class Ticket {
    private String name;
    private float price;

    public Ticket(String name, float price) {
        this.name = name;
        this.price = price;
    }
        
    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }                       
}
