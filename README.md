# movie-query
Comand line tool that allows the user to query a selection of public APIs for information on a given film

## Requirements

To build and run the jar you will need

Java 1.8
Maven 3

## Build

Run the following on the command line:

    mvn clean package

## Usage

An `apis.xml` file must be provided as a sibling of the jar.

    java -Dapi=<api> -Dmovie=<movie> -jar target/movie-query-1.0.jar
    
e.g.

    java -Dapi=OMDB -Dmovie="Indiana Jones" -jar target/movie-query-1.0.jar
    
The `apis.xml` file must be of the following format:

    <apis>
        <api>
            <name>OMDB</name>
            <url>http://www.omdbapi.com/</url>
            <arguments>
                <argument>
                    <key>type</key>
                    <value>movie</value>
                </argument>
            </arguments>
        </api>
    </apis>

Where the name is the command line argument `-Dapi`, the URL is the root of the REST api and 
the arguments are GET parameters in your request.

### Nice-to-haves (for this small project):

Implement a total mocking framework or using something like Mockito to fully cover everything.
Run against SonarQube or some other code quality tool.

Would have liked to not use the QueryFactory, as it tightly couples the APIs and makes the XML file largely redundant
(other than a way to stop people obtaining my TMDB api_key)