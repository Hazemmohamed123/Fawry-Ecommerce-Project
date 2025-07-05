# Fawry-Ecommerce-Project
Task Summary 

Developing a fundamental e-commerce application with the following capabilities presents the challenge: 

Name, price, and quantity available should define goods. 

While other goods, such as televisions, do not expire, certain products—like cheese or biscuits—will. 

Some products have to include weight and must be transported. 

As long as the required quantity is in stock, clients should be able to add items to a cart. 

Upon check out, the system should: 

Find the total (subtotal) 

Include shipping costs as appropriate. 

Present the whole sum payable. 

Show the consumers their remaining balance after payment 

The system should also manage these errors: 

Cart is null. 

Expired or out of stock product 

Customer lacks sufficient balance. 

 Breakdown of solution 

Using Java and adhering to a clear, object-oriented approach, the system was created. Here's the structure of the solution: 

Product: Starting point for all kinds of items 

ExpirableProduct: Extends Product to give it an expiry date. 

Extends Product and uses the Shippable interface on Shippable Product. 

Declares getName() and getWeight() methods in Shippable (interface): 

Customer: Keeps the customer's name and current balance. 

Manages the shopping cart and the number of goods added. 

Shipping Service controls total weight calculations and printing shipping information. 

Main: With a practical example, relate everything together: 

Adding different product categories 

Confirming the check-out flow 

Receipt and shipping information printing 

 Use of the System 

Run the project locally by means of these instructions: 

Any Java-compatible IDE like IntelliJ IDEA or VS Code should open the folder. 

Ensure that all . java files reside in the same folder. 

In that directory, launch the terminal and execute the following commands: 

javac *. java
 java Main 

Once you conduct this, the console will display a summary as follows: 

Shipping notification 100g of cheese biscuits 100 grams TV 1500 grams The total package weighs 1.7 kg. Check out receipt 2x Cheese 200 1x Biscuits 150 1x TV 200 One Scratchcard 50 Subtotal 600 Ship 30 Amount 630 Customer Balance 370
