package groovy;

import java.sql.*;
/*
import jenkins.model.*;
import org.codehaus.groovy.runtime.DefaultGroovyMethods;
import java.util.regex.Matcher;
import java.util.logging.Logger;
import java.io.*;
import java.net.*;
import java.security.*;
import java.util.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.lang.reflect.Method;
import groovy.sql.*;
import groovy.net.*;
import hudson.model.*
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;*/

def connect()
{/*
    sh "java -version"
    Logger logger = Logger.getLogger("")

    def groovyClassLoader = this.class.classLoader;
    def rootClassLoader = DefaultGroovyMethods.getRootLoader(groovyClassLoader);
    if (rootClassLoader == null)
    {
        rootClassLoader = groovyClassLoader;
        ClassLoader parentClassLoader = rootClassLoader.getParent();
        while (parentClassLoader != null)
        {
            rootClassLoader = parentClassLoader;
            parentClassLoader = parentClassLoader.getParent();
        }
    }
    String jenkinsHome = System.getenv()['JENKINS_HOME'];

    logger.info("Checking for jars in ${jenkinsHome}");
    File jarPath = new File("//tmp/postgresql-42.5.0.jar");

    print "${jarPath}";

    File file = new File("postgresql-42.5.0.jar");*/
    //if(file.exists()) {
        //URL url = file.toURI().toURL();
        //rootClassLoader.addURL(url);
        //rootClassLoader.addClasspath(url);
    //}


    //rootClassLoader.addURL(jarPath);
    //rootClassLoader.addClasspath(jarPath.toURI().toURL());


    //def localFile = new File("./postgresql-42.5.0.jar");
    //this.class.classLoader.rootLoader.addURL(localFile.toURI().toURL());
    /*Jenkins.getInstance().getPluginManager().uberClassLoader;
    URLClassLoader cl = new URLClassLoader (new URL("file:///tmp/postgresql-42.5.0.jar"));

    System.out.println ("Attempting...");

    Class beanClass = cl.loadClass ("org.postgresql.Driver");
    Object dog = beanClass.newInstance();

    Method method = beanClass.getDeclaredMethod ("setBean", String.class);
    method.invoke (dog, "Who let the dog out");

    method = beanClass.getDeclaredMethod("getBean", null);
    Object retObj = method.invoke (dog, null);

    String retVal = (String)retObj;

    System.out.println(retVal);
    System.out.println("Success!");

    Thread.currentThread().setContextClassLoader(this.class.classLoader);*/

    //this.class.classLoader.rootLoader.addURL("file:///bitnami/jenkins/home/.groovy/lib/postgresql-42.5.0.jar".toURI().toURL())


    try{
        //sh "set CLASSPATH=postgresql-42.5.0.jar"
        //sh "export CLASSPATH=postgresql-42.5.0.jar"
        Class.forName("org.postgresql.Driver");
        Connection con=DriverManager.getConnection("jdbc:postgresql://postgresql:5432/deneme","root","root");
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from accounts;");
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        print columnsNumber;
        for (int i = 1; i <= columnsNumber; i++)
        {
            String columnName = rsmd.getColumnName(i);
            print(columnName);
        }
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++)
            {
              String columnValue = rs.getString(i);
              print(columnValue);
            }
        }
        con.close();
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
}

return this;
