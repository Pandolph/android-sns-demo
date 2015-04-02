package com.avoscloud.sns;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.avos.sns.SNS;
import com.avos.sns.SNSBase;
import com.avos.sns.SNSCallback;
import com.avos.sns.SNSException;
import com.avos.sns.SNSType;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends Activity {
  private SNSType type = null;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.inject(this);
  }

  @OnClick(R.id.login_with_sina)
  void loginWithSina() {
    try {
      type = SNSType.AVOSCloudSNSSinaWeibo;
      SNS.setupPlatform(SNSType.AVOSCloudSNSSinaWeibo,
          "https://leancloud.cn/1.1/sns/goto/70uczc8byq0bgchy");
      /*
       * 这个url是在app下对应的组件中的SNS页面，在保存相应平台后的appId和app SecretId之后生成的登录URL
       * 同时，你需要将生成的回调URL，填写到相应平台的回调地址中间去
       */

      SNS.loginWithCallback(MainActivity.this, SNSType.AVOSCloudSNSSinaWeibo,
          new SNSCallback() {

            @Override
            public void done(SNSBase base, SNSException error) {
              if (error == null) {
                SNS.loginWithAuthData(base.userInfo(), new LogInCallback<AVUser>() {
                  @Override
                  public void done(AVUser user, AVException error) {

                  }
                });
              }
            }
          });
    } catch (AVException e) {
      e.printStackTrace();
    }
  }

  @OnClick(R.id.login_with_qq)
  void loginWithQq() {
    try {
      type = SNSType.AVOSCloudSNSQQ;
      SNS.setupPlatform(SNSType.AVOSCloudSNSQQ,
          "https://leancloud.cn/1.1/sns/goto/kspiihdtpzn4186e");
      /*
       * 这个url是在app下对应的组件中的SNS页面，在保存相应平台后的appId和app SecretId之后生成的登录URL
       * 同时，你需要将生成的回调URL，填写到相应平台的回调地址中间去
       */

      SNS.loginWithCallback(MainActivity.this, SNSType.AVOSCloudSNSQQ,
          new SNSCallback() {

            @Override
            public void done(SNSBase base, SNSException error) {
              if (error == null) {
                SNS.loginWithAuthData(base.userInfo(), new LogInCallback<AVUser>() {
                  @Override
                  public void done(AVUser user, AVException error) {

                  }
                });
              }
            }
          });
    } catch (AVException e) {
      e.printStackTrace();
    }
  }

  @OnClick(R.id.login_with_sina_sso)
  void loginWithSinaSso() {
    try {
      type = SNSType.AVOSCloudSNSSinaWeibo;
      SNS.setupPlatform(this, SNSType.AVOSCloudSNSSinaWeibo, "YOUR_SINA_WEIBO_APP_ID",
          "YOUR_SINA_WEIBO_APP_KEY",
          "YOUR_SINA_WEIBO_CALLBACK_URL");

      SNS.loginWithCallback(MainActivity.this, SNSType.AVOSCloudSNSSinaWeibo,
          new SNSCallback() {

            @Override
            public void done(SNSBase base, SNSException error) {
              if (error == null) {
                SNS.loginWithAuthData(base.userInfo(), new LogInCallback<AVUser>() {
                  @Override
                  public void done(AVUser user, AVException error) {

                  }
                });
              }
            }
          });
    } catch (AVException e) {
      e.printStackTrace();
    }
  }

  @OnClick(R.id.login_with_qq_sso)
  void loginWithQqSso() {
    try {
      type = SNSType.AVOSCloudSNSQQ;
      SNS.setupPlatform(this, SNSType.AVOSCloudSNSQQ, "YOUR_QQ_APP_ID",
          "YOUR_QQ_APP_KEY",
          "YOUR_QQ_CALLBACK_URL");

      SNS.loginWithCallback(MainActivity.this, SNSType.AVOSCloudSNSQQ,
          new SNSCallback() {

            @Override
            public void done(SNSBase base, SNSException error) {
              if (error == null) {
                SNS.loginWithAuthData(base.userInfo(), new LogInCallback<AVUser>() {
                  @Override
                  public void done(AVUser user, AVException error) {

                  }
                });
              }
            }
          });
    } catch (AVException e) {
      e.printStackTrace();
    }
  }



  /**
   * 需要复制onActivityResult的代码
   */

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    SNS.onActivityResult(requestCode, resultCode, data, type);
  }
}
