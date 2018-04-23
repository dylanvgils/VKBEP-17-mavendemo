# Maven demo
## Step 1: Create "application.properties"
Create a properties file in your documents folder for example. Add the following properties:

```properties
    database.url=mongodb://anotherurl/anotherDatabase
    database.user=anotherUser
    database.password=reallySecret
```

## Step 2: Update pom.xml
Update `application.home` in the `prod` profile with the path where your create `applicaiton.properties` resides in, e.g: `/home/Dylan/app-home`.

## Step 3: Build the project
To build the project with the dev profile, run the following command `mvn clean install`. If you want to update a property in the `dev` profile you can do this with the following maven command `mvn -Ddatabase.user=user2`.

If you want to use the `prod` profile run the following command: `mvn -Pprod clean install`

## Step 4: Run the jar
To run the compiled jar run the following command `java -jar target/mavendemo-1.0-SNAPSHOT.jar`.