package mineproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import mineproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import mineproj.app.server.repository.VillageRepository;
import mineproj.app.shared.location.Village;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import mineproj.app.shared.location.Country;
import mineproj.app.server.repository.CountryRepository;
import mineproj.app.shared.location.District;
import mineproj.app.server.repository.DistrictRepository;
import mineproj.app.shared.location.Region;
import mineproj.app.server.repository.RegionRepository;
import mineproj.app.shared.location.State;
import mineproj.app.server.repository.StateRepository;
import mineproj.app.shared.location.Taluka;
import mineproj.app.server.repository.TalukaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class VillageTestCase {

    @Autowired
    private VillageRepository<Village> villageRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            Country country = new Country();
            country.setCapital("4TYdItLc937sX06oJM5R4EjgalCnu5DD");
            country.setCapitalLatitude(9);
            country.setCapitalLongitude(3);
            country.setCountryCode1("6fS");
            country.setCountryCode2("sHt");
            country.setCountryFlag("Ku6UPcVa4BCN5B1kjr4MjLMMENnt7EaTOZpsLrVMsX3T3tVxbA");
            country.setCountryName("O5nuAfcn4l6MlI5Z6M9dXJwzpgxl5X9Nz8sRUq6KL6Xob4VBe4");
            country.setCurrencyCode("Bzg");
            country.setCurrencyName("YotzU9dX05oVItl8y1qTp9dUA7COXowDJriBHNQYBbHtlZQ0hg");
            country.setCurrencySymbol("I7ozkEOMay8fhTQ2j437U6w5nkc4rATo");
            country.setIsoNumeric(5);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            District district = new District();
            district.setCode2("0CcbSXEUOgPxdIWooqlxNsj4spiXwOEi");
            Region region = new Region();
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("VNSADaeydP9uLyQHwkX5e3lhj9YXpCBsoJojzgLcAVF270xQYV");
            state.setStateCapitalLatitude(11);
            state.setStateCapitalLongitude(5);
            state.setStateCode(2);
            state.setStateCodeChar2("WDJIXY3kDaXz81x51iXTkrxFR3XzGyFJ");
            state.setStateCodeChar3("Xy5SyKGZHNpPcHVz4N0x8bKNnJCkI7pD");
            state.setStateDescription("BlGqCJ7UyFw9lYNplFmxXsadZDW3yMJxeGyXHyNUtxOsVIaI6y");
            state.setStateFlag("RzqX6Z1d0ySntYgvEZpWDHJNyL3M3gQo3qzNDkQTKW7W7ueegv");
            state.setStateName("oVMHCBVxmaXbtYMNERfC8KxdFcELxrHMTIVY4MxfVyiFdtQ8O0");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(2);
            region.setRegionCodeChar2("DiOIwGb01k9EinzqUTnbS5WKtOoPVxFt");
            region.setRegionDescription("j5FYPD4LJhKqGcFgJolBZsiU4J0nJwHmxpJ2Vnk6LHDeqEtjA9");
            region.setRegionFlag("pd7CJ1yTJCGOu3FnjdggIi3xWXWH1rggvjXZYRm1WM1ldKppqu");
            region.setRegionLatitude(5);
            region.setRegionLongitude(4);
            region.setRegionName("ZO7lBPSePQMqSRlUzz5FGiDkwcDtfL8a3TKI8BebUK96CXjUWM");
            region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
            district.setCode2("djf0c5LtasH5fbaxQK2xgUOGpdfdk78B");
            district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("26az3PUlxr8PIImJwanT5fBddG7phBl3xW2Gg3tE3szAFB4oeE");
            district.setDistrictFlag("o7ZwaweZh1uQDuqgXqlbYbr9FfbQ6FOvZV1nU1z90a8ZjzBt0U");
            district.setDistrictLatitude(0);
            district.setDistrictLongitude(0);
            district.setName("sDSarioqarfJsnpfY4Fattk9auOQ2QxCApn7rvafb7WJSGWUjg");
            district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            District DistrictTest = districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
            Taluka taluka = new Taluka();
            taluka.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setTalukaCode("7FZ4j2CYGDVlt9n0D4ojDX4dxcuazY2W");
            taluka.setTalukaDescription("lxg45OT4vNcoqF1JLhK2GQVegHYgPM12KS601pBZCjne4vf6nr");
            taluka.setTalukaFlag("mMmOX7S4tmG1dyz7jG1MOoyiE6ZHdqghBAV5Tb9B5TaI8Dno7G");
            taluka.setTalukaLatitude(8);
            taluka.setTalukaLongitude(9);
            taluka.setTalukaName("LX7AKp0cIciGAvCHnJSXMQ2Jfe9Y5dDuXQlWj91lBZOuQBZny7");
            Taluka TalukaTest = talukaRepository.save(taluka);
            map.put("TalukaPrimaryKey", taluka._getPrimarykey());
            Village village = new Village();
            village.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setTalukaaId((java.lang.String) TalukaTest._getPrimarykey());
            village.setVillageCode("I6fxkWZw9P8sxJBiO4qgXF33puKFSws2");
            village.setVillageDescription("V9BnB3G2vqtXPZvmlIa3j0QvFcLZaaDJ0G08N3FZ9BE3CftEin");
            village.setVillageFlag("ReWkoYTz2aPyHvnFfIVG0azWyYzf0WV02PkRcA1ruamA2VlZ5V");
            village.setVillageLatitude("jPyQewV8Kpu");
            village.setVillageLongtitude(4);
            village.setVillageName("UkwNwFWC05eqFyQ1KtLrNJXGT1s85320ej0rBYyDD51hrwJU61");
            village.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            village.setEntityValidator(entityValidator);
            village.isValid();
            villageRepository.save(village);
            map.put("VillagePrimaryKey", village._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private DistrictRepository<District> districtRepository;

    @Autowired
    private RegionRepository<Region> regionRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private TalukaRepository<Taluka> talukaRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            Village village = villageRepository.findById((java.lang.String) map.get("VillagePrimaryKey"));
            village.setVersionId(1);
            village.setVillageCode("8OBObcCOt8hJOk0uU4bXxqbSVikx7Aqy");
            village.setVillageDescription("9Vj3lfvDgbEQj8TUGZmMRfCjNu1oiRJwqT663A0nfgjpVfJENO");
            village.setVillageFlag("ceSWTlWQ82YGyaGp9rdDl1OvMKt5pMREtsCRiKKtoaYBI90eX6");
            village.setVillageLatitude("c4hHxsz9X50");
            village.setVillageLongtitude(9);
            village.setVillageName("iMjR6o8gCsaw5jEFNKMpoERQKEmWJDgtuSKZe4baF1Wb1y9mW7");
            village.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            villageRepository.update(village);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Village> listofcountryId = villageRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBydistrictId() {
        try {
            java.util.List<Village> listofdistrictId = villageRepository.findByDistrictId((java.lang.String) map.get("DistrictPrimaryKey"));
            if (listofdistrictId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByregionId() {
        try {
            java.util.List<Village> listofregionId = villageRepository.findByRegionId((java.lang.String) map.get("RegionPrimaryKey"));
            if (listofregionId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Village> listofstateId = villageRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytalukaaId() {
        try {
            java.util.List<Village> listoftalukaaId = villageRepository.findByTalukaaId((java.lang.String) map.get("TalukaPrimaryKey"));
            if (listoftalukaaId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            villageRepository.findById((java.lang.String) map.get("VillagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            villageRepository.delete((java.lang.String) map.get("VillagePrimaryKey")); /* Deleting refrenced data */
            talukaRepository.delete((java.lang.String) map.get("TalukaPrimaryKey")); /* Deleting refrenced data */
            districtRepository.delete((java.lang.String) map.get("DistrictPrimaryKey")); /* Deleting refrenced data */
            regionRepository.delete((java.lang.String) map.get("RegionPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
