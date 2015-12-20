package sales.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.AddressRepository;
import sales.app.shared.location.Address;
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
import sales.app.shared.location.AddressType;
import sales.app.server.repository.AddressTypeRepository;
import sales.app.shared.location.City;
import sales.app.server.repository.CityRepository;
import sales.app.shared.location.Country;
import sales.app.server.repository.CountryRepository;
import sales.app.shared.location.State;
import sales.app.server.repository.StateRepository;

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
            addresstype.setAddressType("tc9vhJXgOX7NH6FqVCoBzTwXS87zGFO4zmuPahvsg6etcehjVO");
            addresstype.setAddressTypeDesc("NsxprYk6QbMwvQ7r2jgHD57cs1cI2o6ISP7IUBYQbGyP7c0rB5");
            addresstype.setAddressTypeIcon("SrXCSEI1oMUzBvLsinIDoCTXai4qdYu1i804dBqXZod9rBfX51");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("1w62JTTzkNfz3rxLhgwpQCzDCxuCKIyK");
            city.setCityDescription("KlSJco2mftECg5UeV7PqbmZMM6pNQLIIA2sQsqN1sifCphHAYU");
            city.setCityFlag("UudoyBgIPeAqca30b7VJ6mURI45Llku5giCif68UWLu5xtm8f2");
            city.setCityLatitude(4);
            city.setCityLongitude(4);
            city.setCityName("leugeFvVgHDuEv9HASPlFyAY6GKdiLkEAO5okrg4sMKwoqlV6g");
            Country country = new Country();
            country.setCapital("CJb4IYhXVXIu7n2JWluch78IeazHqqxP");
            country.setCapitalLatitude(9);
            country.setCapitalLongitude(8);
            country.setCountryCode1("vn1");
            country.setCountryCode2("EsE");
            country.setCountryFlag("8FKbEXg6Itsk9rqDEBpfRBl9ftsKV9k0xd9IuhCpl4HWRu2iMu");
            country.setCountryName("fTtcxqBxhuNkuXzYtI74Mt5w1dSA37qVibxGgCthvhYTqAUjI8");
            country.setCurrencyCode("qyV");
            country.setCurrencyName("hSsbZOeQbD6Mpt6sq3kEJRe0raQGxNwZAlczGCY8Xgfj77PJpQ");
            country.setCurrencySymbol("W6a3GsNJ1BZXvmySWzsCIKQRwtn7HoAg");
            country.setIsoNumeric(5);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("bceZSjO4TCKLfuQ6hMXL7x4v71FQw1V2fQL98hP3gCESia2dGC");
            state.setStateCapitalLatitude(8);
            state.setStateCapitalLongitude(7);
            state.setStateCode(1);
            state.setStateCodeChar2("TgItnvEeNwleMfGIBuHierUufTjqdXJ9");
            state.setStateCodeChar3("t5fDlT3K16cCBI6UMLcr41qoVB5mnaAs");
            state.setStateDescription("RjACubKFpnQAWYKzeztLx6Rp4yAZBJI7KgCETBAz5gibiPGD8V");
            state.setStateFlag("22wHb82friDJXU2gEGJJVSLSWAQsC0gnmhTekbRrNGTQrRjrPV");
            state.setStateName("xkV7ZbNl97LlfkgdVAiOeiwSU8ZrAd5f6CH2B4LQNALu8zCxB3");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("mCe3SiLml24qErbsPOTYdWUlzVO40WmO");
            city.setCityDescription("ZRdvVAFS10jbBt3FqK0oPLioXK203ba8xTzXbcm4RxRdy3thpy");
            city.setCityFlag("nqoZMGBFQi6OjX3a9qhV1ju90utg7qKqn6ci3ypguoaXPZmJLX");
            city.setCityLatitude(10);
            city.setCityLongitude(11);
            city.setCityName("BZWprNNtYutcg6BBzw5648gVeLuBBTAVa49SILRtFlh0iLR67n");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("tqGYE8Im2JyRboDN9UfZzxL5H9hmODXfROzBWlHCm8pmpMvxPe");
            address.setAddress2("ZKGEekEYNR5WbPNiz1BdpC6WVJ6zCaZ64iOoPm1Y7oazplFuup");
            address.setAddress3("26utbWKScAwHJNOMCJDNvRPpNZrEBC0phNm4PONNQ2AuJ8jtwM");
            address.setAddressLabel("P4JfvDymPTs");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("0FM3BUKRAVRLc97PSN1ENmh8Wh7BHeC1xmXycTPlMK5Jl04DKp");
            address.setLongitude("k2k2flr9nTyoLtZcQk5lJ3n45kloOFHS2BmFSghSZ9bvz5IWbb");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("q7iZ8g");
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
            address.setAddress1("FnmCQpFHyhNAKuAKf02GDQjEn5vcL7lnXTsbPRVMXbEX0CM2HU");
            address.setAddress2("OLJnxHAt0A4PdBbrjFRB8tHYkniJ8GrTgamJw0x7cklr7WLHXb");
            address.setAddress3("y12Sj5LFIVjqxDQhk9miqkqTtGohpOwAp6bNIVsnjjDqJmhhup");
            address.setAddressLabel("VjfuGGLM2R7");
            address.setLatitude("ZrOIf2FGUCw25E1PR7LbQ6JgGcBwZpBH5VCfy3fFRvNIx3XPis");
            address.setLongitude("Uq2AOLzSZmNXAZVRhQySxVJJ6AXwoPS0YFFRTY1cvaQMZkFREH");
            address.setVersionId(1);
            address.setZipcode("95FEHH");
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
