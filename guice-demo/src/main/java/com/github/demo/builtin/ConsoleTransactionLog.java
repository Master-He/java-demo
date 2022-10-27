package com.github.demo.builtin;


import com.google.inject.Singleton;

import javax.inject.Inject;
import java.util.logging.Logger;

@Singleton
public class ConsoleTransactionLog implements TransactionLog {

    private final Logger logger;

    @Inject
    public ConsoleTransactionLog(Logger logger) {
        this.logger = logger;
    }

    public void logConnectException(Exception e) {
        /* the message is logged to the "ConsoleTransacitonLog" logger */
        logger.warning("Connect exception failed, " + e.getMessage());
    }
}

