package project.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project.app.server.repository.AddressRepository;
import project.app.shared.location.Address;
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
import project.app.shared.location.AddressType;
import project.app.server.repository.AddressTypeRepository;
import project.app.shared.location.City;
import project.app.server.repository.CityRepository;
import project.app.shared.location.Country;
import project.app.server.repository.CountryRepository;
import project.app.shared.location.State;
import project.app.server.repository.StateRepository;

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
            addresstype.setAddressType("kNRCtCtLc1lAFOx1vBFK8SPksgls0qZrZaQAJ9x7S5b7gho7mW");
            addresstype.setAddressTypeDesc("vxd11x63OBaCdziq40HkmmVf9JtZdWMN2eDZIpBEzMASYQwCAX");
            addresstype.setAddressTypeIcon("rtjDbsI3B4mtBHT04RvRXaFB5sbRoKnUQNMZ6TAua9XDqw5mpF");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("3je54jhOuqySVBL1YxY39spTLt3MoIHx");
            city.setCityDescription("yinNQEVT36Nw6lQ1iMtRlwby08yG97PshGoInNPERzndUb2j6B");
            city.setCityFlag("EQaGHRA9jARo6xLeEJAcOrgagmvLIgt6VpreAt1jKdInLwCcwF");
            city.setCityLatitude(7);
            city.setCityLongitude(6);
            city.setCityName("nw202YfvUvdf4WCx8vwAGcZZ4Q6crN7eajYVdYp8jVccO9OQnJ");
            Country country = new Country();
            country.setCapital("IU7lVEFzxIfiLWZa9q0FumEG8K2cdgM5");
            country.setCapitalLatitude(2);
            country.setCapitalLongitude(3);
            country.setCountryCode1("AYf");
            country.setCountryCode2("VXM");
            country.setCountryFlag("uddmKtHOBJoZOJF6b5OVnTrVrAY5d4RihsC4Dgz3bFBZDP6RU3");
            country.setCountryName("FDrT3hBxPS0MrVcojiygadpeUeTzUzTWDtLcB7KrEd1UzchePc");
            country.setCurrencyCode("Q9z");
            country.setCurrencyName("xr9SClOshUk3l0OurC83bVQFC9ctb7QeeWOxo7XNXIavSJc1gw");
            country.setCurrencySymbol("M8qJHHkZiJfexoaq0lyVQLEtb5UbrXjk");
            country.setIsoNumeric(11);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("sVi5A7hR9nbsbg7DMythEGuppGcIXEO0x8fQ9JKWz8JLTzq9IA");
            state.setStateCapitalLatitude(7);
            state.setStateCapitalLongitude(6);
            state.setStateCode(0);
            state.setStateCodeChar2("Nub3QEDkiXrKkTP299m5Ec5zGIzdrwkf");
            state.setStateCodeChar3("2owZ8sh4cr15B7K1q1Ol48VMwlbmY1gX");
            state.setStateDescription("OMkld7bIYqZYID7FEfS6087mLcka80XHHdtaALw0WVzr8UkhTz");
            state.setStateFlag("EoJ5pUNX7ATX4gM0GwOpEsAB5wwq6zxgn5f6n9KkeOsurSV0pE");
            state.setStateName("O3k6e5Lqpbneo1QId5EBIukMx9wJlXWzr3e3AmKECMzK9Dpevw");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("ss0zN6G7Uy78Ks83bymNcXrDH8XWgHTl");
            city.setCityDescription("5sMCMvpWqgVOVkJ4r5EuJngtLrDSQOITa5mQTDt8tG1sflfk1F");
            city.setCityFlag("Im6FYRIfNEtR35MnlL7u4e2dJ9SoJhiN2EJlsS2il8l1OJJJuy");
            city.setCityLatitude(10);
            city.setCityLongitude(10);
            city.setCityName("JUymbKv0seRj1lL7TGOJku1ZZ5h7Iy1X96tpB5OYM6jqRJyag8");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("9ZGQUSz6ehu6MEtWc6iqg27hk3tXGHPd4jENwWV1qPMTJTXpa6");
            address.setAddress2("s1QKD2nmflPEVohMsYjVK8sdKdX0D4K0kpmPpNYBVRvJyCfe1G");
            address.setAddress3("JiA3L2YWvpCBAFWT15MRwk9PELSKf6yFqe2XppckmVmzYJcVpB");
            address.setAddressLabel("bQgN0PD1lT8");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("Z4hlldXILY82I5OWS181Jb8xNbSfK5e6hWnqE8k0b4YZC1xuEL");
            address.setLongitude("IVJuJSopY1k4T13eyyAkx9PDu6KmlMQDc8gV85eOj2yipnPkRk");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("1gz1xc");
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
            address.setAddress1("St1o6I7DY9iaJ8XDQ7Sc1wfMTzxYNLTI3h6WRC8OcfQKRvYNBr");
            address.setAddress2("PH2GQxC1ZnW0YIiKpxoAQAFBZ4ScJA97u3lnMVn7oh3OjyFsHz");
            address.setAddress3("4zRTfShJbGPWfKVelxXEAOivNogi1VaRxdkBRQK2iZIHR00L3h");
            address.setAddressLabel("asEBEsrIf6l");
            address.setLatitude("lAIe9OTqOjRojsLDgie2tZ4nvTqeGstfF5CzlwNoH55pPqVN9c");
            address.setLongitude("h9hohcEbk8xYvXLPQdRvnoCWn0awrZoIwU8foBhqVahYQ1qY5f");
            address.setVersionId(1);
            address.setZipcode("q4wT0v");
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
