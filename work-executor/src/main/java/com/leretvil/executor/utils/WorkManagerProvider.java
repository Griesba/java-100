package com.griesba.executor.utils;

import commonj.work.WorkManager;

public interface WorkManagerProvider {
    WorkManager getWorkManager(String jndiName);
}
