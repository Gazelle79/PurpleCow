
# PURPLE COW

SUMMARY
-------
Purple Cow is a java web API. __It doesn't have a user interface.__ 
 

REQUIREMENTS
------------
- [x] Java 11 or higher 
- [x] Maven 3.6.2 or higher
- [x] Spring Framework
- [x] Docker

 

TO START
--------
 - Open a command prompt in Linux or Windows.
 - Change directories to the location of Purple Cow.
 - Compile the application.
 - Execute the application.

It's possible to compile and execute Purple Cow from Maven, as well as Docker.

__The best way to run Purple Cow is from the script specifically to do so:__  

``PurpleCow.sh``




### Maven / IDE compilation commands:
From a command prompt:

##### COMPILING Purple Cow:
``mvn clean package``

##### EXECUTING Purple Cow:
``./mvnw spring-boot:run``


### Docker compilation commands:

##### COMPILING Purple Cow:
``sudo docker build -t purplecow .``

##### EXECUTING Purple Cow:
``sudo docker run -p 3000:3000 purplecow ``

## RECOMMENDED WAY TO RUN PURPLE COW:
It's best to run Purple Cow from the following file:

``[Purple Cow directory] / PurpleCow.sh``

In the Purple Cow home directory, run the following command:

``./PurpleCow.sh ``

To serve the application on port 5000, run this command:

``./PurpleCow.sh 5000``

__This starts the Spring service. It runs in the background, so it doesn't hijack your terminal.__ \
Because of that, you must stop the running Docker instance manually.

## CONFIGURING PURPLE COW:

Once activated, type the following into your browser:

``localhost:3000/item``

In addition to having a port # as an argument, you can configure the default port Purple Cow is served on. Open this file:

``PurpleCow/src/main/resources/application.properties``

To serve the application on port 4050, enter the following:


``server.port = 4050``




## TESTING Purple Cow:

#### Purple Cow can be tested using a plugin like PostMan. It can also be tested from a web browser.

#### From PostMan:
 - _With the Spring service running,_ use the PostMan plugin to test the API. Dummy data is already included in a method. You can manipulate that data with HTTP GET, POST, DELETE, and PUT commands. You'll see where the HTTP REST methods talk to a Data access object containing item data. 

You can change that data. Those REST methods use HTTP GET, PUT, DELETE and POST to change the data in the Data access object. The changes you see there will be reflected in a web application.   

#### From a web browser:
 - __With the Spring service running,__ type the appropriate URL for the data you want to see.  

    __Example:__ To see an item with id #5, type this into your browser:


``localhost:3000/item/5`` 


## IMPLEMENTATION NOTES / DETAILS:

 - __No unit tests were included.__ I could only test the methods in tha Data access object, which only added and removed items. Because of that, they were left them out. Rest Controller methods were tested seperately, with a web browser.


 - __Data access methods to update a List of items couldn't be called properly by any REST method calls.__ They would cause errors with their requisite HTTP commands. HTTP PUT can update a single item by ID, but updating an ArrayList of items would cause errors due to its' identical HTTP command structure.  __These can be fixed in the future.__


These methods were affected:

``public void addItems(ArrayList<Item> itemsToAdd) { ... }``

``public void updateItems(ArrayList<Item> updatedItems) { ... }``

``public void deleteItems(ArrayList<Item> itemsToDelete) { ... }``

``public void addItems(ArrayList<Item> itemsToAdd) { ... }``

## FUTURE CHANGES:

 - Developers can build on this any way they choose. To do so: 
    
     - Build an appropriate method in ItemDataAccess.java to store data in the database (or, ArrayList of items)
     - Build an appropriate REST method in ItemRestController.java
     - Make the REST method in ItemRestCOntroller.java call the appropriate method in ItemDataAccess.java.

 - Add an in-memory database like H2 or Apache Derby to store data..





