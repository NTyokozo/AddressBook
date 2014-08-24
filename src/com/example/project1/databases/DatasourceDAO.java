package com.example.project1.databases;


import com.example.project1.domain.CustomerInfo;

import java.util.List;

/**
 * Created by nobubele on 2014/08/15.
 */
public interface DatasourceDAO
{


    public void createCustomer(CustomerInfo customerInfo);
    public void updateCustomer (CustomerInfo customerInfo);
    public CustomerInfo findCustomerByID(int id);
    public void deleteCustomer(CustomerInfo customerInfo);
    public List<CustomerInfo> getCustomerInfo();
    public CustomerInfo getContact();

}
