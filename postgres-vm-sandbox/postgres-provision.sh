#!/bin/bash

sudo apt-get update && sudo apt-get -y install postgresql

# set the default to listen to all addresses
sudo sed -i "/port*/a listen_addresses = '*'" /etc/postgresql/10/main/postgresql.conf

# allow any authentication mechanism from any client
sudo sed -i "$ a host all all all trust" /etc/postgresql/10/main/pg_hba.conf

# create db named testdb
sudo su postgres -c "createdb testdb"

# restart the service to allow changes to take effect
sudo service postgresql restart