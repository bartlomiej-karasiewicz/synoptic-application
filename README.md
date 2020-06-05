Synoptic application is application which downloading weather data at a specified interval from
external public API, sending the report by e-mail basing on provided mail.

The Application consists of two services:
- weather service - include front-end, put report with mail on queue, download data from API and save those data in database
- mail service - send mail to provider basing on provide information from queue

Those two services are working with docker technology and deploy on the AWS. Application communicate each other basing on REST protocol.

Technology stack:
- DevOps: AWS EC2, AWS S3 bucket, AWS RDS Postgresql, Docker
- Front-end: Bootstrap, Javascript, Thymeleaf
- Back-end: Spring Boot, Spring Data, RabbitMQ, Maven, Spock
