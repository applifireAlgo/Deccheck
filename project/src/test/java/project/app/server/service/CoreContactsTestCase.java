package project.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project.app.server.repository.CoreContactsRepository;
import project.app.shared.contacts.CoreContacts;
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
import project.app.shared.contacts.Gender;
import project.app.server.repository.GenderRepository;
import project.app.shared.location.Language;
import project.app.server.repository.LanguageRepository;
import project.app.shared.location.Timezone;
import project.app.server.repository.TimezoneRepository;
import project.app.shared.contacts.Title;
import project.app.server.repository.TitleRepository;
import project.app.shared.location.Address;
import project.app.server.repository.AddressRepository;
import project.app.shared.location.AddressType;
import project.app.server.repository.AddressTypeRepository;
import project.app.shared.location.City;
import project.app.server.repository.CityRepository;
import project.app.shared.location.Country;
import project.app.server.repository.CountryRepository;
import project.app.shared.location.State;
import project.app.server.repository.StateRepository;
import project.app.shared.contacts.CommunicationData;
import project.app.shared.contacts.CommunicationGroup;
import project.app.server.repository.CommunicationGroupRepository;
import project.app.shared.contacts.CommunicationType;
import project.app.server.repository.CommunicationTypeRepository;

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
            gender.setGender("1DwL7qCS1wsY3HPYoRbi6ti8Ar2XJBXWbB5RgXCWRQqRNaRBHl");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("TY");
            language.setAlpha3("baU");
            language.setAlpha4("dudB");
            language.setAlpha4parentid(1);
            language.setLanguage("7szpaDzmiWrVZQ0ecZ51vYLL1x6eX9ASjlbp4YtjSwcMd465qH");
            language.setLanguageDescription("8dAr2Uuh5Qd1Zj5fB6MmBsZEg65x8IYPFeHvaOoY7hqDgj1FMS");
            language.setLanguageIcon("1W9xviJf8frah9VMfCrTvhISmPuQUuWa1xcyQB4w78yPXdLf7O");
            language.setLanguageType("n9788FxqmYqn4KR7mEIQwI9oPj1Cvee7");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("UfOyJWwMrYMPSYEo4JVKVozz8ypXuGalA3OkHHinJCYKjNaRvG");
            timezone.setCountry("UDm7f3WHHRDIR6Q7Aztugrh8hX48h4liCAZfJoR8hv1zJzOXn2");
            timezone.setGmtLabel("wfpuW7bXOShlKnXU0QfB4ZoEAXniTg7wUwkX2s6ZQRhyD0pc3U");
            timezone.setTimeZoneLabel("ph3zAffcDlvYfuiZxfgoCKzZcPrbzjp6ytPyW1WED3BTwqOlIw");
            timezone.setUtcdifference(6);
            Title title = new Title();
            title.setTitles("YMfAC1mFAKmmJJ5T9qRdKIRQvGiWhYf0eXolexXVFgbVzRWTXY");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(31);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("cudLQtKcU8aok36gJkrrspZ1Kpu8lMzHaHSFo1DCsIR1Sq6sgi");
            corecontacts.setFirstName("ezXEicv9rCkEeRWYknV3AngspQohxvlyEczmPq7ACQQaD7isx2");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("1euvV0Y6nGYQk1Nn6cjVC0ccrkZ8gpqhhMXJYjqNMn2JJlZnM8");
            corecontacts.setMiddleName("tjUcuko5Ee7NPU3pXXm6s54C3PmpWDM334CaL7u3zmc6tyeQun");
            corecontacts.setNativeFirstName("xDG9AUmhA4WNNsAL0jaRh7wbAQm0eMSmV2j1fjIeM6hJZMmtYm");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("TnUWYxAJGBgX02QB1RP6hIFNkyuu0vIg2ecW09NUKhkPKxHlUZ");
            corecontacts.setNativeMiddleName("DCeAz4Oz0eAs2HeuDnbQCepbUe0Yx8FVsEMYAljuHTZQs4HpzO");
            corecontacts.setNativeTitle("AICk6m6qec1aDBsP6QcNr3BXmal5iXFydOw0veqisheRyy1WLx");
            corecontacts.setPhoneNumber("qBRHmHafpgMQ1A1vUQYf");
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("dFD6L5oJb1xbzbwiUeS4Y94QWxXMVd7FZi4WpO47o45ZHJQlbA");
            address.setAddress2("L36MRg9weEwWtT3inUUjseq2M5BD4bbyYO5FUQJtlQgsxmqwlg");
            address.setAddress3("WQJMbMzzDFSjb7rzx9gMdnBeK3hmFZbkpvBuUcrA2GaTKzFLSo");
            address.setAddressLabel("NBFKwHU2lAo");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("LsnrAKMhKEDjtHpXlxcaIgAxoppRKtPc8Wq45okuJ0bk34FGFw");
            addresstype.setAddressTypeDesc("KTHC67EGbjv7AogEHYmHwF1PLswwwrgbzTKfBAZqjRhqNjd0my");
            addresstype.setAddressTypeIcon("Y8Cq68cOmMnE34IjRohyihBxxt7FQCdOzse0dFxC8WMnx9RtP0");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("7ZocNih0NtvByGQ3U2xHNOsdIAvbM9cG");
            city.setCityDescription("OMuALsoOBTfR8qT8ohdv1UnfsFWWOEphkxnzyt0Khpno1mut6t");
            city.setCityFlag("vGooDB2LSOKK3MpuqF70XoIteShfqaS8MTJ9QfTwdzuxIUEwqF");
            city.setCityLatitude(0);
            city.setCityLongitude(7);
            city.setCityName("grHLnCEhrs5gE8qmzb43HM6dISTHO4BhkGYYblzpohmUjEwSXs");
            Country country = new Country();
            country.setCapital("68zBEKzWgKnLckrREoiXTGZ0mbkFcQVX");
            country.setCapitalLatitude(2);
            country.setCapitalLongitude(4);
            country.setCountryCode1("wBM");
            country.setCountryCode2("lYu");
            country.setCountryFlag("ZcFgEFVIvqFqqsdRn1tOs3oOT4uYV1m4l2JEf5Wcbo4RzWEmV1");
            country.setCountryName("kMI68SvrEos8E9uGRfZ2EWYB6OVTro6KADfa8YlWJ3T3MSo7N7");
            country.setCurrencyCode("NVi");
            country.setCurrencyName("xPdJCfSfUfp7aqbeiIM9pRL9wIVy2NSiAFjxGvqJifsZFDmBqM");
            country.setCurrencySymbol("rLQYsmWU8EoU2e0e13PTq1TpD4rqOsnb");
            country.setIsoNumeric(4);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("MBDHvRa9MVPz0LJq3k2EFdu1Qimr3tuq1Xy3LM9dl6KizQ50zW");
            state.setStateCapitalLatitude(4);
            state.setStateCapitalLongitude(11);
            state.setStateCode(1);
            state.setStateCodeChar2("DmLMtBGP46BPdjO6jOvtaf2rlzqrL3hB");
            state.setStateCodeChar3("iAfdPaluPbWBve8pJzuiHudHHLMpSmYj");
            state.setStateDescription("qmkeYcuD3WvVGWB0UNqTVdSTS10ivluFJIdFRA4ElvptrMD1iI");
            state.setStateFlag("IF5pRnwxas5BzEyWV7XqTEss6ATFghe21RvHU7oXNt0efGBK9J");
            state.setStateName("sJ1bEaw7wKq8EDETkar33bIpLxW5aaHiyT119iJezHXHSjwDZn");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("FceY0ATn5y5IaaVagC01kcw2DCDkVdRd");
            city.setCityDescription("h2wvSZL0CS79XlVb5uOWspv56flSi3uMny1LGAmPCBZmHjJ7v7");
            city.setCityFlag("hVcSUSn6cpCIpEHixzjRR4bcKm6LtfP2VGf3joC6WKm61R6Kvm");
            city.setCityLatitude(2);
            city.setCityLongitude(1);
            city.setCityName("ORZtv58ud789zleGlZAQPYFkLkolwtO9YnYacy8GGc7nkBXKiY");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("90uM9qMqZfu62EEzFwIFgiOBInDK9fj3dvhRh4JJIAl9lY7k2z");
            address.setAddress2("OP1FTiNQOz4fXFshL6jfVX73jamCvxG2vegwUhdeF4a005ZhKp");
            address.setAddress3("SlNzhp9EPbPTemTY1kwnobrqbj6ZImN07wsutNtFGogPSlIWmN");
            address.setAddressLabel("VSK2aovSmwx");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("0ceuxULmqwBu4yZBdEjsQaFU54h1duIv8sMsF00G0Lqo3zXaDQ");
            address.setLongitude("av2ol4f3dO0vyMp6MoqL5iewINcgMf1VFzxIiNxlG0vta1hptQ");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("Y1VvCJ");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("M");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("1CV07hy1jAaNFakWWw4M1S2tdxamOOaxHX2TVjCpvlRZpHqfZ6");
            communicationgroup.setCommGroupName("r6Bg4pLZTcwhYtEWfqeIH87sqhl56Vwo8vTkqW1ShWLu8EVUbr");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("0P7mIru48QOH8h9qTAbOJzYdlPWG9j7zpPwzp3gpS6fJHJFWjO");
            communicationtype.setCommTypeName("q3oSzS0iReQBpNYhox0hvJZLXP6TFID1oXrNDnmpt7XrW2sRaE");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("L");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
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
            corecontacts.setAge(117);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("AXDyvASBwxR6x0n4l9W9h87Z6y1pRAReGxP8CbZ1NRm4SFDCLt");
            corecontacts.setFirstName("FUna5xfQPdimrzBWE0BB4qaTnDI8R7RjhPvFVKLnCezj83I9e7");
            corecontacts.setLastName("6NVezZdYZhLfSC94RBoYnc2fi4WgymxcVUJoKj3UTboQF3Hshh");
            corecontacts.setMiddleName("0dr0DR5hh3CfmA4zUxejPaYfiUDKyV32dKcx03hJu0Ez3N9lOt");
            corecontacts.setNativeFirstName("QvDSRR3Etb1cZ4FITmPboWZWJJSHZac96zQIA5JqfhCPGr85N2");
            corecontacts.setNativeLastName("paEgRLEH5Jke89fujPdGIv0Z4N27lzf7OeD98iP4ik88YJO6jC");
            corecontacts.setNativeMiddleName("yixnUP8t9B5C2fxEx3YFZBzPJzTrkmJc7PpnxIwcPUoZK7zLbL");
            corecontacts.setNativeTitle("EziyMOvhxOUHXbzbIH7jL5i8ioS2kOTUqLsazySCI23n40Acar");
            corecontacts.setPhoneNumber("8ui7dpRKrNhAdbmdUNK1");
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
