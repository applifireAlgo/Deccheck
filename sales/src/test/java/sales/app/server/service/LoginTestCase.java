package sales.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.LoginRepository;
import sales.app.shared.authentication.Login;
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
import sales.app.shared.contacts.CoreContacts;
import sales.app.server.repository.CoreContactsRepository;
import sales.app.shared.contacts.Gender;
import sales.app.server.repository.GenderRepository;
import sales.app.shared.location.Language;
import sales.app.server.repository.LanguageRepository;
import sales.app.shared.location.Timezone;
import sales.app.server.repository.TimezoneRepository;
import sales.app.shared.contacts.Title;
import sales.app.server.repository.TitleRepository;
import sales.app.shared.authentication.User;
import sales.app.server.repository.UserRepository;
import sales.app.shared.authentication.UserAccessDomain;
import sales.app.server.repository.UserAccessDomainRepository;
import sales.app.shared.authentication.UserAccessLevel;
import sales.app.server.repository.UserAccessLevelRepository;

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
            corecontacts.setAge(77);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("1dqE1jDkjwblY08keUgkj8X44GerYxp8HkyO7y6emPEnPbv0yr");
            corecontacts.setFirstName("LLIqcOQy5kzBN1MqcD2IYJWO81xC6qHl1pa90wdlFXwk2DGWD6");
            Gender gender = new Gender();
            gender.setGender("KWu4fz7jX0BYTPFBqsSxCcF6sWCrXgACNiKWuWTIJ2X1B4viuI");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("Tf");
            language.setAlpha3("tpe");
            language.setAlpha4("68be");
            language.setAlpha4parentid(9);
            language.setLanguage("f2RxvlEGtP3OLGGjVb879THBDiynVXsF8Sce8w0DPl2EYyAVDL");
            language.setLanguageDescription("lwzB5xlyj6FEBz4gD3UYbeSFJ0Ie8iYFSTZp3HKRBCqqZdRs13");
            language.setLanguageIcon("zVkLqp5PFBzZvjj2epjgFXKANlWrYOy3edfrL66T5nRIDqxY89");
            language.setLanguageType("4Vu5YnM5I0qeX6H5KheqNXe93Gm5crRU");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("PoFYzskPpnhVsJV284rEw24uo8g7e4amfNyLjj8iuFaKrN4Obs");
            timezone.setCountry("t0LJ2hhgv1KeDiN6ZowxCVqmFz3cfRWKSJ2xUTwl52RBQepXE9");
            timezone.setGmtLabel("gZXgr2MFg2GTEunC5LKk5ApvRK8O0h6eKZmWY12LgCjSVc8E5S");
            timezone.setTimeZoneLabel("SPb3HHNPtA1NCoeOs9KJ99sHXUQeAx05DQdMZ7JCveA5mJqO5K");
            timezone.setUtcdifference(2);
            Title title = new Title();
            title.setTitles("xjCWk5Yk8oYzabzwEMfKdUKi5HjH61753pMoY6R18J97808ZPi");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(107);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("r7v3z9l4KXQHXv9RMtRWmqcr76PUpOfAkNRgsQRhXUrnWdwisi");
            corecontacts.setFirstName("oya35IjGAL5ntXJGrwdJtkZljQKRonrYqsNnFFdy65yUg9X66m");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("uiYwvohAz6q6zkqL6jJGQdK4oqVH4OV5e9cUb5XbcLhdPZjyN4");
            corecontacts.setMiddleName("vdsuks2mqWxhVqDAYg3F6AgZbGHHaivHbL7TisCH0SehNViGyy");
            corecontacts.setNativeFirstName("6PjDTQzcmQVwpOkJWFGFXJ24dAGU38D5idoFAH9paOInpAhL4Z");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("3YiZcgupSw0O5TSRzPEhLblJtZF5t2ZRA5OgFXmTk6ragpxqJL");
            corecontacts.setNativeMiddleName("DxMfIhlStalEe2ZsNvMBu3Y2BBtq5P8hi4JQVQwcrggcjPC3uw");
            corecontacts.setNativeTitle("gcgHfgX0zdq1YZUex3tUrzmtMxUlPy0aJ3RFJwwNBWRneTYA7H");
            corecontacts.setPhoneNumber("Q69fayb6tcVl9iKnFRqi");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("clFWrWPzgLTrdKJXNwUrhwW4SkdaSLctZ8GECG0sF7jbAQrTS5");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(809);
            user.setUserAccessCode(6);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("ahc8WphCueLcS5zEvxzYDIY1BwGxUywj3jbsJA6prTqfSItWu0");
            useraccessdomain.setDomainHelp("2AJAYpn6CwArNEYonjahAXu2yHrhOC1xjWmdiz0n9cW3q6H55w");
            useraccessdomain.setDomainIcon("j23w0d6JIUHwGPXDW7kE1Q4Gi9SLnBmpBjsQyIHuffFwn2fWjh");
            useraccessdomain.setDomainName("QeJbAcUwlPY1gHE5vP2OLFgVdiQAkQShXdDSSnuE1Ynd623M64");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("l0FaYuIgiax53XeJd8smfF9OlzRVteLdWlsMJ0vVvZWEakTHMu");
            useraccesslevel.setLevelHelp("1Er3uBbKTDmyxPXB8p7csvOzaRHMAdx8UwelVcM1RbwD0VTYIY");
            useraccesslevel.setLevelIcon("EA3jqbtLwFFe5zhPGkctggiq41orcLpBGO1FCSQ6K6OTvwPKlG");
            useraccesslevel.setLevelName("ohivLVIgSMaHLVn8sh5e0Td40Qs5juOfJEj8Ads78BUj9cEiwA");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("6qwMioud8SL8IfPlKSH0jrNbLeKgyfif3IQjq7ep6hJyZ52CdN");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(3545);
            user.setUserAccessCode(3);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(6);
            login.setIsAuthenticated(true);
            login.setLoginId("zHhmrbjoKL9SArdksiavSXPdbv0yHT7SfxTcuZS506NoBOvRt4");
            login.setServerAuthImage("4SBv8bIaEIaB3d5dEc95fbZCZT1ykuZ5");
            login.setServerAuthText("NRhD6cuD2Whb14Vs");
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
            login.setFailedLoginAttempts(1);
            login.setLoginId("9zv4hDOlrCsEXYG5m1VbgahyphuDDYuQnuMsgh2UOeEdGaBKAU");
            login.setServerAuthImage("5EGcJfndgMIpgYwg29ydCtc0FobfAX1m");
            login.setServerAuthText("uoujkoEDM05RsF7Z");
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
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
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
