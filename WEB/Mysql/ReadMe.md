VScode Start (admin)

    # sudo code --user-data-dir &


MySql Start (admin)

   mysql -u root -p mysql

mysql>
    drop user 'user'@'localhost';
    create user 'user'@'localhost' identified by 'password';
    grant all privileges on *.* to 'user'@'localhost';


    create database opentutorials;
    use opentutorials;

