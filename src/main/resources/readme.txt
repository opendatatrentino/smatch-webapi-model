= User Manual =

== Introduction ==
   * Name of the project: (smatch-webapi-model)
   * Version of the project: 1.0.0
   * Release notes: https://sweb.science.unitn.it/trac/sweb/wiki/ReleaseNotes/smatch-webapi-model/1.0.0
   * Javadocs: https://sweb.science.unitn.it/javadocs/smatch-webapi-model/1.0.0 

== Goal of the module ==

The goal of this module is to be used to develop client and server modules for S-Match Web API.

An example for a client that uses this model is here: https://github.com/opendatatrentino/smatch-webapi-client

and an example for a server that uses this model is here: https://github.com/opendatatrentino/smatch-webapi-server

== Getting started ==
 * Requirements: Java and Maven.
   * The maven pom.xml dependency (POM snippet)

{{{
<dependency>
    <groupId>it.unitn.disi</groupId>
    <artifactId>smatch-webapi-model</artifactId>
    <version>1.0.0</version>
</dependency>
}}}

   * How to install: include the POM snippet in your project.
   * How to configure: configure the HTTP connection (the host URL and the port) in the smatch-webapi-model.

== How to use ==
   1. Basic use: The model is used to develop smatch-webapi-client and smatch-webapi-server.
   1. Advanced use: a theorical explanation of S-Match can be found at http://semanticmatching.org/s-match.html.


== Troubleshooting ==
solutions to common problems

== FAQ ==
frequently asked questions
 1. How can I change the Host and the Port of the S-Match Web API ?
 
This is done in the file smatch-webapi-model.properties, the values of the host and port can be specified. The default values are localhost and 9090.

== Contacts ==
Moaz Reyad: reyad @ disi.unitn.it