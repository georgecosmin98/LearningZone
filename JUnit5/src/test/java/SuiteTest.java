import com.banking.BankAccountTest;
import com.banking.BankAccountTestParameterized;
import com.challenges.UtilitiesTest;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({UtilitiesTest.class, BankAccountTest.class, BankAccountTestParameterized.class})
//@Suite
//@SelectPackages({"com.challenges"})
 class SuiteTest {
}
