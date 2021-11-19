# scylla-spring-cassandra
Simple example on how to override spring-data-cassandra transitional dependencies to Scylla ones.

**NOTES:** Ensure the same JAR release is set as listed on the respective `spring-data-cassandra` you use.

Useful commands:
  - `gradle build` to build the project
  - `gradle :shadowJar` to build a shadow JAR with all dependencies
  - `gradle getDeps` to place all dependent jars within the (newly created) `resources/` directory

