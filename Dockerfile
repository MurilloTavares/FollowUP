FROM payara/micro

COPY target/FollowUP.war ${DEPLOY_DIR}
