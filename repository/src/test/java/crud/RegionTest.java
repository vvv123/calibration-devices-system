/*
package crud;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.softserve.edu.Application;
import com.softserve.edu.dao.catalogue.DistrictRepository;
import com.softserve.edu.dao.catalogue.RegionRepository;
import com.softserve.edu.entity.catalogue.District;
import com.softserve.edu.entity.catalogue.Region;
import org.apache.commons.collections.IteratorUtils;
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

import java.util.HashSet;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@DirtiesContext
// dbunit operations
@DatabaseSetup(RegionTest.DATASET)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = { RegionTest.DATASET })
public class RegionTest {
    protected static final String DATASET = "classpath:datasets/region.xml";
    protected static final String DATASET_EXPECTED = "classpath:datasets/region_expected.xml";

    @Autowired
    private RegionRepository repository;
    @Autowired
    private DistrictRepository districtRepository;

    @Test
    public void findAll() {
        // get all regions
        final Iterable<Region> regions = repository.findAll();
        final List<Region> r = IteratorUtils.toList(regions.iterator());

        // check region's count
        final int expectedRegionsCount = 3;
        assert r.size() == expectedRegionsCount;

        // get corresponding districts
        final List<District> expectedDistricts = IteratorUtils.toList(districtRepository.findAll().iterator());

        // check if all region have correct districts
        District actualDistrict = null;
        District expectedDistrict = null;

        for (int i = 0; i < r.size(); i++) {
            actualDistrict = r.get(i).getDistricts().iterator().next();
            expectedDistrict = expectedDistricts.get(i);

            assert actualDistrict.equals(expectedDistrict);
        }
    }

    @Test
    public void findByName() {
        // expected region's data
        final int expectedDistrictsCount = 1;
        final long expectedID = 1L;
        final String expectedName = "region1";

        // get region
        Region region = repository.findByName(expectedName);

        // check region
        assert region.getName().equals(expectedName);
        assert region.getId().equals(expectedID);
        assert region.getDistricts().size() == expectedDistrictsCount;

        // get the region's district
        final String expectedRegionName = "district1";

        District expectedDistrict = districtRepository.findByName(expectedRegionName);
        District actualDistrict = region.getDistricts().iterator().next();

        // check district
        assert actualDistrict.equals(expectedDistrict);
    }

    @Test
    @ExpectedDatabase(value = RegionTest.DATASET_EXPECTED,
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void deleteOne() {
        final long regionID = 3L;
        repository.delete(regionID);
    }

    @Test
    public void save() {
        District newDistrict = new District("newDistrict", null);
        Region newRegion = new Region("newRegion", new HashSet<>());
        newRegion.getDistricts().add(newDistrict);

        newDistrict = districtRepository.save(newDistrict);
        newRegion = repository.save(newRegion);

        Region actualRegion = repository.findByName(newRegion.getName());
        assert actualRegion.equals(newRegion);

        District actualDistrict = districtRepository.findByName(newDistrict.getName());
        assert actualDistrict.equals(newDistrict);

        final District regionsDistrict = actualRegion.getDistricts().iterator().next();
        assert actualDistrict.equals(regionsDistrict);
    }
}
*/
