package org.com.controller;

import javax.servlet.http.HttpServletRequest;

public interface Controller {
    void doProcess(HttpServletRequest req);
}
