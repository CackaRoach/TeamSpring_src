package com.ts.kaikei.services;

import java.util.List;
import java.util.Map;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;

public interface ManageService {

	public List<User> getUser(Map<String, Object> Params);
}
