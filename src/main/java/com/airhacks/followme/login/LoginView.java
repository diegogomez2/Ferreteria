/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.followme.login;

import com.airhacks.afterburner.views.FXMLView;

/**
 *
 * @author diego
 */
public class LoginView extends FXMLView {
    
    public LoginPresenter getRealPresenter() {
        return (LoginPresenter) super.getPresenter();
    }
    
}
