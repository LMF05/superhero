# Superhero application
This project include a Dockerfile, to create a docker image, you just need to have docker installed and be in the root directory of the project. Doing 
`docker build -t super-dev/superhero .` you'll have you docker image ready. 

Then you can launch the app with Docker Desktop indicating in Local Host option, 8080 port.
You can launch the app with this command too
 
 `docker run -p 8080:8080 super-dev/superhero`
 
 The documentation of the API is in the url
 
 `http://localhost:8080/swaggerdocumentation`
