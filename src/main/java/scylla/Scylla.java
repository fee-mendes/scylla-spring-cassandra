package scylla;

import java.util.Date;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.query.Criteria;
import org.springframework.data.cassandra.core.query.Query;
import org.springframework.data.cassandra.core.cql.CqlTemplate;
import org.springframework.data.cassandra.core.cql.session.*;
import org.joda.time.LocalTime;

import com.datastax.oss.driver.api.core.CqlSession;



public class Scylla {
  public static void main(String[] args) {

  CqlSession cqlSession = CqlSession.builder().withKeyspace("system").withLocalDatacenter("datacenter1").build();
  CqlTemplate cqlTemplate = new CqlTemplate();

  cqlTemplate.setSessionFactory(new DefaultSessionFactory(cqlSession));

  LocalTime currentTime = new LocalTime();
  System.out.println("The current local time is: " + currentTime);
  System.out.println("Hello world!");

  System.out.println("If you are seeing this, you connected successfully!\n\n");

  while(true){
	  long rowCount = cqlTemplate.queryForObject("SELECT COUNT(*) FROM clients", Long.class);
	  Date nodeDate = cqlTemplate.queryForObject("select toTimestamp(system.now()) from system.local", Date.class);

	  System.out.println("The current node timestamp is: " + nodeDate);
	  System.out.println("SELECT COUNT(*) FROM clients: " + rowCount);
  }

  }
}
