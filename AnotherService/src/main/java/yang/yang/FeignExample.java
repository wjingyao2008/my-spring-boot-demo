package yang.yang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by yanyan on 2017/07/27.
 */
@Component
class FeignExample implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeignExample.class);

    private final CompanyDemoServiceClient companyDemoServiceClient;

    @Autowired
    public FeignExample(CompanyDemoServiceClient companyDemoServiceClient) {
        this.companyDemoServiceClient = companyDemoServiceClient;
    }

    @Override
    public void run(String... strings) throws Exception {
        LOGGER.info("start to query the company service by client");
        this.companyDemoServiceClient.getAllEmployees().forEach(it->LOGGER.info(it.toString()));
    }
}

@FeignClient("CompanyDemoService")
@RequestMapping("company")
interface CompanyDemoServiceClient {

    @RequestMapping(value = "all", method = RequestMethod.GET)
     List<Object> getAllEmployees();

}