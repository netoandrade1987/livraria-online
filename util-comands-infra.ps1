https://livraria-online-api.herokuapp.com/swagger-ui.html


##Manver Comands##

mvn package

mvn clean package

mvn clean package -Dskiptests


java -jar .\target\livraria-online-0.0.1.jar --spring.profiles.active=prod --spring.config.location=C:\Users\neto_\eclipse-workspace2\livraria-online\src\main\resources\



##Docker comands##


docker build -t alura/livraria-online . 


docker image list

docker run  -p8001:8001 alura/livraria-online

docker-compose --version


docker-compose up

docker-compose down

##Roda em background
docker-compose up -d carteira_database


docker-compose up -d carteira_app


docker ps

docker-compose down

##Roda e consegue ver os logs
docker-compose up carteira_database

docker-compose up carteira_app

https://devcenter.heroku.com/articles/container-registry-and-runtime



heroku container:login
Get sample code by cloning an Alpine-based python example:

git clone https://github.com/heroku/alpinehelloworld.git
Navigate to the app’s directory and create a Heroku app:

heroku create
Creating salty-fortress-4191... done, stack is heroku-18
https://salty-fortress-4191.herokuapp.com/ | https://git.heroku.com/salty-fortress-4191.git
Build the image and push to Container Registry:

heroku container:push web
Then release the image to your app:

heroku container:release web
Now open the app in your browser:

heroku open
Logging in to the registry
Heroku runs a container registry on registry.heroku.com.

If you are using the Heroku CLI, you can log in with:

heroku container:login
or directly via the Docker CLI:

docker login --username=_ --password=$(heroku auth:token) registry.heroku.com
Building and pushing image(s)
Build an image and push
To build an image and push it to Container Registry, make sure that your directory contains a Dockerfile and run:

heroku container:push <process-type>
Pushing an existing image
To push an image to Heroku, such as one pulled from Docker Hub, tag it and push it according to this naming template:

docker tag <image> registry.heroku.com/<app>/<process-type>
docker push registry.heroku.com/<app>/<process-type>






