# Trading Office - Confirmation Service
[![Build Status](https://travis-ci.org/spolnik/trading-office-confirmation-service.svg?branch=master)](https://travis-ci.org/spolnik/trading-office-confirmation-service) [![codecov.io](https://codecov.io/github/spolnik/trading-office-confirmation-service/coverage.svg?branch=master)](https://codecov.io/github/spolnik/trading-office-confirmation-service?branch=master) [![Sonar Coverage](https://img.shields.io/sonar/https/sonar-nprogramming.rhcloud.com/trading-office-confirmation-service/coverage.svg)](https://sonar-nprogramming.rhcloud.com/dashboard/index/1) [![Sonar Tech Debt](https://img.shields.io/sonar/https/sonar-nprogramming.rhcloud.com/trading-office-confirmation-service/tech_debt.svg)](https://sonar-nprogramming.rhcloud.com/dashboard/index/1)

Trading Office is reference implementation of microservices architecture, based on Spring Boot. It's modeling part of post trade processing, mainly focused on receiving Fixml message and preparing confirmation for it.

- [Trading Office](#trading-office)
- [Confirmation Service](#confirmation-service)
- [Notes](#notes)

## Trading Office

- [Trading Office](https://github.com/spolnik/trading-office)

## Confirmation Service
- spring boot web application (rest service)
- exposes REST endpoint api to store and retrieve confirmations
- confirmations stored as files

Heroku: http://confirmation-service.herokuapp.com/swagger-ui.html

![Component Diagram](https://raw.githubusercontent.com/spolnik/trading-office-confirmation-service/master/design/confirmation_service.png)

## Notes
- checking if [dependencies are up to date](https://www.versioneye.com/user/projects/56ad39427e03c7003ba41427)
- installing RabbitMQ locally (to run end to end test locally) - [instructions](https://www.rabbitmq.com/download.html)
- to run on Mac OS X - /usr/local/sbin/rabbitmq-server 
