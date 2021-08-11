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
Commands:<br/>
docker pull samarenb/takehomechlng<br/>
docker run -p 8080:8080 -p 9091:9091 samarenb/takehomechlng<br/>
1. Get a free API Key at [https://example.com](https://example.com)
2. Clone the repo
   ```sh
   git clone https://github.com/your_username_/Project-Name.git
   ```
3. Install NPM packages
   ```sh
   npm install
   ```
4. Enter your API in `config.js`
   ```JS
   const API_KEY = 'ENTER YOUR API';
   ```
   

### API Endpoints

* http://localhost:8080/foodTrucks/{locationid}
* http://localhost:8080/foodTrucks?block={blockid}
* http://localhost:8080/foodTrucks


## Usage

Use this space to show useful examples of how a project can be used. Additional screenshots, code examples and demos work well in this space. You may also link to more resources.

_For more examples, please refer to the [Documentation](https://example.com)_


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