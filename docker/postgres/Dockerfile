FROM postgres:13.3
ENV POSTGRES_PASSWORD git ini
ENV POSTGRES_DB=billsplitter

WORKDIR docker

COPY init.sql /docker-entrypoint-initdb.d/
