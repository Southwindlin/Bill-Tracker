FROM postgres:13.8
ENV POSTGRES_PASSWORD postgres
ENV POSTGRES_DB=billtracker

WORKDIR db

COPY scripts/init.sql /docker-entrypoint-initdb.d/
