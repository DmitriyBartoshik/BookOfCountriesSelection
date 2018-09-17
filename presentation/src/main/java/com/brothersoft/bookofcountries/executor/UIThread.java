package com.brothersoft.bookofcountries.executor;


import javax.inject.Inject;
import javax.inject.Singleton;
import com.brothersoft.domain.executors.PostExecutionThread;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

@Singleton
public class UIThread implements PostExecutionThread {

    @Inject
    public UIThread() {
    }

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
