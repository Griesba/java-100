package com.example.demo.utils;

import commonj.work.WorkManager;

public interface WorkManagerProvider {
    WorkManager getWorkManager(String jndiName);
}
