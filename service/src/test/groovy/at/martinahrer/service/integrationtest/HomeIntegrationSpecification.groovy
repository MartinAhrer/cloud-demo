package at.martinahrer.service.integrationtest

import at.martinahrer.service.ServiceApplication
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.boot.test.TestRestTemplate
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.http.HttpStatus
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

@SpringApplicationConfiguration(classes = ServiceApplication)
@WebIntegrationTest(randomPort = true) // equals to ("server.port:0")
class HomeIntegrationSpecification extends Specification {

    @Value('${local.server.port}')
    int port;

    RestTemplate template = new TestRestTemplate();

    def "should be welcome at home" () {
        expect:
            def response=template.getForEntity("http://localhost:"+port, String.class)
            HttpStatus.OK == response.statusCode
            response.body.contains 'Hello World'
            response.body.contains InetAddress.localHost.canonicalHostName
    }
}
