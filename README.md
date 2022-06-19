# devsuperior-client-project
CRUD project of client , proposed by devsuperior backend course as training 


This project details a Client class that boasts the following attributes
*  Long Id
*  String Name
*  String Cpf 
*  Double Income
*  Instant birthDate
*  Integer Children


                                                  H2 DATABASE
The DataBase used is H2 and can be accessed by the link   **   http:/localhost:8080/h2-console   **  after running the program
With the username : sa
         password :  


                                                  IMPORT.SQL
This file can be found in "src/main/resources" and it's used to seed the database with initial information TABLE tb_client


                                                  POSTMAN
After running the program , initialize postman and send the following requests

                        # GET ALL CLIENTS PAGED
  *GET                                
  RequestURL -http://localhost:8080/clients?page=1&linesPerPage=6&direction=ASC&orderBy=name
  
                          # GET CLIENT BY ID
  *GET   
  RequestURL -http://localhost:8080/clients/10
  
                          - DELETE CLIENT
  *DEL   
  RequestURL -http://localhost:8080/clients/10
  
                          - INSERT CLIENT
  *POST  
  RequestURL -http://localhost:8080/clients
  Body -Raw-Json 
                  {
                  "name": "Sirius Black",
                  "cpf": "123.456.879.01",
                  "income": 3000.50,
                  "birthDate": "2020-07-20T10:00:00Z",
                  "children": 0
                  }
  
                          - UPDATE CLIENT
  *POST  
  RequestURL -http://localhost:8080/clients/10
    Body -Raw-Json 
                  {
                  "name": "James Pottr",
                  "cpf": "987.654.321-10
                  "income": 6398.25
                  "birthDate": "2020-07-20T10:00:00Z",
                  "children": 1
                  }
  
  
  
  
  
