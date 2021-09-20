FROM httpd:2.4.35-alpine

ARG APP_NAME=jvcdp-ui
ARG APP_BASE_DIR=/usr/local/apache2/htdocs
ENV APP_BASE_DIR $APP_BASE_DIR
ENV APP_NAME ${APP_NAME}

COPY ./dist/ $APP_BASE_DIR/
COPY entrypoint.sh $APP_BASE_DIR/
#RUN  chown -R www-data:www-data $APP_BASE_DIR/ && \
RUN  apk add openrc --no-cache && \   
     chmod -R 0775 $APP_BASE_DIR

EXPOSE 80
WORKDIR $APP_BASE_DIR
#USER www-data
ENTRYPOINT ["./entrypoint.sh"]
CMD ["/usr/local/bin/httpd-foreground"]
