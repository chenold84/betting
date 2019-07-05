# betting
Application to accept bets
## Introduction
A spring boot application which exposes rest endpoints to do the create bet, retrieve all bets, generate reports. It uses in-memory h2 database and has spring security enabled. It uses a basic user ID and password authentication
## Fields
Field | Data Type | Sample
------|-----------|-------
dateTime | Date time | 2019-07-03T23:11:58.782
betType | String | WIN / PLACE / TRIFECTA / DOUBLE / QUADDIE
propNumber | Integer | 1000
customerId | Integer | 20000
investmentAmt | BigDecimal | 2000 

## Rest Endpoints

> **Get** /api/bets
Fetches all the bets

> **Post** /api/bets 
Create a bet using the fields

> **Get** /api/report/investment/type
Total investment per bet type

> **Get** /api/report/investment/customer
Total investment per Customer ID

> **Get** /api/report/bets/hourly
Total number of bets sold per hour

> **Get** /api/report/bets/type
Total bets sold per bet type

## Addtional comments
For the default authentication refer to application.properties
```
spring.security.user.name=appusr
spring.security.user.password=5181ad1c-4692-4f2a-8b7b-121536356681
```
