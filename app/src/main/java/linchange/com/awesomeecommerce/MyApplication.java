package linchange.com.awesomeecommerce;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

import linchange.com.core.app.Awesome;
import linchange.com.core.net.intercepts.DebugInterceptor;
import linchange.com.ec.database.DatabaseManager;

/**
 * Created by lkmc2 on 2017/12/27.
 * 全局应用
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

//        Iconify.with(new FontAwesomeModule());
        Awesome.init(this) //初始化全局配置对象
                .withIcon(new FontAwesomeModule()) //配置图标
//                .withIcon(new FontEcModule())
                .withApiHost("http://or6naol85.bkt.clouddn.com/") //配置主机地址
                .withLoaderDelayed(1000) //延迟加载1s
                .withInterceptor(new DebugInterceptor("index", R.raw.test))
                .withWeChatAppId("") //微信appId
                .withWeChatAppSecret("") //微信密匙
                .configure(); //配置完成
        initStetho(); //初始化数据库查看工具
        DatabaseManager.getInstance().init(this); //初始化数据库管理器
    }

    /**
     * 初始化数据库查看工具
     */
    private void initStetho() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                 .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build()
        );
        //Chrome查看网址 chrome://inspect/#devices
    }
}
