FROM jboss/wildfly:14.0.1.Final
ADD target/*.war /opt/jboss/wildfly/standalone/deployments/

#FROM tomee
#COPY target/*.war /usr/local/tomee/webapps/fhws-2018

#FROM payara/server-full
#COPY target/*.war $DEPLOY_DIR
