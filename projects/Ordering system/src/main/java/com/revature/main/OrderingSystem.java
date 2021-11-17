package com.revature.main;



	import java.util.Scanner;

	public class OrderingSystem {
		
		private Scanner input = new Scanner(System.in);
		private String again;
		private double choose, quantity = 1;
		private double total = 0, pay;
		
		public static void menu() {
		System.out.println("\t\t\t\t+*************************************+");
		System.out.println("\t\t\t\t            BAITCASTERS MENU      ");
		System.out.println("\t\t\t\t   1. Abu Garcia Revo       Price. 199");
		System.out.println("\t\t\t\t    2. Lew's Pro            Price. 349");
		System.out.println("\t\t\t\t     3. Penn                Price. 149");
		System.out.println("\t\t\t\t      4. Daiwa Lexa         Price. 499");
		System.out.println("\t\t\t\t     5. CANCEL                           ");
		System.out.println("\t\t\t\t****************************************");
		}
		public void order() {
			System.out.println("Press 1 for Abu Garcia Revo, Press 2 for Lew's Pro, Press 3 for Penn"
					+ ", Press 4 for Daiwa Lexa, Press 5 to Cancel");
			System.out.print("Press the item you want to buy?");
			choose = input.nextInt();
			// conditions
			if(choose==1) {
				System.out.println("You choose Abu Garcia Revo");
				System.out.print("How many Abu Garcia Revo you want to Buy? :");
				quantity = input.nextInt();
				total = total + (quantity * 199);
				
				System.out.println("You want to buy Again? ");
				System.out.println("Press Y for Yes and N for No : ");
				again = input.next();
				
				if(again.equalsIgnoreCase("Y")) {
					order(); //Calls the order method to create a new order.
				}else {
					System.out.println("Please enter a payment");
					pay = input.nextDouble();
					total = pay - total;
					if(pay <= total) {
						System.out.println("Not enough payment");
					}else if(total <= pay ) {
						System.out.println("Total price is " + total);
						total = total - pay;
						System.out.println("Total change is " + total);
					}
				}
			}else if(choose == 2) {System.out.println("You choose Lew's Pro");
			System.out.print("How many Lew's Pro you want to Buy? ");
			quantity = input.nextInt();
			total = total + (quantity * 349.00);
			
			System.out.println("You want to buy Again? ");
			System.out.println("Press Y for Yes and N for No : ");
			again = input.next();
			if(again.equalsIgnoreCase("Y")) {
				order(); //Calls the order method to create a new order.
			}else {
				System.out.println("Please enter a payment");
				pay = input.nextDouble();
				total = total - pay;
				
				if(total > pay) {
					System.out.println("Not enough payment");
			
				}else if(total <= pay){
					
					System.out.println("Total change is " + total + " " + "Thank you for your business1");
				}
					
			}
			}else if(choose == 3) {System.out.println("You choose Penn");
				System.out.print("How many Penn you want to Buy? ");
				quantity = input.nextInt();
				total = total + (quantity * 149);
				
				System.out.println("You want to buy Again? ");
				System.out.println("Press Y for Yes and N for No : ");
				again = input.next();
				if(again.equalsIgnoreCase("Y")) {
					order(); //Calls the order method to create a new order.
				}else {
					System.out.println("Please enter a payment");
					pay = input.nextDouble();
					total = pay - total;
					if(pay <= total) {
						System.out.println("Not enough payment");
					}else {
						System.out.println("Total price is" + total);
						total = pay - total;
					System.out.println("Total change is " + total);
			
					}
				}
			}else if(choose == 4) {{System.out.println("You choose Daiwa Lexa");
			System.out.print("How many Daiwa you want to Buy? ");
			quantity = input.nextInt();
			total = total + (quantity * 349);
			
			System.out.println("You want to buy Again? ");
			System.out.println("Press Y for Yes and N for No : ");
			again = input.next();
			
			if(again.equalsIgnoreCase("Y")) {
				order(); //Calls the order method to create a new order.	
			}else {
				System.out.println("Your total is " + total);
				System.out.println("Please enter a payment");
				pay = input.nextDouble();
				total = pay - total;
				if(pay <= total) {
					System.out.println("Not enough payment");
				}else {
					total = pay - total;
				System.out.println("Total price is " + total);
				
					}
				}
			}
			}else if(choose == 5) {//close and exit the program.
			System.exit(0);
				}else {
			System.out.println("Choose 1 to 4 Only!");
			order();
		}
		}
		
		
		public OrderingSystem() {
			super();
			
		}
		public OrderingSystem(Scanner input, String again, double choose, double quantity, double total, double pay) {
			super();
			this.input = input;
			this.again = again;
			this.choose = choose;
			this.quantity = quantity;
			this.total = total;
			this.pay = pay;
		}	
	}

