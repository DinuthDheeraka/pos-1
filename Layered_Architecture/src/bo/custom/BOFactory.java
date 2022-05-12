package bo.custom;

import bo.custom.impl.CustomerBOImpl;
import bo.custom.impl.ItemBOImpl;
import bo.custom.impl.PurchaseOrderBOImpl;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getBoFactory(){
        return boFactory==null? boFactory = new BOFactory():boFactory;
    }

    public enum BOTypes{
        CUSTOMER,ITEM,ORDER
    }

    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case ITEM:return new ItemBOImpl();
            case ORDER:return new PurchaseOrderBOImpl();
            case CUSTOMER:return new CustomerBOImpl();
            default:return null;
        }
    }
}
