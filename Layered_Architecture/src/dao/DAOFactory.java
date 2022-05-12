package dao;

import dao.custom.impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getDaoFactory(){
        return daoFactory==null? daoFactory=new DAOFactory():daoFactory;
    }

    public enum DAOTypes{
        CUSTOMER,ITEM,ORDER,ORDERDETAILS,JOINQUERYDAO
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types){
            case CUSTOMER:return new CustomerDAOImpl();
            case ITEM:return new ItemDAOImpl();
            case ORDER:return new PlaceOrderDAOImpl();
            case ORDERDETAILS:return new OrderDetailDAOImpl();
            case JOINQUERYDAO:return new JoinQueryDAOImpl();
            default:return null;
        }
    }
}
