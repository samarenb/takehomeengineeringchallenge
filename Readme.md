<!-- ABOUT THE PROJECT -->
## About The Project

This project provides Rest API to GET a food truck using location id and GET food trucks in a given block using block id, you can add food truck to the existing data store(in memory) using HTTP POST method. On start up the project loads food truck data from a csv file which is loaded from the classpath(src/main/resources/data folder). The project follows MVC pattern, the contrller is the one that recieves and parses the requests and then forwards them to the model to perform the businiess logic, the model returns the result back to the controller and the control creates the response object.



### Requirements

AdoptOpenJDK/Oracle version of Java 11 or more.(https://docs.oracle.com/en/java/javase/16/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A). After installing java make sure that java is in the system path(https://java.com/en/download/help/path.html). Test your JDK installation using the command below.
```
java -version 
[should display something like --> openjdk version "15.0.2" 2021-01-19]
```
Set JAVA_HOME env variable, pointing to bin folder of JDK installation.

### Build the project and install locally

1. Clone the repo
```
git clone https://github.com/samarenb/takehomeengineeringchallenge.git
cd takehomeengineeringchallenge 
```
2. Build the project using maven wrapper
``` 
On windows mvnw.cmd clean install
On linux or mac ./mvnw clean install
```
3. Target directory will be created inside the project root after a successful build.  After you run the command below, Rest API will be ready and listening on  port 8080 for GET/POST requests and port 9091 for observability requests.
```
Run the command java -jar target/takehomeengineeringchlng-0.0.1-SNAPSHOT.jar
```
4. (Optional) The project uses the Mobile_Food_Facility_Permit csv file located in src/main/resources/data directory by default, in order to use a different file, the file path is set in the properties file(src/main/resources folder), you can also modify that if needed and put it anywhere in the classpath.
```
Delete/Rename existing file in  src/main/resources/data folder and copy the new file into src/main/resources/data folder and call it Mobile_Food_Facility_Permit.csc rebuild the project using step 2 and run it using step 3.(Note-: The file should be of the same CSV format as the existing file)
```
5. (Optional) In order to create the docker image, use the command
```
docker build -t <image name> .
```

### Installation of existing Docker Image from docker hub(Optional)

1. Install docker client on your machine
2. Pull the docker image:
```
   docker pull samarenb/takehomechlng
```
   
3. Run the image:
```
   docker run -p 8080:8080 -p 9091:9091 samarenb/takehomechlng
```   
4. Use shell commands like curl or browser plugin to interact with the service

### Testing locally
Install API testing tool such as SOAP UI(https://www.soapui.org/docs/rest-testing/) or Postman(Browser extension)/Curl(Command line) in order to test the API locally (https://svitla.com/blog/testing-rest-api-with-postman-and-curl).

### API Resources

 - [GET foodTrucks/{locationid}
 - [GET /foodTrucks?block={blockid}
 - [POST /foodtrucks




### GET /foodTrucks/{locationid}

Example: http://localhost:8080/foodtrucks/1514023

Response body:

    {
    "locationid": 1514023,
    "applicant": "Bay Area Mobile Catering, Inc. dba. Taqueria Angelica's",
    "facilityType": "Truck",
    "address": "1455 MARKET ST",
    "block": "3507",
    "status": "APPROVED",
    "foodItems": "Tacos: burritos: soda & juice",
    "latitude": 37.77522830783405,
    "longitude": -122.4174661318695
    }

### GET /foodTrucks?block={blockid}

Example: http://localhost:8080/foodtrucks?block=3721

Response body:

    [{
    "locationid": 1367290,
    "applicant": "Star Taco",
    "facilityType": "",
    "address": "580 HOWARD ST",
    "block": "3721",
    "status": "REQUESTED",
    "foodItems": "Mexican Food",
    "latitude": 37.7873042488646,
    "longitude": -122.39803725191237},
     {
    "locationid": 1534033,
    "applicant": "Off the Grid Services, LLC",
    "facilityType": "",
    "address": "65 MINNA ST",
    "block": "3721",
    "status": "REQUESTED",
    "foodItems": "N/A",
    "latitude": 37.7879095795372,
    "longitude": -122.39836076940526
    }, {
    "locationid": 1447794,
    "applicant": "Street Meet",
    "facilityType": "Truck",
    "address": "564 HOWARD ST",
    "block": "3721",
    "status": "REQUESTED",
    "foodItems": "Tortas: Burritos: Tacos: Churros: Nachos: Asada Fries",
    "latitude": 37.787539893467496,
    "longitude": -122.39772670915164
    }]



### POST /foodtrucks

Example: Create ??? POST  http://localhost:8080/foodtrucks

Request body:

     {
    "locationid": 1511111,
    "applicant": "Flavors of Africa",
    "facilityType": "Truck",
    "address": "555 MISSION ST",
    "block": "3721",
    "status": "APPROVED",
    "foodItems": "Meat and vegi rice bowls: meat and vegi salad bowls: meat and vegi wraps: drinks and juices.",
    "latitude": 37.78844615690132,
    "longitude": -122.3986412420388
    }



### Built With

* [Java](https://java.com)
* [SpringBoot](https://spring.io)
* [Maven](https://maven.apache.org) 


### Observability
The application exposes health/info/metrics endopoints for observality, in order to create a dashboard we can utilize the endpoints below. Also there are logging statements for debugging and info throughout the code.

* http://localhost:9091/actuator/health
* http://localhost:9091/actuator/info
* http://localhost:9091/actuator/metrics
* http://localhost:9091/actuator/metrics/{requiredMetricName}


### To Do
* Add Pagination to the API responses
* Add Search functionality, given a location ID
