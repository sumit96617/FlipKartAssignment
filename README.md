# FlipKartAssignment
This Project contains one src folder and one xml file.
Xml File is for running the suite.
src folder contains two files One is FlipKartObjectRepository and other is FlipKartTest 
FlipKartObjectRepository contains the Repository files for Testcase. There are four repository files.
LoginObjectRepository : It has all elements related to Login
ItemSearchObjectReposiory : It has all element related to item search
AddToCartObjectRepository : It has all the elements related to adding the cart in item
LogoutObjectRepository : It has elements related to logout functionality


In src folder there are Three files
1) FlipKartTest.java : It has test cases which add the max item to the cart
2) FlipKartCompareItem.java : It has test cases for comparing the items
3) lib.java : It has the common functions which we can reuse


Two two test cases are failing:

1) searchItemValidation : Its a test case to validate that correct items are showing in the result. Its correct because the search item should be related to iphone search but one of the item is not the iphone.

2) Logout : It is failing because of element not visible. I tried some solution but its not working. I will try  to solve this and commit my code again after making changes.


Note:  Before running the xml file you need to pass the parameter regarding adding the browser drivers and passing username and password.

What things I tried to cover in the given Assignment:

a) POM Structure
b) Cross Browser Testing 
c) Tried to give explicit wait for elements but for some of them it did not work correctly so given the hard coded wait.
d) Seperate file for common functions
e) Assertion for testcases to validate
f) Taking screenshots for the test cases
g) Data driven approach
