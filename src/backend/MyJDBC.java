package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Constant.CommonConstants;

public class MyJDBC {
    // we will first start with registering new user to our DB

    public static boolean register(String username, String password){
        // first chech if the username is already exists in the database
        // we will make a separate method to check if the user already exists
        try {
            // the logic is that we will only register if the user doesn't found in ihe DB
            if(!checkUser(username)){
                // connection to the database
                Connection connection = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);

                //create insert query
                PreparedStatement insertUser = connection.prepareStatement(
                    "INSERT INTO " + CommonConstants.DB_USER_TABLE + "(username, password)" + " VALUES(?, ?)"
                    );

                    insertUser.setString(1, username);
                    insertUser.setString(2, password);

                    // update db with new user
                    insertUser.executeUpdate();

                    return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // check if username already exist in the database
    // false --> user doesn't exist in the database
    // true --> user exist in the database
    public static boolean checkUser(String username){
        try {
            // connect JDBC server
            Connection connection = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);

            //write sql querries using some interfaces
            PreparedStatement checkUserExist = connection.prepareStatement(
                "SELECT * FROM " + CommonConstants.DB_USER_TABLE + " WHERE USERNAME = ?" 
            );

            // WE WILL REPLACE THIS "?" WITH VALUES USING THE SETsTRING()
            checkUserExist.setString(1, username);

            //then we will store our result in a result set which we will be able to acess
            ResultSet resultset =  checkUserExist.executeQuery();

            //check to see if the result set is empty
            //if it is empty it means that there was no data row that contains the username
            // [example -- user doesn't exists]
            // we use the isBeforeFirst() to point to the first row of data that is returned to our result set
            if(!resultset.isBeforeFirst()){
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // if the user doen't exist in the database
        return true;
    }


    //validate user login
    //validate login credentials by checking to see if username/password pair exists in the database
    public static boolean validateLogin(String username, String password){
        try {
            Connection connection = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);

            //create select query
            PreparedStatement validateUser = connection.prepareStatement(
                "SELECT * FROM " + CommonConstants.DB_USER_TABLE + " WHERE USERNAME = ? AND PASSWORD = ?"
            );

            validateUser.setString(1, username);
            validateUser.setString(2, password);

            ResultSet resultSet = validateUser.executeQuery();

            // isBeforeFirst is used here to see if your query returned any rows that matched our query
            if(!resultSet.isBeforeFirst()){
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // if it is true, it means that there was a username/password pair that matched with the user input
        return true;
    }
}
