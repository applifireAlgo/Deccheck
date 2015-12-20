




echo $PATH
DB_PATH=/tmp/applifire/db/DDHXMOIAZ0HRX8EYM9RW/80C055D8-1003-4A46-A841-92E107F06179
MYSQL=/usr/bin
USER=sales
PASSWORD=sales
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'