package yang.yang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yanyan on 2017/07/27.
 */
@Component
@RestController
@RequestMapping("services")
class AnotherService implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnotherService.class);

    public AnotherService() {
        LOGGER.info("another service start");
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    public void run(String... strings) throws Exception {
        List<String> companyDemoService = getServiceDetailsByName("CompanyDemoService");
        LOGGER.info("all CompanyDemoService:{}",companyDemoService);
    }

    @RequestMapping
    public List<String> getServiceDetailsByName(@RequestParam("name")String svcName) {
        //print the Discovery Client Description
        LOGGER.info(discoveryClient.description());
        // Get restaurant-service instances and prints its info
        return discoveryClient.getInstances(svcName).stream().map((ServiceInstance serviceInstance) ->
                                                                   new StringBuilder("Instance --> ")
                                                                           .append(serviceInstance.getServiceId())
                                                                           .append(",Server: ").append(serviceInstance.getHost())
                                                                           .append(":").append(serviceInstance.getPort())
                                                                           .append(",URI: ").append(serviceInstance.getUri())
                                                                           .toString()).collect(Collectors.toList());
    }
}