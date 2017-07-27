package yang.yang.springbootdemo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import yang.yang.companydemo.entity.Employee;
import yang.yang.companydemo.resource.CompanyResource;
import yang.yang.companydemo.service.CompanyService;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @InjectMocks
    private CompanyResource companyResource;
    @Mock
    private CompanyService companyService;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(companyResource).build();
    }

    @Test
    public void name() throws Exception {
        when(companyService.getAllEmployees()).thenReturn(Arrays.asList(new Employee("yang", "Dev")));
        this.mockMvc.perform(get("/company/all").accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andExpect(content().json("[{id:null,name:yang,description:Dev}]"));
    }

}