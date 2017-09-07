# Sensor Web

## Database
To get this project working on your computer, you will need to have a mysql server up and running.
The default credentials for this project are:
```
username: root
password: root
```

If your mysql credentials are different, then you can either change the application.properties file to the correct
values, or you can change your mysql root password to match. 

This project also requires that you have a database called `sensorweb` on your localhost mysql server.
Once the database (schema) has been created, JPA will do the rest of the work for you.