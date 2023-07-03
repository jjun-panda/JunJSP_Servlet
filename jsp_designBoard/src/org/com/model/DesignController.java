package org.com.model;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.com.controller.Command;
import org.com.controller.Controller;
import org.com.model.service.DeleteCommand;
import org.com.model.service.DetailCommand;
import org.com.model.service.EditCommand;
import org.com.model.service.ListCommand;
import org.com.model.service.WriteCommand;

public class DesignController implements Controller {
	HashMap<String, Command> cmdMap = new HashMap<String, Command>();
	public DesignController() {
		cmdMap.put("/list.do", new ListCommand());
		cmdMap.put("/write.do", new WriteCommand());
		cmdMap.put("/detail.do", new DetailCommand());
		cmdMap.put("/edit.do", new EditCommand());
		cmdMap.put("/delete.do", new DeleteCommand());
	}

	@Override
	public void doProcess(HttpServletRequest req) {
		Command cmd = cmdMap.get(req.getAttribute("filePath"));
		cmd.execute(req);
	}
}
