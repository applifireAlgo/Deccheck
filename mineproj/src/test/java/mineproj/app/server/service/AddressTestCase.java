package mineproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import mineproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import mineproj.app.server.repository.AddressRepository;
import mineproj.app.shared.location.Address;
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
import mineproj.app.shared.location.AddressType;
import mineproj.app.server.repository.AddressTypeRepository;
import mineproj.app.shared.location.City;
import mineproj.app.server.repository.CityRepository;
import mineproj.app.shared.location.Country;
import mineproj.app.server.repository.CountryRepository;
import mineproj.app.shared.location.State;
import mineproj.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("lflANrOWAQddGrV0h7HasiVAljJnppemcnizaSSGTmUkxAHJvb");
            addresstype.setAddressTypeDesc("xxmeexfntliPET3Co2u8jb0LFIER1dLsWgA907qbZ5dKGalo04");
            addresstype.setAddressTypeIcon("R7CFpLDkChHmPXOBqLzSQWXg3rqvWe0q3J1wVeTKg3N8vhSNmf");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("78XnZbhdHIhGnJiQ1mz6n3UjqVqwX8Y8");
            city.setCityDescription("7VOzLjCvJLrTKiKlsz48MpmxsRCYnlUQd9lqGt7Eaoo0qT4kCy");
            city.setCityFlag("phiAZ2b6q8fpVBXpDfNrMgAwTVUuG1RpgfsxbgMY9mqbr4dvJO");
            city.setCityLatitude(9);
            city.setCityLongitude(0);
            city.setCityName("rg0lKvAlUucWDDS8LSkkfkaVKAMtwcOwiSL2JAwem46u1g4aGl");
            Country country = new Country();
            country.setCapital("9CvhdyGTrcbwJSB6QTfdcEnPVYD8QDL5");
            country.setCapitalLatitude(3);
            country.setCapitalLongitude(11);
            country.setCountryCode1("o8C");
            country.setCountryCode2("d21");
            country.setCountryFlag("xkrVVJaG78a0sWKOnRFPSwGWQxj3HuUEXkkY9EmE2uMM1thOZJ");
            country.setCountryName("DHBkpE1oPg26trHsf7rkNqx9QwF4LsVmwBlNf9rqF4N0tCHqlL");
            country.setCurrencyCode("OKD");
            country.setCurrencyName("wnxhUOwQsWAEaCDO1O7PvYGD3u8M8ksPiAP0nih8oEZDPoS5K9");
            country.setCurrencySymbol("OefpcfVDb17Xyz03135OdjTm5yrvkIeX");
            country.setIsoNumeric(3);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("mBXWz17CanmOWZMJQRlqq3BGkEn8ej0W5KHkOfReBg0LcoCDd3");
            state.setStateCapitalLatitude(2);
            state.setStateCapitalLongitude(0);
            state.setStateCode(2);
            state.setStateCodeChar2("KOymBhAi35VLdpWMnTFxwxwrGQ5u3mOR");
            state.setStateCodeChar3("zIpftKeWA27T33RCSHeOOfYH7LttXJMk");
            state.setStateDescription("lo42kxU90dkH93XoaDPXPxAI6KLktRDJFll6YFPUu620kQh9Eh");
            state.setStateFlag("Zieek9A3PZhYrEi14Fd5wPiiAlKOXOAHxX9MxxWaLaQj9GDVjj");
            state.setStateName("L0tbNvzD0akdZR90H7wGveswOzqgjGbomlppBDTOmAkFdbRho1");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("IVUdIA2nkiVYiIZmT0UBFt9zCMw39VqZ");
            city.setCityDescription("ZriLTpFF5obI84Ty41H8XPdLfAskGDTlNQLDyJXVusoGgWCnhJ");
            city.setCityFlag("iWL8eTvxzpJFPqwKpxIWhq7q5SANTFKCZ19yECe5D6JZ1XP2vl");
            city.setCityLatitude(2);
            city.setCityLongitude(6);
            city.setCityName("8x6zEwxWigHdMBHkuoAB8uUuASa6A0xQNX3B9gUwpodXoRLeGd");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("ptLXfwRDnbyp50Au3iT0eszXarn2ZZpdghoGq1sNqOS98Dkvri");
            address.setAddress2("0SwVDegsDm4HUarO9WWwDreL18TWLFWIBVetieD8nbmJeVshtd");
            address.setAddress3("SZ8fn0FZCj3MffzSzYEdhISk9clh3ZqB9yjpleHYRJAGBX3LB2");
            address.setAddressLabel("JSQqOCgKNUA");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("pBMlUX64LsRrFQCmNGrClq80TPXfCPadCBElIjJTSNozFT9mBY");
            address.setLongitude("HCFpcJKK2tRkL46Ou41qJDp0GCwXFT5hgzNTwyEo3iYQH22PyX");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("cj3hbG");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("I9U7G7wwz38THXzCfW9QajUvNwmsSChoCqdUUQF8L9AWj5c1VH");
            address.setAddress2("Yib5hkd1Q1OfEURBiytEmOlL8C5RwnOTu1EdaL7AwxHBa0PhLd");
            address.setAddress3("lKLFADNlwMNdDUy5w87Dpj8sqQlR1mVsAWZdLYGLm5ssNp00r4");
            address.setAddressLabel("sbgvM1izIMW");
            address.setLatitude("hx6rNXvINwwkzncHGqwP3s0DQ6eNp7mHHL3wKugeQG3GWQKG37");
            address.setLongitude("3LeowfPsrbNhaegj00kQARkOi6z5Jq6sm5ZSjdIMyWob018NqB");
            address.setVersionId(1);
            address.setZipcode("u5mszw");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
