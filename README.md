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


SAMPLE SCENARIO

create book 10 20
updateby book 20
create food 20 30
updateby book 30
report

INVENTORY REPORT
Item Name    Bought At    Sold At   AvailableQty  Value
---------    ---------    -------   ------------  -----
book        20.0         30.0          50           1000.0
food        20.0         30.0          0            0.0
-----------------------------------------------------------------------------------------------------
Total Value                                             1000.0
Profit                                                  500
Profit from previous report                             0.0
