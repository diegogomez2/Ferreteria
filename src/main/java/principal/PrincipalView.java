/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import com.airhacks.afterburner.views.FXMLView;

/**
 *
 * @author diego
 */
public class PrincipalView extends FXMLView {
    
    public PrincipalPresenter getRealPresenter() {
        return (PrincipalPresenter) super.getPresenter();
    }
    
}
