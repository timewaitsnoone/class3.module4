import com.lagou.edu.AutodeliverApplication28091;
import com.lagou.edu.AutodeliverApplication28091;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest(classes={AutodeliverApplication28091.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AutodeliverApplicationTest {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Test
    public void testInstanceMeta(){
        List<ServiceInstance> instances = discoveryClient.getInstances("lagou-service-resume");
        for(int i=0;i<instances.size();i++){
            ServiceInstance serviceInstance = instances.get(i);
            System.out.println(serviceInstance);
        }
    }
}
