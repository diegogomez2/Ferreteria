/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import com.airhacks.afterburner.views.FXMLView;

/**
 *
 * @author diego
 */
public class ClientesView extends FXMLView {
    
    public ClientesPresenter getRealPresenter() {
        return (ClientesPresenter) super.getPresenter();
    }
    
}
