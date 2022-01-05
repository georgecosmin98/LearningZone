import com.banking.BankAccountTestParameterized;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages({"com.challenges", "com.banking"})
@SelectClasses(BankAccountTestParameterized.class)
 class SuiteTest {
}
