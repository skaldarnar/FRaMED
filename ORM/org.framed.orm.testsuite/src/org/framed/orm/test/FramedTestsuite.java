package org.framed.orm.test;

import org.framed.orm.model.tests.ORMAllTests;
import org.framed.orm.ui.tests.FramedAllUiTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * This class collects all test suites.
 * 
 * @author Lars Schuetze
 * 
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({ORMAllTests.class, FramedAllUiTests.class})
public class FramedTestsuite {
  /*
   * This class remains empty
   */
}
