package project.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project.app.server.repository.LoginRepository;
import project.app.shared.authentication.Login;
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
import project.app.shared.contacts.CoreContacts;
import project.app.server.repository.CoreContactsRepository;
import project.app.shared.contacts.Gender;
import project.app.server.repository.GenderRepository;
import project.app.shared.location.Language;
import project.app.server.repository.LanguageRepository;
import project.app.shared.location.Timezone;
import project.app.server.repository.TimezoneRepository;
import project.app.shared.contacts.Title;
import project.app.server.repository.TitleRepository;
import project.app.shared.authentication.User;
import project.app.server.repository.UserRepository;
import project.app.shared.authentication.UserAccessDomain;
import project.app.server.repository.UserAccessDomainRepository;
import project.app.shared.authentication.UserAccessLevel;
import project.app.server.repository.UserAccessLevelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

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
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(125);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("6XXC0VpBNzu0FPGFN89dSERyZrnPsiX2fZFp8C5yfymNy2usvp");
            corecontacts.setFirstName("0hIpVv9upc8gKoLM0J8Td7Qm2lNt61azD2YuTZ5W6ifR6CKSPi");
            Gender gender = new Gender();
            gender.setGender("3UAA2yPmmj6yILMROaTbfGsHHXgsQjQkmHuIeJzpclmm2Sz23U");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("aM");
            language.setAlpha3("Nqb");
            language.setAlpha4("1ov9");
            language.setAlpha4parentid(6);
            language.setLanguage("og44L6kZQ7uLPMz9793okxYw5CTaa1HEVQUOL3y1V6Xik5PJ5S");
            language.setLanguageDescription("SIiJeY53NyhwizvQdAcuidPCiCkQUj3DvV9LOfckB2yH0szked");
            language.setLanguageIcon("CuH6dfd6gAAkVuTos8Phfz8AU2G5y1zJ0awMr1TX9KYXpolRsH");
            language.setLanguageType("XE660WQOIxcdpe3ztGNRxFiL9Kc9xdDa");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("LxrceqkIzvkDkQtCGhtyzejEfpsoZkLS4yFltaRsORHIzeGm4Z");
            timezone.setCountry("vCMY9R4xiDo1C7t3wYv2KVJhu3P1xzbJJUUoVryUxawTvoHi0O");
            timezone.setGmtLabel("OjtaNzAmbXvglwlEMRKpRsV7FCYcuFEp5V9pM5YPvPWuZb3Uw4");
            timezone.setTimeZoneLabel("SBP5FvXwPKKt8CBvc6WL4j8ZIzUG0RRyZ3fXgT3lOSjTtwcRwU");
            timezone.setUtcdifference(2);
            Title title = new Title();
            title.setTitles("cPk1PqOR2D2ciylNJIZjuFxf1hixRkD2vPt6QKxBGwIbzxmv9a");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(100);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("pvUYY3k6eJaCMwb3uP1irSNyYzGqQO8rdRzJWb1zEpf1SZk3UT");
            corecontacts.setFirstName("EnsjMz5Ft4WYFHtDnV6LHeUDR6kZdpQTiO9tyGreYKTgXvoQDE");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("jXBaANc5ptbJs5xUJubvavyUBwkrmTvX0tM3t6b2bxmmXl8Dj5");
            corecontacts.setMiddleName("WuXy63Elk4bwh7q6miOoGoimgdidJ44O26LUEgXDpEuir8nLd9");
            corecontacts.setNativeFirstName("tIrsyBtd7HVO4CRYHSipmbluqnnV1IV0HqvPzHRgyFFLb4dkuU");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("AppOMAV4mhIDp9wUVGF2NiN2aiwMIR6ywNpJfyo7hD3LAbOgXo");
            corecontacts.setNativeMiddleName("TO7nTsVBjH6twnv4iW2M9jXFt4xznMNh4gRdyyV7wwKBnA3kEJ");
            corecontacts.setNativeTitle("YNRhZhVNs1t7iEtEy1JjWB9xeY4VvLzHXiWw06IEChX8r3Wl9B");
            corecontacts.setPhoneNumber("NgRbjNEloB9ICO857VZV");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("mkHEfo6i2VbtxaKGrksj2fbnT2UXhunczqtSsr8aeuWmDCOtcK");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2486);
            user.setUserAccessCode(5);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("Hk33m8yZJmQG1I1D7sQu6sVCXsxZYZN9L8SGGakM3n6tDkBjSP");
            useraccessdomain.setDomainHelp("FyYHjGEiqN47R4o2uHbq1uOtinwqEqs7kaOpM2O7ZxudjOggr0");
            useraccessdomain.setDomainIcon("RXrq4ds3VvhTKAWMHN3Gv31DsAkNBHdOaRaO4mFCqr9LT634cS");
            useraccessdomain.setDomainName("GySV1PLpksTwbmPol2Ooh8PdC8J7RPNpipPrRhc5kFtNJaHD8X");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("eJ2nfNPaEjcu1N6paxQljLR71P8LEWkMXL6gRkrkOEIvFpUfKn");
            useraccesslevel.setLevelHelp("gfdgKkfaAqXkwRDEIMwCOtzO2WOAghd19thLYAMONpNyxGiYUl");
            useraccesslevel.setLevelIcon("OelqmQQgmlIbRNfJ811C0f3inl6EuzaYYb7e7uHwu5wU5YrpHr");
            useraccesslevel.setLevelName("AlnSimXRLXte4ShCs6jpsyPHtfv2LWoa3VKD0Yu5zGcWW1VLk4");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("S8Xl5MnCBHbwCOFqPX8hfWIML9x45kQB23lcZ1szfvtQ9cSyjh");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(6);
            user.setUserAccessCode(10);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(7);
            login.setIsAuthenticated(true);
            login.setLoginId("x9p1VHCCbfWyeKyRdykmvNNw6Dv9PjORD5KRQ0udHfkjHwbvxV");
            login.setServerAuthImage("SNjLAxQJKsObOlHrgn61MiMS6IrxHB6s");
            login.setServerAuthText("gupclyO5PRaWfREr");
            user.setUserId(null);
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(10);
            login.setLoginId("izEHxB52zglQ6wEWFXMU1bUo4z38ZwnAIHVarMc5wwYSLUcPu9");
            login.setServerAuthImage("Hzqq8slOTTk65z09OrWWEL1yH5ioZUM7");
            login.setServerAuthText("jWKZCPbGritUDcQE");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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
