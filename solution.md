
# PURPLE COW

SUMMARY
-------
**A java web application API that counts items.

**Purple Cow doesn't have a GUI. It can be tested using a plugin like PostMan. It can also be tested from a web browser.**
 

REQUIREMENTS
------------
- [x] Java 11 or higher 
- [x] Maven 3.6.2 or higher
- [x] Spring Framework 5.3.3 or higher
- [x] Docker CE

 

TO START
--------
 - Open a command prompt in Linux or Windows.
 - Change directories to the location of Purple Cow.
 - Compile the application.
 - Execute the application.

You can compile and execute Purple cow from an IDE.
You could also simply run Purple Cow from Docker.

It's best to run Purple Cow from Docker, with a single command.

From a command prompt:

### COMPILING Purple Cow:
 - `` mvn compile ``


### EXECUTING Purple Cow:

 - ``./mvnw spring-boot:run ``


From Docker:

### EXECUTING Purple Cow:

 - ``sudo docker run -p 3000:3000 purplecow ``


_This starts the Spring service._ Once activated, type the following into your browser:

 - ``localhost:3000/item``

You can configure the port Purple Cow is served on. Open this file:

 - ``PurpleCow/src/main/resources/application.properties``

To serve the application on port 4050 (or any other port), enter the following:

 - ``server.port = 4050``

You can also configure the port directly from Dockerfile. Open this file:

 - ``PurpleCow/Dockerfile``

To serve the application on port 5000 (or any other port), enter this line in Dockerfile:

 - ``EXPOSE 5000``


### TESTING Purple Cow:

#### with PostMan:
 - _With the Spring service running,_ use the PostMan plugin to test the API. Dummy data is already included in a method. You can manipulate that data with HTTP GET, POST, DELETE, and PUT commands. You'll see where the HTTP REST methods talk to a Data access object containing item data. 

You can change that data. Those REST methods use HTTP GET, PUT, DELETE and POST to change the data in the Data access object. The changes you see there will be reflected in a web application.   

#### with a web browser:
 - _With the Spring service running,_ type the appropriate URL for the data you want to see.  

    Example: To see an item with id #5, type this into your browser:

    ```localhost:3000/item/5``` 


### IMPLEMENTATION DETAILS:

 - _No unit tests were included._ I could only test the methods in tha Data access object, which only added and removed items. I left them out. Rest COntroller methods were tested seperately, with a web browser.

 - _Data access methods to update a List of items couldn't be called properly by any REST method calls._ They would cause errors with their requisite HTTP commands. HTTP PUT can update a single item by ID, but updating an ArrayList of items would cause errors due to its' identical HTTP command structure. _These can be fixed in the future._ 

These methods were affected:

    ```java 
    public void addItems(ArrayList<Item> itemsToAdd) { ... }
    
    public void updateItems(ArrayList<Item> updatedItems) { ... }

    public void deleteItems(ArrayList<Item> itemsToDelete) { ... }

    public void addItems(ArrayList<Item> itemsToAdd) { ... }   

    ```

### FUTURE CHANGES:

 - Developers can build on this any way they choose. To do so: 
    
     - Build an apprpriate method in ItemDataAccess.java to store data in the database (or, ArrayList of items)
     - Build an appropriate REST method in ItemRestController.java
     - Make the REST method in ItemRestCOntroller.java call the appropriate method in ItemDataAccess.java.

 - Add an in-memory database like H2 or Apache Derby to store data..





