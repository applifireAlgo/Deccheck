package mineproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import mineproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import mineproj.app.server.repository.CoreContactsRepository;
import mineproj.app.shared.contacts.CoreContacts;
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
import mineproj.app.shared.contacts.Gender;
import mineproj.app.server.repository.GenderRepository;
import mineproj.app.shared.location.Language;
import mineproj.app.server.repository.LanguageRepository;
import mineproj.app.shared.location.Timezone;
import mineproj.app.server.repository.TimezoneRepository;
import mineproj.app.shared.contacts.Title;
import mineproj.app.server.repository.TitleRepository;
import mineproj.app.shared.contacts.CommunicationData;
import mineproj.app.shared.contacts.CommunicationGroup;
import mineproj.app.server.repository.CommunicationGroupRepository;
import mineproj.app.shared.contacts.CommunicationType;
import mineproj.app.server.repository.CommunicationTypeRepository;
import mineproj.app.shared.location.Address;
import mineproj.app.server.repository.AddressRepository;
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
            gender.setGender("a8CgGMu4adsf864aZ95akT9Jv4iu9vUHAwGi7OZhAPHRYq8Tj9");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("CT");
            language.setAlpha3("smY");
            language.setAlpha4("IP8R");
            language.setAlpha4parentid(7);
            language.setLanguage("16oI25dqPtkpfkb3M4LEAsPlI2pbik15MpgqPk4yhwZdkBGTF6");
            language.setLanguageDescription("BdOy1UzDvvmYeDHNBC7jxR6XRDowgpmBCKWH5TRfz2rMx8Xqxa");
            language.setLanguageIcon("qjheBjuBM0hDbZRvSXyXD3Nekcdk3SdV4zgdR8OBEteNXVkyAR");
            language.setLanguageType("jxF3uFhHmbLKIxoiHxEupPZmORXr3IEI");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("P3DJyiVQX9idLMydbfjnyMN57ynDTwXdgkwl4TwbG59f5CsIQn");
            timezone.setCountry("cb6JizuV1newPCNIlmGTpdUjZyITuTFCFr8fDPrvtydJC5VcQb");
            timezone.setGmtLabel("EBvCIcM0SzeEPoLlJjZuhGamQhSun2rosKwxzikS3UO2ocadr4");
            timezone.setTimeZoneLabel("Tw6vTrkS1Act41I2z8y3NU3MrLW0AaQS4EfSanNKywrkX7gWXg");
            timezone.setUtcdifference(4);
            Title title = new Title();
            title.setTitles("S6hbNQdGBkGqUYUmaaBIvmYNB428eDO0mQHDF9XK4PP7rmLPnT");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(8);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("bx1z7sTHR5BwmGWKksRoF2SBIPlidWENScgTY5onfZHVvYErs4");
            corecontacts.setFirstName("WJBetk3zsYEErtg7vewgVKmO01rF9JnwM12vT47SA3ZKbLJviB");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("b6ftWZYrUPub7EtZYLGECVRFcA7FP2aJF4eicUCVzGpxdJ2lFB");
            corecontacts.setMiddleName("NYtMy7GJhyv0bmnZ1pSi1ror8Z4WOMi6ISpQ0yLjOaHUHjfsfR");
            corecontacts.setNativeFirstName("buIeptKBcLxVZWYsgY6DtN0cTWxpiRY8XPKfi0HW6xMQlqNsS9");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("kzJtmob6N2Ok007IcrPv34bFDTm5ToKiK0mNHBOBtqoeP8DFKv");
            corecontacts.setNativeMiddleName("q1CbJ0cRdNPoW6tTBw01GjqE0ZeAblIyknMW59S7PfLQjzHg7G");
            corecontacts.setNativeTitle("K2VRZxY2z0dlszh1UF8bUzV4diDY9w1ZX8zWq5zzweE3zhcTWU");
            corecontacts.setPhoneNumber("gwHNkCu2twoc5xJZ11Xm");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("Pjm");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("D8Sqkxp9urRAW7e8fendEmqSpIqIwN2rK6fwGTsAKG5kiuISar");
            communicationgroup.setCommGroupName("6RM74cssscI8me4zZoAnxP3lkt1xW5wpS51cBu4wItkO5KJPJA");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("aLGmMIsc6CksAKClwzLAY1nbbuAyA6M37SjoOsRoxXm1FAXyiw");
            communicationtype.setCommTypeName("fLlDLdCsp9ZYsbrt05JLS9U615c6j47b6ImhS1H74LRE7YDoQ5");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("2Kz");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("mCAZ166R0oe1Ye8fmntD0iyvcw1ERTQKgW1WdxadKNdfdTY0T7");
            address.setAddress2("cldRCOYjdJ2grR65HAXeBmVIfBc3v0Z3UelZG4au2AgqlBwjH6");
            address.setAddress3("7O7F0D2GyD99VJHwFMvewuwk7asDLhmyxis8r8EBrBmNxw3Jdl");
            address.setAddressLabel("QtSwnNjSmDr");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("ibejxoYjn9RSa68kFNs8Ri22tTom9KX6SYw6hoT43RxaiZfpnz");
            addresstype.setAddressTypeDesc("cauWnYsiLsMP0VkpAvdsHztiwlg2DQuRNsh25cgsytTGGF8Nr3");
            addresstype.setAddressTypeIcon("2HOshe9QdcO9gFrcqjiQy9sMVpwQ6NVBrxxFL3KXLUTEa3Ixse");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("52Rvzs2bgrBouojxzmlyhXo5pgVkymY4");
            city.setCityDescription("YZcNw3BxNocv2BsAF0DGdNVBITlkEEerOLCyV2BfHhr7FyeqCZ");
            city.setCityFlag("dc0SdGg5kLGspxSO5ULXWyqku1laCaq3J8xQBGc694JCVLdiaZ");
            city.setCityLatitude(6);
            city.setCityLongitude(5);
            city.setCityName("gwBDPh24mWH3PWHuP69UqWa1l3r8pTxBbhjplPaucTh1KcVGYy");
            Country country = new Country();
            country.setCapital("NrwW6YfqJPUwa7obQnYLTn8zmNPGtKqp");
            country.setCapitalLatitude(8);
            country.setCapitalLongitude(3);
            country.setCountryCode1("nG6");
            country.setCountryCode2("aBG");
            country.setCountryFlag("TDV8JA2DVDNVvvaLa5L7vnRomTDu1X1bumHvX9FoA26CzEi6Gk");
            country.setCountryName("VTSV6wY9Y2ZbJbL3wxAC65G8gD1FQIKz4OXwPtoSDhc3Cm5PA4");
            country.setCurrencyCode("hWY");
            country.setCurrencyName("k7REkNViKL8zlH3cPCUKKi0fsocKrF0yEzyYqxEPebYIpyPMPc");
            country.setCurrencySymbol("rymWPDOuqMHAKlHpl3kQrDdvcesEFTSB");
            country.setIsoNumeric(7);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("nEPwxKimqDd9sksjJqjjraANqprmx6LCYkgBEig1ob0dh68IAh");
            state.setStateCapitalLatitude(4);
            state.setStateCapitalLongitude(0);
            state.setStateCode(1);
            state.setStateCodeChar2("eP2tNz20TtjOTVD4uStuw9QTucZrl6oS");
            state.setStateCodeChar3("xKxusmjeDV84IiYeShvHwgLpy8UuU37V");
            state.setStateDescription("HwtNKla3a9aoxDWu3bucRQ7DBe2ZmsD0ZwsZF4I3mGvYWjPGbD");
            state.setStateFlag("YtZIWRKPHtzE7ukvPXO9446KlKbnzkBJ8lgPA9IlpERFSOvpB2");
            state.setStateName("H5l6zhsGetPlIh2GmPeXJFkf5fIACmJ5A42Nmwc9R4UWX2YDJO");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("FMGUVAWDaFojgPIgwiLaIff0oFZLuQU4");
            city.setCityDescription("80ZKvoZq6Bba6BnySDaNUsFRGsZGUOlJlP9cJ1MJRMfd9RqVYV");
            city.setCityFlag("drk3A33BWfnU34RKxgJxkVQRhq02zM2ONzXTcZ7I7qmtcdEydM");
            city.setCityLatitude(2);
            city.setCityLongitude(4);
            city.setCityName("LNl2YVCT1K6cPZlsUGN2nDmX8zwPWHSdQ7XVPye1Y9p4ESSUPS");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("7WxlYy2rS32coV0hOPgPC7lxIYtriuWf7zjH9ZwQPORLr7vQze");
            address.setAddress2("dkTmhM71osFb5SJQgcbczvBCME4srUT2IvSGYOPmYy1qA3v1B5");
            address.setAddress3("OzTCmb0NTL3sqtiM4qJ68h0tER8zLWWYXPnoEnE49XxGZgjGJs");
            address.setAddressLabel("x4OE54v82sy");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("016gEu45r76ivEfnNz6270RqThXlWgxranrA1akLPmAzmT7Iis");
            address.setLongitude("73jCE7jNBa7OmLHVMzJRwUwPpNl5tHk66Y2iqOzc1rw21BF5rO");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("eiICBf");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
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
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

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

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(27);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("uhEmjLlCyk8x9To7IdqRcawAuKMUtfGsXdkudcOxW5pbFp3Wpd");
            corecontacts.setFirstName("5wDHbuA1d8Pyk03iaA3pVb1rbxjq1yi1QSjMwc3ZZxvzPEh9ww");
            corecontacts.setLastName("JRSdozfb9ehtigWUwPbWURcYcVJ6kmtVaqElW0CK5h4Zfj0Hy9");
            corecontacts.setMiddleName("dHIcxiCJWPL4coCWpHhEsIpJxePKAk7Hcpl5Xzt5Ibf2ny9htK");
            corecontacts.setNativeFirstName("YtEiFP9Inj8Lto0x6saWOZsusQXbFWKywmGfSaSbCrkzcV18dH");
            corecontacts.setNativeLastName("JtRHZwTeXPGy4sJgLKsPaZGX2kw5m0Cfq39chDD3W5rFGsIF0S");
            corecontacts.setNativeMiddleName("Uki4vvvjmGzJFX2NxhmwduEOWl5AmqmG9imkXQ8eocuT0GCXeG");
            corecontacts.setNativeTitle("Ml2jOB7sJQqihZwNhjxH7SgGgIOs7onRJnAKLzc1OWP76E7t7A");
            corecontacts.setPhoneNumber("sOtvqfDi7fACueioKMrU");
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
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
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
