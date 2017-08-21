/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productos;

import com.airhacks.afterburner.views.FXMLView;

/**
 *
 * @author diego
 */
public class ProductosView extends FXMLView {
    
    public ProductosPresenter getRealPresenter() {
        return (ProductosPresenter) super.getPresenter();
    }
    
}
