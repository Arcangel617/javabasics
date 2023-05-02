## Java back to basics

The purpose of this repository is to let java developers know all the must have knowledge you need to acquire 
in order to succeed in the labour market. In this repository I will focus on simple exercises.

### What do you need?

At least an idea of what is programming. If you don't have any idea, I'll prepare some materials for abosulutely beginners.

### Which tools will be use?

- IntelliJ Idea
- Lombok
- Junit
- Mockito
- Sonarqube
- Maven   

## Setting up your environment

### How to run sonarqube server locally.

``$ docker pull sonarqube``

``$ docker run -d --name sonarqube -p 9000:9000 sonarqube``

``$ docker start sonarqube``

once the sonarqube server is running, you should open in your browser:

``http://localhost:9000``
