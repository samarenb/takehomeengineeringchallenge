<!-- ABOUT THE PROJECT -->
## About The Project

[![Product Name Screen Shot][product-screenshot]](https://example.com)

There are many great README templates available on GitHub, however, I didn't find one that really suit my needs so I created this enhanced one. I want to create a README template so amazing that it'll be the last one you ever need -- I think this is it.

Here's why:
* Your time should be focused on creating something amazing. A project that solves a problem and helps others
* You shouldn't be doing the same tasks over and over like creating a README from scratch
* You should element DRY principles to the rest of your life :smile:

Of course, no one template will serve all projects since your needs may be different. So I'll be adding more in the near future. You may also suggest changes by forking this repo and creating a pull request or opening an issue. Thanks to all the people have have contributed to expanding this template!

A list of commonly used resources that I find helpful are listed in the acknowledgements.


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
* [Maven]  



###Observability Endpoints

* http://localhost:9091/actuator/health
* http://localhost:9091/actuator/info
* http://localhost:9091/actuator/metrics
* http://localhost:9091/actuator/metrics/{requiredMetricName}