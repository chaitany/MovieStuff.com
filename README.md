# MovieStuff.com
A Movie Website based on subscribers preferences.

- The one and only movie website with only latest movies news and nothing bygone.
- Subscribers' profiles' fills up with their choosen favorite actors, actresses, productions...
- Allows advertising.
  
How To Run
----------

- Make sure the Eclipse version you have is the Java EE version, not the Java SE (if you go to "New.." and see "Dynamic Web Project, EJB Project ..." as options then you have the right one). Also, the type of database driver I have in the project is for MySQL 5.xxx . Other MySQL versions might work too, but if it doesn't you might need to check that.

- So once everything's installed it's time to import the project into Eclipse. Just copy the files manually into the workspace and then import. To do this go to " File -> Import -> General -> Existing Projects into Workspace " and then browse for the project. 

- Next step is to configure a server in Eclipse. Go to Window -> Show view -> Other... -> Servers . Once the view is up right click on it and hit new -> server. Then there will be a wizard that gets you through this. Then right click Tomcat, go to add and remove and add the movie site.

- Now, if you get a bunch of red errors on the java files after these two steps then you might have to configure your build path. Right click on the project and go to properties -> Java Build Path -> and add the JARs in WebContent/WEB-INF/lib. And probably also Add Library -> Server Runtime -> Apache Tomcat. 

- If this is all done correctly, you should be able to launch it (though the servers tab). Now it's time to get the database set up. There's a line that needs to be changed in the source code in com.movie.config.MovieConfig.java. You should see three strings at the top of the class that are the connection string, username and password. This is the info for your MySQL database. Change "moviedb" to a database you want to use (if you don't have one yet you'll need to create one through MySQL). And of course change the other ones to your MySQL username and password.

- Last thing! Load the tables. In a folder called database are some SQL scripts, one of which is called createdb.sql. You can run this either through the MySQL command line OR there's an ANT file in there you can use. If you have ANT, just go to that directory in the command line and type "ant load-mysqldb". 
