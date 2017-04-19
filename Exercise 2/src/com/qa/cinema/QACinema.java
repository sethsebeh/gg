/** 
 * @author EMMANUEL OSEI-BREFO
 */
package com.qa.cinema;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class QACinema {
            
    public static void main(String[] args) {
        
        Ticket ticket = null;
        OrderItem orderItem = null;
        Discount discount = new Discount();
        ArrayList<OrderItem> cart = new ArrayList<>();
        String dayOfWeek = null;
        Scanner input = new Scanner(System.in);
                
        System.out.println("WELCOME TO QA CINEMA SYSTEM");
        System.out.println("----------------------------");
        System.out.println("");
        
        Date now = new Date();
 
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week abbreviated
        dayOfWeek = simpleDateformat.format(now);
        System.out.println("Today is " + dayOfWeek);
        System.out.println("");
 
        if(dayOfWeek.equalsIgnoreCase("Wednesday")){    
           System.out.println("--------------------------------------------------");
           System.out.println("Today is Wednesday. Get £2 discount on each ticket");
           System.out.println("---------------------------------------------------");
           System.out.println("");
           
           discount.setDiscount(2);
        }
        
        //variable to control loop. 1 = repeat  2. exit from while loop
        int FLAG = 1;
        
        int userTicketChoice = 0;
        
       while(FLAG == 1){
        System.out.println("SELECT YOUR TICKET BELOW");
        System.out.println("1. Standard - £8");
        System.out.println("2. OAP - £6");
        System.out.println("3. Student - £6");
        System.out.println("4. Child - £4");
        System.out.println("5. Quit");
        System.out.println("");
        System.out.println("ENTER 1,2,3,OR 4 to select ticket type or 5 to QUIT");
        
        //read user input        
        userTicketChoice = input.nextInt();
        int quantity = 0;
        System.out.println("");
        
        switch(userTicketChoice){
          case 1:
             System.out.println("You selected: 1. Standard - £8");
             ticket = new Standard();
             System.out.println("How many " + ticket.getName() + " tickets are you buying?");
             quantity = input.nextInt();             
             break;
          case 2:
             System.out.println("You selected: 2. OAP - £6");
             ticket = new OAP();
             System.out.println("How many " + ticket.getName() + " tickets are you buying?");
             quantity = input.nextInt(); 
             break;
          case 3:
             System.out.println("You selected: 3. Student - £6");
             ticket = new Student();
             System.out.println("How many " + ticket.getName() + " tickets are you buying?");
             quantity = input.nextInt(); 
             break;
          case 4:
             System.out.println("You selected: 4. Child - £4");
             ticket = new Child();
             System.out.println("How many " + ticket.getName() + " tickets are you buying?");
             quantity = input.nextInt(); 
             break;
          case 5:
             System.out.println("You selected: 5. Quit");
             System.out.println("PROGRAM TERMINATED. Thank you.");
             FLAG = 2;
             break;       
          default:
             System.out.println("Wrong input");
             System.out.println("PROGRAM TERMINATED. Thank you.");
             FLAG = 2;
             break;
        }
        
                
        if(FLAG != 2){
            orderItem = new OrderItem();
            orderItem.setTicket(ticket);
            orderItem.setQuantity(quantity);
        
            cart.add(orderItem);
        
            System.out.println("Do you want to buy another ticket?");
            System.out.println("Enter 1 = Yes , 2 = No");
            FLAG = input.nextInt();
        }
        
     }
       
     if( ticket != null ){ 
        //print order Items
         System.out.println("");
         System.out.println("Ticket              Quantity");
         System.out.println("-----------------------------------------------");
         
         float totalOrder = 0;
   
         for(OrderItem item: cart){        
           System.out.println(item.getTicket().getName() + " " + item.getTicket().getPrice() + "           " + item.getQuantity());  
           
           //calculate order total
           totalOrder = totalOrder  + (item.getTicket().getPrice() - discount.getDiscount()) * item.getQuantity();
         }
         
         System.out.println("");
         System.out.println("The total cost of tickets for this movie is £" + totalOrder);
         System.out.println("");         
      }        
    }    
}
