package pl.osp.osptemplate.di.component;

import dagger.Component;
import pl.osp.osptemplate.di.scope.ActivityScope;
import pl.osp.osptemplate.ui.activity.MainActivity;

/**
 * Created by WSienski on 18/04/2016.
 */
@ActivityScope
@Component(dependencies = AppComponent.class)
public interface ActivityComponent extends AppComponent {

    void inject(MainActivity mainActivity);

}
