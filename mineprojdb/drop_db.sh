




echo $PATH
DB_PATH=/tmp/applifire/db/LA4IF7EAM31HVZ7VFOEC0G/80C055D8-1003-4A46-A841-92E107F06179
MYSQL=/usr/bin
USER=mineproj
PASSWORD=mineproj
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'