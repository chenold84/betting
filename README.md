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

Fetches all the bets

> **Get** /api/bets

Create a bet using the fields

> **Post** /api/bets

Total investment per bet type

> **Get** /api/report/investment/type

Total investment per Customer ID

> **Get** /api/report/investment/customer

Total number of bets sold per hour

> **Get** /api/report/bets/hourly

Total bets sold per bet type

> **Get** /api/report/bets/type

## Addtional comments
For the default authentication refer to application.properties. This can be used out of the box for calling the rest API. Bootstrapping has been added, which will load data when the Spring context is loaded. Hence getter methods would return this data.
```
spring.security.user.name=appusr
spring.security.user.password=5181ad1c-4692-4f2a-8b7b-121536356681
```
