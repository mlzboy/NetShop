/**
 * 
 */
package com.lexus.util;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>Title: bookstoressh</p>
 *
 * <p>Description: bookstore System</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: ascenttech</p>
 *
 */
public class AppContext {

  private static AppContext instance;

  private AbstractApplicationContext appContext;

  public synchronized static AppContext getInstance() {
    if (instance == null) {
      instance = new AppContext();
    }
    return instance;
  }

  private AppContext() {
    this.appContext = new ClassPathXmlApplicationContext(
        "applicationContext.xml");
  }

  public AbstractApplicationContext getAppContext() {
    return appContext;
  }
}
