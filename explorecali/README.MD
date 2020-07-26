
## Build the file 

```bash

mvn install
```
## Running application from project root folder

Note that we are using port 9090 instead of default port 8080.

Change of port is needed if you have any other application running with the same port.


```bash

java -Dserver.port=9090 -jar target/explorecali-0.1.jar
```