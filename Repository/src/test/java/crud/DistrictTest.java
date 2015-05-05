/*
package crud;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.softserve.edu.Application;
import com.softserve.edu.dao.catalogue.DistrictRepository;
import com.softserve.edu.entity.catalogue.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@DirtiesContext
// dbunit operations
@DatabaseSetup(DistrictTest.DATASET)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = { DistrictTest.DATASET })
public class DistrictTest {
    protected static final String DATASET = "classpath:datasets/district.xml";

    @Autowired
    private DistrictRepository districtRepository;

    @Test
    public void test() {
        District r = districtRepository.findByName("district1");
        assert (1 == r.getId());
    }
}
*/
