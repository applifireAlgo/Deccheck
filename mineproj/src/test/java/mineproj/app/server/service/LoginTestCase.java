package mineproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import mineproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import mineproj.app.server.repository.LoginRepository;
import mineproj.app.shared.authentication.Login;
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
import mineproj.app.shared.contacts.CoreContacts;
import mineproj.app.server.repository.CoreContactsRepository;
import mineproj.app.shared.contacts.Gender;
import mineproj.app.server.repository.GenderRepository;
import mineproj.app.shared.location.Language;
import mineproj.app.server.repository.LanguageRepository;
import mineproj.app.shared.location.Timezone;
import mineproj.app.server.repository.TimezoneRepository;
import mineproj.app.shared.contacts.Title;
import mineproj.app.server.repository.TitleRepository;
import mineproj.app.shared.authentication.User;
import mineproj.app.server.repository.UserRepository;
import mineproj.app.shared.authentication.UserAccessDomain;
import mineproj.app.server.repository.UserAccessDomainRepository;
import mineproj.app.shared.authentication.UserAccessLevel;
import mineproj.app.server.repository.UserAccessLevelRepository;

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
            corecontacts.setAge(111);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("aifIva08lZGN9rA91Td8DMFYpncaECyeGSTdTn1FmK4KOhwSit");
            corecontacts.setFirstName("Q3NzzQr30RrX1rBKXsPGMPyUcKYDWUljazz6SywY8ZU83Usd3x");
            Gender gender = new Gender();
            gender.setGender("6GEUexC6zE9lv9Aru7tOCfMLJ69Xiy4xPPhZLNPTatZWo8oeFl");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("we");
            language.setAlpha3("FQp");
            language.setAlpha4("Vv5u");
            language.setAlpha4parentid(2);
            language.setLanguage("fgbF8nOFHlgkwhWGsepnNx0GJdzE6xisUcnJhbj6lhxy2WXKNo");
            language.setLanguageDescription("5mucF90KNUcbzmsHtQQ9iNxWeFfG3lDaWL3JEEOWoVim8HJwts");
            language.setLanguageIcon("e3ApkFv9ygWewScQtNz2xZ6LDQVeP1vN5zozI1WwNLPWYiETdo");
            language.setLanguageType("zeElDUQf5rfcOA6CDGCSNeRbdcCMUcLU");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("VBcKSvfVqVRspeCA92asGrxIZt3b4ayFy9BjOZs2OAsE2GOdkl");
            timezone.setCountry("ElMEUx1h9oJW7wwWUzsi5Xfz8sbmiXEv2jf9v6xv2gL5RGZVuh");
            timezone.setGmtLabel("vp8hOX7xYko6HgVswXQDTvas2LE84BRnMhUlNOw8cBkjfwzJoQ");
            timezone.setTimeZoneLabel("JaeMMielfJnrRy8gEesy9tmDEMbbv6fiVaOkJ8UVEihKEQc9Nw");
            timezone.setUtcdifference(9);
            Title title = new Title();
            title.setTitles("ffj01Ag25aRM8ORNXlaeuMIsblPGXZA7mjGJ2MCWjS5rKZMxcC");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(76);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("X6xtYWcNvixF95VMDdBGOysdbZwqjYkMjIhGzclDR2sZZLYmR3");
            corecontacts.setFirstName("cZU9Z7cO9GVevr0E9SksNxs2JCHCEXypmyOpCnlCHai7k91x3G");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("oi1MEoDF6YoQ9KBMjIEva1ZxtTGAvjicA9IWaX7QSsn6WIl72d");
            corecontacts.setMiddleName("ASboFgjXFVV6K13jArBf51Epfk7HrAQ2fHfK26e1XVUXYv1Oj6");
            corecontacts.setNativeFirstName("f9fvGDB3ZbUd8SEb6dH1psoi0QX7bbGgmHPMW5xEhZyaJ83xj1");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("ZXu1gRL7Cpn2N2YhWWSof99bGH2Qo5cSkst4xaXMwGjqVN3NnM");
            corecontacts.setNativeMiddleName("AMfGxDWWeAzijFmqXhKmx4Ct5EIRYGEfrWnF2TCkiOVxpdUgbL");
            corecontacts.setNativeTitle("glSqRCVogAXUs8p5TFZEKoux201O1pVdAZB5aS8VHUM2IzrQBs");
            corecontacts.setPhoneNumber("7lKBXHoHQDFDFgDoiJ5S");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("5aQPKidM7htIoPBrkARnsIzvRqk1XHNAhQ61bTRsVdUtv1OwL6");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1778);
            user.setUserAccessCode(6);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("O7d2TG2uHQWOs9rUw5UGnwk3tmgpFA0Y2l7S4eUK5dHWok5mkJ");
            useraccessdomain.setDomainHelp("hJ4FJlJrTFTj7NOty2vVswvv69tW1LGuHZXElMMyJbVuO6esuW");
            useraccessdomain.setDomainIcon("w4EYPC3Z6GoeEgoF6OzhczIBio2REiDyV6VnzrgaRfk1Y71ajb");
            useraccessdomain.setDomainName("xMmg8496r2o0r9hpMQZMPnLTvtDdoY2vGY76hKZcW46WjVa7H2");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("2nroz6CkIJNMxBjzbIeNU5m4vcSVHR1WMcPkovkh5eRcbAraVA");
            useraccesslevel.setLevelHelp("Ytx0pATZOd1c5qJsQjtpSuHGVVOcQ1NQzo87ajIjJq8dQSL42h");
            useraccesslevel.setLevelIcon("dfFMmiqJPZe2i3BEXqShwTFO3MabiKEEBp3qGiRBdgnWsoi5WM");
            useraccesslevel.setLevelName("T1JFsPs5dgh7dOHnn5Ayd7e6SNitoZwYQuFx5nRzjWOPptisF6");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("3XtdSo2J85JveVyQ3V1byIJHVCrEwywL2KBTZENwbiMdOKZheE");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2466);
            user.setUserAccessCode(7);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(3);
            login.setIsAuthenticated(true);
            login.setLoginId("z4lZyK05JOPepq78AMzBU9vXnTexFLCnE2sOewXGIuHMN3dhrN");
            login.setServerAuthImage("TB79TfjMNPwURTsqzOrxmNs2pyjYWYtI");
            login.setServerAuthText("5vSWEhe3paypKj7S");
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
            login.setFailedLoginAttempts(6);
            login.setLoginId("mZP9VsndPyGu5Z81JlEcnbb1FM6RHdOen907WCmXFPWQETkkbR");
            login.setServerAuthImage("ZCrCNeUNinOm5yMHl5VCSOId6x1OAEbW");
            login.setServerAuthText("DP3kV3zopT6l8hG1");
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
