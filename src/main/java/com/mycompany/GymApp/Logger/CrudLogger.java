package com.mycompany.GymApp.Logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class CrudLogger {
    private final Logger logger;
    private final String entityName;

    private CrudLogger(Class<?> owner, String entityName) {
        this.logger = Logger.getLogger(owner.getName());
        this.entityName = owner.getName();
    }

    public static CrudLogger of(Class<?> owner) {
        return new CrudLogger(owner, owner.getName());
    }

    public void selected(Long id) {
        logger.log(Level.INFO, () -> entityName + " selected: id=" + id);
    }

    public void created(Long id) {
        logger.log(Level.INFO, () -> entityName + " created: id=" + id);
    }

    public void updated(Long id) {
        logger.log(Level.INFO, () -> entityName + " updated: id=" + id);
    }

    public void deleted(Long id) {
        logger.log(Level.INFO, () -> entityName + " deleted: id=" + id);
    }

    public void notFound(String operation, Long id) {
        logger.log(Level.WARNING, () -> entityName + " not found for " + operation + ": id=" + id);
    }

    public void exceptionMessage(Exception e) {
        logger.log(Level.WARNING, () -> e.getMessage());

    }

}