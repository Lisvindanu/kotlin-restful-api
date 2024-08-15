# API Spec

## Authentication
All API must use this auth

Request : 
- Header :
  - X-Api-Key : "Your api keys"

## Create Product
Request :
- Method : POST
- Endpoint : `/api/products`
- Header :
    - Content-Type : application/json
    - Accept : application/json
- Body : 
```json 
{
  "id" : "String, unique",
  "name" : "Srting",
  "price" :"long",
  "quantity" : "integer"
} 
  ```
- Response : 
```json 
    {
  "code" : "number",
  "status" : "string",
  "data" : {
    "id" : "String, unique",
    "name" : "Srting",
    "price" : "long",
    "quantity" : "integer",
    "created at" : "date",
    "updatedAt" : "date"
  }
}
  ```

## Get Product
Request :
- Method : GET
- Endpoint : `/api/products`
- Header :
    - Accept : application/json
- Response :
- Response :
```json 
     {
  "code" : "number",
  "status" : "string",
  "data" : {
    "id" : "String, unique",
    "name" : "Srting",
    "price" : "long",
    "quantity" : "integer",
    "created at" : "date",
    "updatedAt" : "date"
  }
}
  ```
## Update Product
Request :
- Method : PUT
- Endpoint : `/api/products/{id_product}`
- Header :
    - Content-Type : application/json
    - Accept : application/json
- Body :
```json 
{
  "id" : "String, unique",
  "name" : "Srting",
  "quantity" : "integer"
} 
  ```
- Response :
```json 
    {
  "code" : "number",
  "status" : "string",
  "data" : {
    "id" : "String, unique",
    "name" : "Srting",
    "price" : "Long",
    "quantity" : "integer",
    "created at" : "date",
    "updatedAt" : "date"
  }
}
  ```
## List Product
Request :
- Method : GET
- Endpoint : `/api/products/`
- Header :

    - Accept : application/json
- Query Param :
  - pageSize : number,
  - page : number
- Body :

- Response :
```json 
    {
  "code" : "number",
  "status" : "string",
  "data" : [
    {
      "id" : "String, unique",
      "name" : "Srting",
      "price" : "Long",
      "quantity" : "integer",
      "created at" : "date",
      "updatedAt" : "date"
    }, {
      "id" : "String, unique",
      "name" : "Srting",
      "price" : "Long",
      "quantity" : "integer",
      "created at" : "date",
      "updatedAt" : "date"
    }
  ]
}
  ```
## Delete Product
Request :
- Method : DELETE
- Endpoint : `/api/products/{id_product}`
- Header :

    - Accept : application/json
- Body :

- Response :
```json 
    {
  "code" : "number",
  "status" : "string"
}
  ```