package test.superbiz.cloudfoundry;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import org.superbiz.cloudfoundry.ServiceCredentials;

public class ServiceCredentialsTest {
    @Test
    public void testDataSource() throws Exception {
        //language=JSON
        String vcapServices = "{\n" +
                                  "  \"cleardb\": [\n" +
                                  "   {\n" +
                                  "    \"binding_name\": null,\n" +
                                  "    \"credentials\": {\n" +
                                  "     \"hostname\": \"us-cdbr-iron-east-01.cleardb.net\",\n" +
                                  "     \"jdbcUrl\": \"jdbc:mysql://someurl\",\n" +
                                  "     \"name\": \"dbname\",\n" +
                                  "     \"password\": \"password\",\n" +
                                  "     \"port\": \"3306\",\n" +
                                  "     \"uri\": \"mysql://someuri\",\n" +
                                  "     \"username\": \"username\"\n" +
                                  "    },\n" +
                                  "    \"instance_name\": \"movies-mysql\",\n" +
                                  "    \"label\": \"cleardb\",\n" +
                                  "    \"name\": \"movies-mysql\",\n" +
                                  "    \"plan\": \"spark\",\n" +
                                  "    \"provider\": null,\n" +
                                  "    \"syslog_drain_url\": null,\n" +
                                  "    \"tags\": [\n" +
                                  "     \"Cloud Databases\",\n" +
                                  "     \"Data Stores\",\n" +
                                  "     \"Developer Tools\",\n" +
                                  "     \"Web-based\",\n" +
                                  "     \"Data Store\",\n" +
                                  "     \"Development and Test Tools\",\n" +
                                  "     \"Online Backup \\u0026 Storage\",\n" +
                                  "     \"Single Sign-On\",\n" +
                                  "     \"Buyable\",\n" +
                                  "     \"relational\",\n" +
                                  "     \"mysql\",\n" +
                                  "     \"Cloud Security and Monitoring\"\n" +
                                  "    ],\n" +
                                  "    \"volume_mounts\": []\n" +
                                  "   }\n" +
                                  "  ],\n" +
                                  "  \"user-provided\": [\n" +
                                  "   {\n" +
                                  "    \"binding_name\": null,\n" +
                                  "    \"credentials\": {\n" +
                                  "     \"access_key_id\": \"asdfasdf\",\n" +
                                  "     \"bucket\": \"student-artifacts-elbert\",\n" +
                                  "     \"secret_access_key\": \"112341234sdfqer\"\n" +
                                  "    },\n" +
                                  "    \"instance_name\": \"photo-storage\",\n" +
                                  "    \"label\": \"user-provided\",\n" +
                                  "    \"name\": \"photo-storage\",\n" +
                                  "    \"syslog_drain_url\": \"\",\n" +
                                  "    \"tags\": [],\n" +
                                  "    \"volume_mounts\": []\n" +
                                  "   }\n" +
                                  "  ]\n" +
                                  " }";

        ServiceCredentials serviceCredentials = new ServiceCredentials(vcapServices);

        String accessKeyId = serviceCredentials.getCredential("photo-storage", "user-provided", "access_key_id");

        assertThat(accessKeyId, equalTo("asdfasdf"));

    }
}
