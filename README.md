# App Engine Standard & Google Cloud Endpoints Frameworks & Java

This sample demonstrates how to use Google Cloud Endpoints Frameworks using
Java on App Engine Standard.

## Build with Maven

### Building the sample project

To build the project:

    mvn clean package

### Generating the openapi.json file

To generate the required configuration file `openapi.json`:

    mvn endpoints-framework:openApiDocs

### Deploying the sample API to App Engine

To deploy the sample API:

0. Invoke the `gcloud` command to deploy the API configuration file:

         gcloud service-management deploy target/openapi-docs/openapi.json

0. Run the API implementation code by invoking:

         mvn appengine:run

    The first time you upload a sample app, you may be prompted to authorize the
    deployment. Follow the prompts: when you are presented with a browser window
    containing a code, copy it to the terminal window.

0. Wait for the upload to finish.

### Sending a request to the sample API

After you deploy the API and its configuration file, you can send requests
to the API.

To test the API, go to 
         
        localhost:8080/_ah/api/explorer


