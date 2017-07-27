package yang.yang.springbootdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Created by yanyan on 2017/07/05.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class BookControllerTest2 {

//    @Autowired
//    private MockMvc mockMvc;
//    @InjectMocks
//    private CompanyResource companyResource;
//    @Mock
//    private CompanyService companyService;
//
//    @Before
//    public void setUp() throws Exception {
//        this.mockMvc = MockMvcBuilders.standaloneSetup(companyResource).build();
//    }
//
    @Test
    public void name() throws Exception {
//        when(companyService.getAllEmployees()).thenReturn(Arrays.asList(new Employee("yang", "Dev")));
//        this.mockMvc.perform(get("/company/all").accept(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(status().isOk()).andExpect(content().json("[{id:null,name:yang,description:Dev}]"));
    }

}