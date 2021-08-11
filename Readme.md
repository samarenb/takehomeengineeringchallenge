<!-- ABOUT THE PROJECT -->
## About The Project


Rest API to find a food truck using location id and find food trucks in a block using block id, you can add food truck using post operation. For this release the food truck csv file is part of the resources folder.

### Installation Docker Image 

1. Install docker client on your machine
2. Pull the docker image:

   docker pull samarenb/takehomechlng
   
3. Run the image:

   docker run -p 8080:8080 -p 9091:9091 samarenb/takehomechlng
   
4. Use shell commands like curl or browser plugin to interact with the service
   

### API Resources

 - [GET foodTrucks/{locationid}
 - [GET /foodTrucks?block={blockid}
 - [POST /foodtrucks




### GET /foodTrucks/{locationid}

Example: http://localhost:8080/foodTrucks/1514023

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

Example: Create – POST  http://localhost:8080/foodtrucks

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

This section should list any major frameworks that you built your project using. Leave any add-ons/plugins for the acknowledgements section. Here are a few examples.
* [Java](https://java.com)
* [SpringBoot](https://spring.io)
* [Maven](https://maven.apache.org) 


### Observability Endpoints

* http://localhost:9091/actuator/health
* http://localhost:9091/actuator/info
* http://localhost:9091/actuator/metrics
* http://localhost:9091/actuator/metrics/{requiredMetricName}
