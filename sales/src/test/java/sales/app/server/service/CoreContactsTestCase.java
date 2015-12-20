package sales.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.CoreContactsRepository;
import sales.app.shared.contacts.CoreContacts;
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
import sales.app.shared.contacts.Gender;
import sales.app.server.repository.GenderRepository;
import sales.app.shared.location.Language;
import sales.app.server.repository.LanguageRepository;
import sales.app.shared.location.Timezone;
import sales.app.server.repository.TimezoneRepository;
import sales.app.shared.contacts.Title;
import sales.app.server.repository.TitleRepository;
import sales.app.shared.location.Address;
import sales.app.server.repository.AddressRepository;
import sales.app.shared.location.AddressType;
import sales.app.server.repository.AddressTypeRepository;
import sales.app.shared.location.City;
import sales.app.server.repository.CityRepository;
import sales.app.shared.location.Country;
import sales.app.server.repository.CountryRepository;
import sales.app.shared.location.State;
import sales.app.server.repository.StateRepository;
import sales.app.shared.contacts.CommunicationData;
import sales.app.shared.contacts.CommunicationGroup;
import sales.app.server.repository.CommunicationGroupRepository;
import sales.app.shared.contacts.CommunicationType;
import sales.app.server.repository.CommunicationTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            Gender gender = new Gender();
            gender.setGender("1cF4rL6rcJYpoIO1jjojMdupRnYch7YemgUFjCDNPZdGRbGJ4E");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("YF");
            language.setAlpha3("0OP");
            language.setAlpha4("jtGT");
            language.setAlpha4parentid(1);
            language.setLanguage("DT72KfQ10z8tzkJmCeaznnuY7oU81WT5Lq7yaR0GccmbSieO2T");
            language.setLanguageDescription("Aciu4SKY2aNmsjfakoFWza9Ei5IjvuLxRfZPWYKSZsuYErF8sj");
            language.setLanguageIcon("IAy0xWCLjdn8bVfGnkJTVJpj5Mjt7WV2UTzQ4WmlAFwA3I0CAb");
            language.setLanguageType("25FCKzFxZj5FwQu7r6QBjFBBMZeCxmTW");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("M46qpvYQiQag4Tayer7e8he4Lb5AEEfBav6fpaTzQog9FfDJQr");
            timezone.setCountry("o9h6gzZVydSA9H6W9ISfixs2x9eYflV5ZOKaLzLatuoh0YKv5S");
            timezone.setGmtLabel("r1GgIGkMtX1AuGIX6e4vX1rsOmGgbu6DAyzoSLEfOS5ifjPREE");
            timezone.setTimeZoneLabel("bk9pF1NxKEBn94EuHk3JJX2FVoA1GsN4rUx9jt8Gbq5h7Yvp9e");
            timezone.setUtcdifference(9);
            Title title = new Title();
            title.setTitles("MQpFPc0DMqOXrp2nJhSb2fnwidWqG53O7KyMVt0i1ZSpF7gzRK");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(19);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("MkjHgqUE2zjWk6lFya1mY2sd4RqlAk2QzL2mJEzFjwVg0wJqqz");
            corecontacts.setFirstName("qNGOQlJGFlQf6NZr8fd6x7bF4Ip2DC9NuqXVAx9OASCXwEy9k3");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("1vguOgTtzTZYmmR6OpW63i4BFAbGasqOasXdveGoqQ8rC7vr4M");
            corecontacts.setMiddleName("BoZPvhulVI8F6CxIht5sxIK6HdqEnzFbnHnIxoLM31Wv0uGuU0");
            corecontacts.setNativeFirstName("ZRK7KyDHBA39KVa5muG4thASV4mBoZmTzI736B4XDdBXUCkGaC");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("HeUF77REAZBLbLPATU9gLwvheVJ0dh0jyn7dRQ6bfm3udsnfcV");
            corecontacts.setNativeMiddleName("he9OqxDuBAmTK4bmQGTCLeXstKp8oUarjCMH0x1EwuvRzGdD8w");
            corecontacts.setNativeTitle("BR76GwFEl952Xk1awykyQUosJwMdho1A9snL0gV0u2iibpItgQ");
            corecontacts.setPhoneNumber("ooxkzyeYWZpu4HKHjze8");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("BylUs9w1vcWpK08joythmD0pYKp3ciFJMifoTJZFzP6hjLoyjY");
            address.setAddress2("5Qi4Xx2k0Yxrx5V6HP1ClFKQzHExWVIJis0tOaS96lvPDjL1Ev");
            address.setAddress3("YkwwkpQlrM6515qthrNjGvsVyImh3G4ioAwjSL4K4PdhD4wPFD");
            address.setAddressLabel("IKimOAROBYj");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("vILQanjISlFGUefMPJFZeRaZ3PlqnwnAVTFznk6OyiYIcJalol");
            addresstype.setAddressTypeDesc("U9hnbaxOgj6lr5rGhOUVQJmXvc31cIe80ICcbtWYhDIVkkPfQG");
            addresstype.setAddressTypeIcon("BNDnpawNj20UawBSZ0MyqA423U24kbZnjDFW6ssVwrBZhXxnNS");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("PwSXLnVrI7dBmL0er23vK4O3bHAJnNiQ");
            city.setCityDescription("bKmdsPU2bSR1XZ3LmoYg83hm8XNoUFOcu4fpMoYwXsLCNHQFu4");
            city.setCityFlag("sCKI9KaSZ5uJNJqb3hbaTMmJGLNv3KeiMtef4DV6yKQV3e2YZH");
            city.setCityLatitude(5);
            city.setCityLongitude(3);
            city.setCityName("ahfM12PSXwmJh5uztWHIZiD9MEcjJ0HUQ7lpfVXTX2rTrsIjuk");
            Country country = new Country();
            country.setCapital("OAc1JsdfUazRok2bkV6Vqy2SSxAzSVUc");
            country.setCapitalLatitude(1);
            country.setCapitalLongitude(6);
            country.setCountryCode1("F7p");
            country.setCountryCode2("7Em");
            country.setCountryFlag("BMaOpYeLxnb5SfkOtvoU1vhNjdKIx1vIKQjvYgAdAXiXHBKH4m");
            country.setCountryName("yhQielDCpO44zoN1Jwnurkgm9TrMki6HaTpr4xtr9i5IcXsKaD");
            country.setCurrencyCode("INO");
            country.setCurrencyName("Ucxtl5SX5Oibw82540UANTBKgxkw0BAJMqVOq1gmw90MydKZea");
            country.setCurrencySymbol("aOZcwhvNvHDMVxlB6lA7hLIbzhQWEJdt");
            country.setIsoNumeric(7);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("4Y88TKThKZZR5PyFjMZpSuJxN4s51Wc4ykijtsJk5xE34zaN2V");
            state.setStateCapitalLatitude(2);
            state.setStateCapitalLongitude(5);
            state.setStateCode(2);
            state.setStateCodeChar2("LlQ7xzYUyQkySAFKx1ASLZLdYVo9nJWj");
            state.setStateCodeChar3("PHXGq1wkz0hhH7BLwqduUQQTEth4e6EF");
            state.setStateDescription("Dh0NUWMGDSbDY5fSNcHgjJrCYGJJqeItdvFfbKw8iY9y2tbegC");
            state.setStateFlag("QCAxdV6jp63VZJqdYSdRm6n9I8GkoQGfL4qXMqdWxNeCUUoypZ");
            state.setStateName("cIOLabrmD15SxpV2ySEhFSolY69kxW8n2ewabfvkhMwEYLLDQq");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("6MbZIQ6CIjJcckOdNpux1sIB617iXvLN");
            city.setCityDescription("m5eSq5LvrrLWA2bQwOT9M7sHh0n0c54HB3md8xhKrOeYYfCyix");
            city.setCityFlag("gbhxF97CzUOrQXuHPPFmpn1TOlZ7zky7MpkOWa4Otu9D7JnztX");
            city.setCityLatitude(10);
            city.setCityLongitude(9);
            city.setCityName("mShkWvS2AGS9wMuLWsnfBPjZ8vpxhfMbq7JUSqKyiRE4hnMZr7");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("3TSHL7Mdd9u4ysRDb2KzIWE74rzWJWdYEgwWLJxvpDNX7xwZEj");
            address.setAddress2("aYy3SlrJ03RKvNJuMS8I1NaDRNBJ03r6Q0L2875nzNvhrwT8ir");
            address.setAddress3("CDwFfbm0UAeQUYgxzneAyEwxVQIT6y2nhfJG63mUwJ6vpmALWM");
            address.setAddressLabel("LiKdONmNSDU");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("E7kzV5zQ8xWEEI042lWRYBMuLsVquVtiJERVVxKBq83W5zlzX0");
            address.setLongitude("iWL8nhBusaz9aGHGyu3yAsoUWm8T78nKpsDFRImBCu4Qxlzalu");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("vhPSsd");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("Spk");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("qXhdwbBf21jc2YLDPzHFaQMvvJ1JHe90Kxv3EJo7bIdmAcpzYV");
            communicationgroup.setCommGroupName("2fPvwvRJzEOWsbxyVeIPYTvdYlHzhEkmS4XdBd9vMGyLxNw8nG");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("uf2U0p4TEPAxMPI8jzKy1dNGKtRr9R2VHYNX7EWlFgjH30GBhD");
            communicationtype.setCommTypeName("gL4ympt42JiBOJ4r59aKhNtJrvdigjgAmqbFdRKXqanUTGPwaB");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("ULw");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            map.put("TimezonePrimaryKey", corecontacts.getTimezone()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(59);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("uI5nbILG6ruwFjQqCyVO63tqm2Oh3VpuKoqhCClPfnR2jG38HB");
            corecontacts.setFirstName("qmLzOcHVV8QfcHvoAGb8hna5lRLbuJDfBJKZXjz7Ges1hZZRhC");
            corecontacts.setLastName("jKI1HqC0DvXp6w4WI9ESCD5hyes3u4IYgNN08ABpQN9IIFHYaA");
            corecontacts.setMiddleName("IYshPajChz8VLCt1naTBeLNdNNBCWHLRdUsVGdvJGUTwECdtT0");
            corecontacts.setNativeFirstName("ainvR0dzzJD6liptX4epbMXExekibMnQNrBR3T81wXBBJzmUBZ");
            corecontacts.setNativeLastName("ANS2saO3j5guO3b6s2oYNc4TA9usVyFcATJJ3SuSA1y9c7OIAF");
            corecontacts.setNativeMiddleName("GlQWkTLUDRV8NDdGh6IBmXdByO4fQK8Ig7OLkhYzPkpVsQHhZ6");
            corecontacts.setNativeTitle("3Ue6wCfCBCaO2TL90woqfKKSjyQMamdYkoyotKMBXDzEQmrxHG");
            corecontacts.setPhoneNumber("7mbbNwIWummxUR6s3GEH");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
