package com.vip.exam.android_concepts.Dragger_Databinding_MVVM.dragger;



import com.vip.exam.android_concepts.Dragger_Databinding_MVVM.app_datas.AppDataManager;
import com.vip.exam.android_concepts.Dragger_Databinding_MVVM.repository.MainRepository;
import com.vip.exam.android_concepts.Dragger_Databinding_MVVM.view.MainActivityDragger;
import com.vip.exam.android_concepts.Dragger_Databinding_MVVM.viewmodel.MainViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by vipin on 20/2/17.
 */

@Singleton
@Component(modules={AppModule.class, NetModule.class})
public interface NetComponent {

    void inject(MainActivityDragger activity);
    void inject(AppDataManager share);
    void inject(MyApp myApp);
    void inject(MainViewModel mainViewModel);
    void inject(MainRepository mainRepository);

    // void inject(Fragment_Drag fragment);
    /*// dragger in fragment inject
        ((MyApp) getActivity().getApplication()).getNetComponent().inject(this);*/
}