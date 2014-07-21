package com.prestamos.exception;

import org.apache.log4j.Logger;

public class DaoException extends Exception {

    private static final Logger log = Logger.getLogger(DaoException.class);
    
	public DaoException() {
		log.error("Ocurrio un error en el sitema");
	}

	public DaoException(String arg0) {
		super(arg0);
                log.error(arg0);
	}

	public DaoException(Throwable arg0) {
		super(arg0);
                log.error("Ocurrio un error en el sistema", arg0);
	}

	public DaoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
                log.error("Ocurrio un error en el sistema", arg1);
	}

	public DaoException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
                log.error("Ocurrio un error en el sistema", arg1);
	}

}
