# inventory
Inventory management system to manage inventory

The following are the list of operations that can be performed 


a) createitemNamecostPricesellingPrice
	Whenever Mr. X wants to add a new item to his store he issues a create command. This command creates a new item in the inventory with the given cost price and selling price. The prices are rounded off to two decimal places.

b) deleteitemName
	If Mr. X decides not to sell an item anymore, then he simply issues a delete command. This command will remove the item from the inventory.

c) updateBuyitemName quantity
	Whenever Mr. X purchases additional quantity of the mentioned item, then he issues aupdateBuy command. This command should increase the quantity of the mentioned item.

d) updateSellitemName quantity
	Whenever Mr. X sells some item, then he issues aupdateSell command. This command should deduct the quantity of the mentioned item.

e) report
	Whenever Mr. X wants to view his inventory list he issues the report command. This command should print the current inventory details in the specified format sorted by alphabetical order. Apart from printing the inventory it has to report on the profit made by Mr. X since last report generation.


SAMPLE SCENARIO:

create Book01 10.50 13.79

create Food01 1.47 3.98

create Med01 30.63 34.29

create Tab01 57.00 84.98

updateBuy Tab01 100

updateSell Tab01 2

updateBuy Food01 500

updateBuy Book01 100

updateBuy Med01 100

updateSell Food01 1

updateSell Food01 1

updateSell Tab01 2

report

EXPECTED OUTPUT:

```

	INVENTORY REPORT
Item Name 	Bought At    	Sold At       	AvailableQty	Value

Book01    	10.50          	13.79               	100    	1050.00
Food01     	1.47           	3.98               	    498     732.06
Med01     	30.63          	34.29               	100    	3063.00
Tab01     	57.00          	84.98                	96    	5472.00
---------------------------------------------------------------------------
Total value                                                     	10317.06
Profit since previous report                                      	116.94

```