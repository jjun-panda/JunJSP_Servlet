package org.com.model;

import org.com.controller.Command;

public interface DesignCommand extends Command {
	DesignDAO designDAO = new DesignDAO();
}
