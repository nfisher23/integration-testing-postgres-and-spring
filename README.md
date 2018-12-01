# integration-testing-postgres-and-spring
Some sample code demonstrating the use of the Maven Failsafe plugin with setup and teardown code. Uses a Vagrant VM for the postgreSQL database.

## Usage
Make sure you have [Vagrant](https://www.vagrantup.com/) installed, and Apache Maven with Java 10. First:

```
$ cd ./postgres-vm-sandbox/
$ vagrant up
```

Once the VM is up and running, do (from root of git directory):

```
$ cd ./integration-with-setup-and-teardown/
$ mvn clean install
```

The blog posts for this sample code are:

1. [How to Set Up a Local Unsecured Postgres Virtual Machine (for testing)](https://nickolasfisher.com/blog/How-to-Set-Up-a-Local-Unsecured-Postgres-Virtual-Machine-for-testing)
2. [How to Run Integration Tests with Setup and Teardown Code in Maven Build](https://nickolasfisher.com/blog/How-to-Run-Integration-Tests-with-Setup-and-Teardown-Code-in-Maven-Build)
3. [How to Use Spring's Dependency Injection in Setup And Teardown Code For Integration Tests With Maven](https://nickolasfisher.com/blog/How-to-Use-Springs-Dependency-Injection-in-Setup-And-Teardown-Code-For-Integration-Tests-With-Maven)
