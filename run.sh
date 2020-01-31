#!/bin/sh

mvn clean compile war:exploded && cp -R web/* tomcat/webapps/lab6 && ./tomcat/bin/catalina.sh run
