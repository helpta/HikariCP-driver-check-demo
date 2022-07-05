package com.helpta.hikaricp.driver;

import java.io.File;
import java.net.URL;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import cn.hutool.core.io.resource.ResourceUtil;

/**
* @author ${USER}
* @date ${DATE} ${TIME}
*/
public class Main {
    public static void main(String[] args)
        throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

//        loaderVersion1();
        loaderVersion2();
        Enumeration<Driver> drivers = DriverManager.getDrivers();
//        System.err.println("driver.size="+drivers.);
        while(drivers.hasMoreElements()){
            Driver driver = drivers.nextElement();
            System.err.println(driver);
        }
        System.err.println();
    }

//    private static void loaderVersion1() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
//        URL resource = ResourceUtil.getResource("mysql-connector-java-8.0.29.jar");
//        JarClassLoader jarClassLoader = new JarClassLoader();
//        //        Main.class.getClassLoader().getResource("");
//        jarClassLoader.addJar(new File(resource.getFile()));
//        Class<Driver> driverClass = (Class<Driver>)jarClassLoader.loadClass("com.mysql.cj.jdbc.Driver");
//         driverClass.newInstance();
//    }

    private static void loaderVersion2() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        URL resource = ResourceUtil.getResource("mysql-connector-java-8.0.20.jar");
        JarClassLoader jarClassLoader = new JarClassLoader();
        //        Main.class.getClassLoader().getResource("");
        jarClassLoader.addJar(new File(resource.getFile()));
        Class<Driver> driverClass = (Class<Driver>)jarClassLoader.loadClass("com.mysql.cj.jdbc.Driver");
        driverClass.newInstance();
    }
}