FROM openjdk:8-jre-slim
ENV JAVA_OPTS="-Xms256M -Xmx1024M"
COPY maven /maven/
WORKDIR /maven/Queue_Write_Read
RUN chmod +x /maven/Queue_Write_Read/Queue_Write_Read_run.sh
RUN sed -i 's/ -Xms[0-9]*M//g' /maven/Queue_Write_Read/Queue_Write_Read_run.sh
RUN sed -i 's/-Xmx[0-9]*M/$JAVA_OPTS/g' /maven/Queue_Write_Read/Queue_Write_Read_run.sh
ENTRYPOINT ["./Queue_Write_Read_run.sh"]
