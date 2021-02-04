# resliv-task
Installation:
Maven.
Docker.
Docker compose.
After that:
You need to clone repository used git clone https://github.com/KirvelPasha/resliv-task.git.
And add token in telegram-bot/src/main/resources/application.yml
bot:
  token: ********
Go to folder resliv-task and write command: mvn install after build go to folder telegram-bot and write command mvn install.
After go to folder resliv-task and write command: " docker-compose build " after build write: " docker-compose up ".
Go to http://localhost:8081/swagger-ui.html and check telegram CityHelper
