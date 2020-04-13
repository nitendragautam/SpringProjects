### Running the Spring boot application
(a) Make sure that Apache Maven is installed and in the Path


(b) Navigate to the root of the project directory and type

mvn sprint-boot:run


It will start the application at port 8199


URL

Display all the record 


#### From the browser
http://localhost:8199/app/records


#### From the bash 
curl http://localhost:8199/app/records


[{"id":1,"loginId":"ngaut","firstName":"Nitendra","lastName":"Gautam","currentAddress":"Dallas"},{"id":1,"loginId":"ngaut","firstName":"Nitendra","lastName":"Gautam","currentAddress":"Dallas"}]




Display the particular records 


curl http://localhost:8199/app/records/1



http://localhost:8199/app/records/1


{"id":1,"loginId":"ngaut","firstName":"Nitendra","lastName":"Gautam","currentAddress":"Dallas"}



http://localhost:8199/app/records/2




{"id":1,"loginId":"ngaut","firstName":"Nitendra","lastName":"Gautam","currentAddress":"Dallas"}



